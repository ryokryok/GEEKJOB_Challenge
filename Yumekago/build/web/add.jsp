<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    import="kagoyume.ShopBean"
    import="java.util.ArrayList"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    ShopBean good = (ShopBean) session.getAttribute("good");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Yumekago</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="page-header">
                <%=yh.header()%>
                <%=yh.msg(udd)%>
            </div>
            <%=yh.search()%>
        </div> 
        <div class="container">
            <div class="row">
                <h3>カートに追加しました</h3>
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="Item?code=<%=good.getCode()%>">
                            <img src="<%=good.getImgMd()%>" alt="goodsImage"
                                 class="pull-left img-responsive" style="margin: 0 15px;">
                        </a>
                        <p class="h4 text-left">
                            <a href="Item?code=<%=good.getCode()%>">
                                <%=good.getName()%>
                            </a>
                        </p>
                        <p class="h3 text-right"><%=good.getPrice()%> 円</p>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
