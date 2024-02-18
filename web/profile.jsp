<%@ page import="java.util.List" %>
<%@ page import="kz.bitlab.shop.items.entity.Item" %>
<%@ page import="kz.bitlab.shop.users.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="bootstrap.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="text-center">
    <% User user = (User) request.getAttribute("user"); %>
    <h1>Hello, <%= user.getFullName() %>!</h1>
    <p>This is your profile page</p>
</div>

</body>
</html>

