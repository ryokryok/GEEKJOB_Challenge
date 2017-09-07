<%-- 
    Document   : javakadai8-2
    Created on : 2017/09/06, 13:08:22
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
            String x = "";
            for (int i = 0;i < 30;i++){
                x = x + "A";
            }
            out.println(x + "<br>");
            %>
    </body>
</html>
