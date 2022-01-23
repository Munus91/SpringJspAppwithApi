<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>ADD GOOD</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">

    <style>

        #error_message {
            color: red;
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

        #add_new_good_form {

            position: absolute;
            right: 650px;
            top: 30px;
            width: 400px;
            border: #333333;
            border-color: black;
            background-color: gray;
            /* border-width: .25em;*/
            border-width: 6px;
            z-index: 2;
        }
    </style>

</head>
<body>
<script type="text/javascript">

    function check_field(){
    }

</script>


<form:form id="add_new_good_form" method="post" modelAttribute="good_for_add"
           action="${pageContext.request.contextPath}/admin/goods/add_good/">
    <form:errors id="error_message" path="*" cssClass="error" element="div"/>
    <div id="input_fields">
        <h3>ADD GOOD: </h3>
        <br/> <form:label path="name">Name: </form:label><br/><form:input path="name" type="text"/>
        <br/> <form:label path="category">Category: </form:label><br/><form:input path="category" type="text"/>
        <br/> <form:label path="subcategory">Subcategory: </form:label><br/> <form:input path="subcategory"
                                                                                         type="text"/>
        <br/> <form:label path="trademark">TradeMark: </form:label><br/> <form:input path="trademark" type="text"/>
        <br/> <form:label path="countryName">Country: </form:label><br/>
        <form:select path="countryId">
            <c:forEach var="country" items="${getAllCountries}">
                <option value="${country.countryId}">${country.name}</option>
            </c:forEach>
        </form:select>
        <br/> <form:label path="price">Price: </form:label><br/> <form:input path="price" type="number" step="0.01"/>
        <br/> <form:label path="amount">Amount: </form:label><br/> <form:input path="amount" type="number"/>
        <br/> <form:label path="goodDescription">Description:
    </form:label><br/>
    </div>
    <div id="description_field">
        <form:textarea cols="35" rows="3" path="goodDescription" type="text"/><br/>
    </div>

    <div id="button_fields">
        <input type="submit" onclick="check_field()" name="submit_add" value="Ok"/>
        <input type="button" value="Cancel" onclick="window.location.href=history.back();"/>
    </div>
</form:form>


</body>
</html>