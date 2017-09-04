<%-- 
    Document   : javakadai3
    Created on : 2017/09/04, 11:08:48
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
            final int BASE = 24;
            int num = 3;
            //足し算
            int tasu = BASE + num;
            //引き算
            int hiku = BASE - num;
            //掛け算
            int kakeru = BASE * num;
            //割り算
            int waru = BASE / num;
            //余り
            int amari = BASE % num;
            out.print("定数は" + BASE + "<br>");
            out.print("変数は" + num + "<br>");
            out.print("足し算結果:" + tasu + "<br>");
            out.print("引き算結果:" + hiku + "<br>");
            out.print("掛け算結果:" + kakeru + "<br>");
            out.print("割り算結果:" + waru + "<br>");
            out.print("余り結果:" + amari + "<br>");

            %>
    </body>
</html>
