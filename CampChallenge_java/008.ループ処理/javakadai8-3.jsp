<%-- 
    Document   : javakadai8-3
    Created on : 2017/09/06, 13:11:42
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
            int x = 0;
            for (int i = 0;i < 101;i++){
                x = x + i;
                
            }
            out.println(x + "<br>");
            %>
    </body>
</html>
