<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<jsp:useBean id="udb" class="jums.UserDataBeans" scope="session" />
<%
    HttpSession hs = request.getSession();
    
    String uName = udb.getName();
    String uYear = udb.getYear();
    String uMonth = udb.getMonth();
    String uDay = udb.getDay();
    String uType = udb.getType();
    String uTell = udb.getTell();
    String uComment= udb.getComment();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <%@page import="jums.JumsHelper"%>
        
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name"
               value="<% if (uName != null) { out.print(uName); } else { out.print("");}%>">
        
        <br><br>
        生年月日:　
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ 
                String s = String.valueOf(i);
            %>
            <option 
                value="<%=i%>" <% if(udb != null && s.equals(uYear)){ out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){
                String s = String.valueOf(i);
            %>
            <option value="<%=i%>" <%if (udb != null && s.equals(uMonth)) { out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ 
                String s = String.valueOf(i);%>
            <option value="<%=i%>" <%if (udb != null && s.equals(uDay)) { out.print("selected=\"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1"　
               <% if ("1".equals(uType)) { out.print("checked"); }%> >エンジニア<br>
        <input type="radio" name="type" value="2"
               <% if ("2".equals(uType)) { out.print("checked"); }%>>営業<br>
        <input type="radio" name="type" value="3"
               <% if ("3".equals(uType)) { out.print("checked"); }%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" 
               value="<% if (uTell != null) { out.print(uTell); }%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none"
                  wrap="hard"><% if (uComment != null) { out.print(uComment); }%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
