<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
    <property name="basename" value="Messages"/>
</bean>
<html xmlns="http://www.w3.org/1999/xhtml"></html>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<meta charset="utf-8"/>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" errorPage="../../error.jsp" %>

<html>


<head th:fragment="headerFragment">
    <title>Oblicz silnie</title>
</head>

<body>
<script type="text/javascript">
    function mojsubmit() {
        this.document.getElementById("form").action = this.document.getElementById("selectAction").value;
        return true;
    }
</script>
<p th:title="lolopierdolo"/>

<form id="form" method="post" accept-charset="utf-8" action="/template1.html">
    <input type="submit"/>
</form>
<form id="form" method="POST" accept-charset="utf-8" action="/recursion.s" onsubmit="return mojsubmit()">

    <%--<span th:text="olol"></span>--%>
    <%--<p th:text="#{welcome1}">Welcome everyone!</p>--%>


    <select id="selectAction">
        <option value="/recursion.s">choose recursion method for counting silnia</option>
        <option value="/iterating.s">choose iterating method for counting silnia</option>
    </select>


    <input type="number" name="n"/>
    <input type="submit" value="wy?lij zapytanie" var="btn1"/>

    <input type="reset" value="Wyczysc"/>
</form>


<thymesVar id="message" type="scdcs"></thymesVar>
<p th:text="${message}"></p>


<tr>
    <th:each items="${silniaList}">
        <th:li>${silniaList}</th:li>
    </th:each>
</tr>

</form>


</body>

</html>
