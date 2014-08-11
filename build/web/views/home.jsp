<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <% models.User currentuser = (models.User) session.getAttribute("currentuser");%>
        <h1>Welcome, <%=currentuser.getUsername()%></h1>
        <a href="logout">Logout</a>
    </body>
</html>
