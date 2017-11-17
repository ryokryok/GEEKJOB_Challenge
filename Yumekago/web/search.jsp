<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    import="kagoyume.ShopBean"
    import="java.util.ArrayList"
    import="javax.servlet.http.HttpSession"        
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    ArrayList<ShopBean> storeList = new ArrayList();
    if (session.getAttribute("storeList") != null) {
        storeList = (ArrayList<ShopBean>) session.getAttribute("storeList");
    }

    String search = "";
    boolean errFlg = false;
    if (!(request.getAttribute("search").equals(""))) {
        search = String.valueOf(request.getAttribute("search"));
    }else{
        errFlg = true;
    };
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="page-header">
                <%=yh.header()%>
                <%=yh.msg(udd)%>
            </div>
            <%if(search != null){
                out.print(yh.search(search));
            }else{
                out.print(yh.search());
            }%>
        </div>
        <div class="container">
            <div class="row">
                <% if (storeList != null) { %>
                <% for (ShopBean good : storeList) {%>
                <div class="col-md-12">
                    <a href="Item?code=<%=good.getCode()%>">
                        <img src="<%=good.getImgMd()%>" alt="goodsImage"
                             class="pull-left img-responsive" style="margin: 0 15px;">
                    </a>
                    <a href="Item?code=<%=good.getCode()%>">
                        <p class="h4"><%=good.getName()%></p>
                    </a>
                    <p class="h3 clearfix"><%=good.getPrice()%> 円</p>
                </div>
                <% ;
                    }%>
                <% ;
                    }%>
            </div>
        </div>
    </body>
</html>
