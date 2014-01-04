<%-- 
    Document   : teacher
    Created on : Dec 31, 2013, 3:42:43 PM
    Author     : josephstalin
--%>

<%@page import="CloudServlet.LoginBean"%>
<%@page import="CloudServlet.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/offcanvas.css" rel="stylesheet">
        <title>教师界面</title>
        <%
            LoginBean login = (LoginBean) session.getAttribute("login");

            if (login == null) {
                session.setAttribute("error", "nologin");
                response.sendRedirect("../index.jsp");
            }
        %>
    </head>
    <body>

        <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">CRS Project</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">主页</a></li>
                        <li><a href="../loginOut.jsp">注销</a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div><!-- /.container -->
        </div><!-- /.navbar -->

        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs">
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron">
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img data-src="holder.js/100%x180" alt="..." src="../<%=(String) UserService.getPicture(login.getUuid())%>">
                            </a>
                        </div>

                        <h1>Hello, <%=(String) UserService.getNackname(login.getUuid())%></h1>
                        <p>这是一个教师界面</p>
                    </div>
                </div><!--/span-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">教师主页</a>
                        <a href="listCourse.jsp" class="list-group-item">查看课程</a>
                        <a href="../setting.jsp" class="list-group-item">个人设置</a>
                    </div>
                </div><!--/span-->
            </div><!--/row-->


            <footer class="navbar-fixed-bottom">
                <hr>
                <p>&copy; Company 2013</p>
            </footer>

        </div><!--/.container-->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="../js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
