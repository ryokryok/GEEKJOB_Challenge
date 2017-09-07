<%-- 
    Document   : javakadai6-1
    Created on : 2017/09/06, 10:23:37
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
        <%@ page import="java.util.ArrayList" %>
        <%
            ArrayList<String> datas = new ArrayList<String>();
            datas.add("10");
            datas.add("100");
            datas.add("soeda");
            datas.add("hayashi");
            datas.add("-20");
            datas.add("118");
            datas.add("END");
            datas.set(2, "33");
            out.println(datas);
            
            %>
    </body>
</html>
