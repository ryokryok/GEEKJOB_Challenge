<%-- 
    Document   : javakadai5-3
    Created on : 2017/09/05, 17:47:29
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
          char x = '1';
          switch(x) {
              case 'A' :
                  out.println("英語");
                  break;
              case 'あ' :
                  out.println("日本語");
                  break;
              default :
                  break;

          }  
            %>
    </body>
</html>
