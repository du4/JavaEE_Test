<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>



<table width="100%" border="1" cellpadding="1" cellspacing="1">
    <tr>
        <td align="center"> <b>LOGIN</b></td>
        <td align="center"><b>EMAIL</b></td>
        <td align="center"><b>ROLE</b></td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td align="center"> ${user.login}</td>
            <td align="center">${user.email}</td>
            <td align="center">${user.role}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>
