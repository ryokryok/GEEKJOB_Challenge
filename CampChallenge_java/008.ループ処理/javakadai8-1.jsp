<%-- 
    Document   : javakadai8-1
    Created on : 2017/09/06, 12:00:23
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
            long x = 1;
            for (int i = 0;i < 20;i++){
                x *= 8;
                out.println(x + "<br>");
            }
            %>
    </body>
</html>
