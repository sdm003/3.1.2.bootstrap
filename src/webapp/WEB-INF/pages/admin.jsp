<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        #add {
            position: absolute;
            right: 900px;
            top: -10px;
        }

    </style>
</head>
<body>
<h1>Users:</h1>
<table >
    <tr>
        <th width="80">Id</th>
        <th width="120">Name</th>
        <th width="120">Street</th>
        <th width="100">Age</th>
        <th width="55"></th>
        <th width="50"></th>
    </tr>
    <c:forEach items="${listPersons}" var="user">
        <tr>
            <td align="center">${user.id}</td>
            <td align="center">${user.name}</td>
            <td align="center">${user.street}</td>
            <td align="center">${user.age}</td>
            <td>
                <form action="<c:url value="/admin/edit"/>" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="<c:url value="/admin/delete"/>" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>

    </c:forEach>
</table>
<h2 align="center" border="1" cellpadding="5"><a href="<c:url value='/login/logout' />" >Logout</a></h2>
<div id="add">
    <h1>Add User</h1>
    <form action="<c:url value="/admin/newuser"/>" method="get">
        <input type="submit" value="Add ">
    </form>
</div>
</body>
</html>

