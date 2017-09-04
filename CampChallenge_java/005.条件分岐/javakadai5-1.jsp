<%-- 
    Document   : javakadai5-1
    Created on : 2017/09/04, 11:41:24
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
            int num = 2;
            if (num == 1){
                out.println("１です！");
            }
            else if (num == 2){
                out.println("プログラミングキャンプ！");
            }
            else {
                out.println("その他です！");
            }
            
            %>
    </body>
</html>
