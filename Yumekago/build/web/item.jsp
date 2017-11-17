<%@page 
    import="kagoyume.YumeHelper"
    import="kagoyume.UserDataDTO"
    import="kagoyume.ShopBean"
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YumeHelper yh = YumeHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
    ShopBean good = (ShopBean) session.getAttribute("good");
    String search = (String) session.getAttribute("search");
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
            <%=yh.search()%>
        </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <% if (good != null) {%>
                        <a href="Item?code=<%=good.getCode()%>">
                            <img src="<%=good.getImgMd()%>" alt="goodsImage"
                                 class="pull-left img-responsive" style="margin: 0 15px;">
                        </a>
                        <a href="Item?code=<%=good.getCode()%>">
                            <p class="h4"><%=good.getName()%></p>
                        </a>
                        <p class="h3 clearfix"><%=good.getPrice()%> 円</p>
                        <p class="lead"><%=good.getScript()%></p>

                        <% ;
                        }%>
                    </div>
                </div>
                <div class="form-group">
                    <form action="Cart" class="form-inline" method="POST">
                        <button class="btn btn-success" type="submit" name="add" value="add">
                            カートに追加する
                        </button>
                    </form>
                </div>

            </div> 
    </body>
</html>
