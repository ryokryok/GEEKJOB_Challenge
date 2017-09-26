<%-- 
    Document   : test
    Created on : 2017/09/21, 11:25:39
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
            out.println("総額 " + request.getParameter("total") + "円" + "<br>");
            out.println(request.getParameter("count") + "個" +  "<br>");
            out.println("商品種別 : " + request.getParameter("type") + "<br>");
            int t = Integer.parseInt(request.getParameter("total"));
            int c = Integer.parseInt(request.getParameter("count"));
            out.println("1個当たりの値段 : "  + t/c + "円/個" + "<br>");
            if (5000 > t && t >= 3000){
                out.println("ポイント :" + t + "x" + "0.04 = " + t*0.04 + "ポイント" + "<br>");
                
            }else if((t >= 5000)){
                out.println("ポイント :" + t + "x" + "0.05 = " + t*0.05 + "ポイント" + "<br>");
            }else{
                
            }
            
            
            
            %>
    </body>
</html>
