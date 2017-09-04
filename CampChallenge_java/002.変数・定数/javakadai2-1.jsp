<%-- 
    Document   : kadai2-1
    Created on : 2017/09/04, 10:40:13
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
            String name = "Kato";
            name += " Ryo";
            int age = 25;
            String bornPlace = "Kanagawa";
            out.print("My name is " + name + ".<br>");
            out.print("I am " + age + ".<br>");
            out.print("I am from " + bornPlace + ".<br>");
            
            
            %>
    </body>
</html>
