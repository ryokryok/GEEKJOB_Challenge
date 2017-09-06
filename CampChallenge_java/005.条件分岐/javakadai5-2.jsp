<%-- 
    Document   : javakadai5-2
    Created on : 2017/09/05, 17:40:30
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
          int i = 4;
          switch(i) {
              case 1 :
                    out.println("one");
                    break;
              case 2 :
                    out.println("two");
              default:
                    out.println("想定外");
          }  
            %>
    </body>
</html>
