<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Admin Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">

    <style>
        #error_message {
            color: red;
        }

        #update_good_form {
            position: absolute;
            right: 650px;
            top: 30px;
            width: 400px;
            border: #333333;
            border-color: black;
            background-color: gray;
            /*border-style: double;     to display border*/
            /* border-width: .25em;*/
            border-width: 6px;
            z-index: 2;
        }

        select {
            width: 52%;
        }

        input[type=button], input[type=submit] {

            padding: 15px 40px;

        }

        #input_fields {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        #description_field {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        #button_fields {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;

        }

    </style>
</head>
<body>
<script type="text/javascript">

</script>


<form:form id="update_good_form" method="post" modelAttribute="good_for_update"
           action="${pageContext.request.contextPath}/admin/goods/update_good/">

    <h3>Update good: </h3>
    <form:input id="up_id" path="goodId" type="hidden"/>
    <form:errors id="error_message" cssClass="error" path="*" element="div"/>
    <div id="input_fields">
        <br/><form:label path="name">Name: </form:label><br/> <form:input id="up_name" path="name" type="text"/>
        <br/><form:label path="category">Category: </form:label><br/> <form:input id="up_category" path="category"
                                                                                  type="text"/>
        <br/><form:label path="subcategory">Subcategory: </form:label><br/> <form:input id="up_subcategory"
                                                                                        path="subcategory" type="text"/>
        <br/><form:label path="trademark">TradeMark: </form:label><br/> <form:input id="up_trademark" path="trademark"
                                                                                    type="text"/>
        <br/> <form:label path="countryName">Country: </form:label><br/>
        <form:select path="countryId">
            <c:forEach var="country" items="${getAllCountries}">
                <option value="${country.countryId}">${country.name}</option>
            </c:forEach>
        </form:select>
        <br/><form:label path="price">Price: </form:label><br/> <form:input id="up_price" path="price" type="text"/>
        <br/><form:label path="amount">Amount: </form:label><br/> <form:input id="up_amount" path="amount" type="text"/>
    </div>
    <div id="description_field">
        <br/><form:label path="goodDescription">Description: </form:label>
        <br/> <form:textarea cols="35" rows="3" path="goodDescription" type="text"/><br/>
    </div>

    <div id="button_fields">
        <input type="submit" name="submit_update" value="Ok"/>
        <input type="button" value="Cancel" onclick="window.location.href=history.back();"/>
    </div>

</form:form>

</body>
</html>