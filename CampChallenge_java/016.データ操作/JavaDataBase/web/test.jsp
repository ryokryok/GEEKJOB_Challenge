<%-- 
    Document   : test
    Created on : 2017/09/20, 17:03:52
    Author     : ryokato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            out.println("Name : " + request.getParameter("txtName") + "<br>");
            out.println("Sex : " + request.getParameter("rdoSex") + "<br>");
            out.println("Hobby : " + request.getParameter("txtHobby") + "<br>");
            
            
            %>
    </body>
</html>
