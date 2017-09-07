<%-- 
    Document   : javakadai8-4
    Created on : 2017/09/06, 13:27:55
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
            int x = 1000;
            while (x >= 100 ){
            out.println(x + "<br>");
            x /= 2;
            
        }
            %>
    </body>
</html>
