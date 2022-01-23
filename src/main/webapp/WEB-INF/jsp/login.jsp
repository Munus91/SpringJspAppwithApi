<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">

    <style>

        #login_form_div {

            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

        }


        input[type=text], [type=password] {


            background-color: #f6f6f6;
            border: none;
            color: #0d0d0d;
            padding: 15px 30px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px;
            /* width: 85%;*/
            border: 2px solid #f6f6f6;
            -webkit-transition: all 0.5s ease-in-out;
            -moz-transition: all 0.5s ease-in-out;
            -ms-transition: all 0.5s ease-in-out;
            -o-transition: all 0.5s ease-in-out;
            transition: all 0.5s ease-in-out;
            -webkit-border-radius: 5px 5px 5px 5px;
            border-radius: 5px 5px 5px 5px;


        }
    </style>

    <title>Log in with your account</title>
</head>

<body>

<script type="text/javascript">


</script>

<%--
<fmt:setBundle basename="messages"/>
<fmt:message key="message.password" var="noPass"/>
<fmt:message key="message.username" var="noUser"/>

--%>



<div id="login_form_div">
    <div class="wrapper fadeInDown">
        <div id="formContent">

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form:form name="f" id="login_form" method="post" modelAttribute="userForm" onsubmit="return validate();"
                       action="${pageContext.request.contextPath}/login">

                <form:errors id="error_message" path="password" cssClass="error" element="div"/>

                <c:if test="${not empty error}">
                    <div class="error" style="color: mediumvioletred ">${error}</div>
                </c:if>
                <div id="enter">

                    <form:input path="username" type="text" id="login" className="fadeIn third" name="login"
                                placeholder="login"/>
                    <form:input path="password" type="password" id="password" className="fadeIn third" name="password"
                                placeholder="password"/>
                    <input type="submit" class="fadeIn third" value="Enter"/>

                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>