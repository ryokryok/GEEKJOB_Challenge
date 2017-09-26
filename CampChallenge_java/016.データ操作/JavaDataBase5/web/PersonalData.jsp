<%-- 
    Document   : PersonalData
    Created on : 2017/09/22, 14:05:42
    Author     : ryokato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./test.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="javax.servlet.http.HttpSession" %>
        <%
            HttpSession hs = request.getSession();
            request.setCharacterEncoding("UTF-8");
            //inputed data.
            if(request.getParameter("name") != null){
               hs.setAttribute("Name", request.getParameter("name"));  
            }
            //inputed nothing.
            if(hs.getAttribute("Name") == null){
               hs.setAttribute("Name", ""); 
            }
            
            if(request.getParameter("sex") != null){
               hs.setAttribute("Sex", request.getParameter("sex")); 
            }

            if(hs.getAttribute("Sex") == null){
               hs.setAttribute("Sex",""); 
               
            }
            
            if(request.getParameter("hobby") != null){
               hs.setAttribute("Hobby", request.getParameter("hobby")); 
            }
            
            if(hs.getAttribute("Hobby") == null){
               hs.setAttribute("Hobby", request.getParameter("hobby"));
            }
        %>
        
        <div>
        <form action="./PersonalData.jsp" method="post">
            <h1>名前</h1>
            <input type="text" name="name" value="<%
                if(hs.getAttribute("Name") != null){
                   out.print(hs.getAttribute("Name")); 
                }
                %>">
            </input>
            <br>
            <h1>性別</h1>
            <p>
                <input type="radio" name="sex" value="man" <%
                if(hs.getAttribute("Sex").equals("man")){
                   out.print("checked"); 
                }
                %>>男
                <input type="radio" name="sex" value="woman" <%
                if(hs.getAttribute("Sex").equals("woman")){
                   out.print("checked"); 
                }
                %>>女
                <input type="radio" name="sex" value="other" <%
                if(hs.getAttribute("Sex").equals("other")){
                   out.print("checked"); 
                }
                %>>その他
            </p>
            <br>    
            
            <h1>趣味</h1>
            <textarea name="hobby" rows="4" cols="20"><%
                if(hs.getAttribute("Hobby") != null){
                   out.print(hs.getAttribute("Hobby")); 
                }
                %></textarea><br>
            <button type="submit" name="binSubmit" value="Send">
                <h1>Send</h1>
            </button>
            
        </form>
        </div>

    </body>
</html>
