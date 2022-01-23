<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Admin Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">
    <%-- --%>
    <style>
        #edit_form_div {
            display: none;
        }

        table, th, td {
            background-color: lightgrey;
            border: 1px solid black;
        }

        #admin_add_good_button {
            background-color: forestgreen;
            padding: 15px 40px;
        }


        input.delete_button {
            background-color: red;
            padding: 15px 40px;


        }

        input.edit_button {
            background-color: blue;
            padding: 15px 40px;


        }


    </style>

</head>
<body>
<script type="text/javascript">

    function call_add_form() {
        window.location.href = '${pageContext.request.contextPath}' + "add_good/";

    }

    function call_update_form(g_Id) {

        let url = '${pageContext.request.contextPath}' + "update_good/";
        window.location.href = url + g_Id;

    }

    function delete_good() {
        let isConfirmed = confirm("Are you sure you want to delete the good? \nThis action is irreversible.");
        if (isConfirmed === false) {
            window.location.reload();
        }
    }


</script>

<h3>ADMIN PAGE GOODS</h3>

<input id="admin_add_good_button" type="submit" name="add_good" onclick="call_add_form()" value="Add good"/>

<jsp:include page="header_menu.jsp"/>

<a id="admin_logout_button" href="/logout">Log out </a>


<table id="admin_goods_table">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Category</th>
    <th>Subcategory</th>
    <th>Trademark</th>
    <th>Country</th>
    <th>Price</th>
    <th>Amount</th>
    <th>Description</th>
    <th>Created At</th>
    <th>Updated At</th>
    </thead>

    <c:forEach items="${getAllGoods}" var="good">
        <tr>
            <td>${good.goodId}</td>
            <td>${good.name}</td>
            <td>${good.category}</td>
            <td>${good.subcategory}</td>
            <td>${good.trademark}</td>
            <td>${good.countryName}</td>
            <td>${good.price}</td>
            <td>${good.amount}</td>
            <td>${good.goodDescription}</td>
            <td><fmt:formatDate value="${good.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${good.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

            <td><input class="edit_button" type="submit" value="Update" onclick="(call_update_form(${good.goodId}))"/>
            </td>
            <div id="update_form_div_${good.goodId}" style="display: none"></div>

            <form:form method="post" action="${pageContext.request.contextPath}/admin/goods/delete_good/${good.goodId}">
                <td><input class="delete_button" type="submit" value="Delete" onclick="delete_good(${good.goodId})"/>
                </td>
            </form:form>

        </tr>
    </c:forEach>


</table>


</body>
</html>