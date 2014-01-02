<%-- 
    Document   : addPlan
    Created on : Jan 1, 2014, 8:44:33 PM
    Author     : josephstalin
--%>
<%@page import="CloudServlet.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/offcanvas.css" rel="stylesheet">
        <title>增加课程计划</title>
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
                        <li class="active"><a href="amdin.jsp">主页</a></li>
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
                        <form role="form" action="../AddPlanServlet" method="post" class="form-horizontal">
                            <div class="form-group">
                                <label for="inputCid">课程计划号</label>
                                <input type="text" class="form-control" id="inputSid" placeholder="课程计划号" name="pid">
                            </div>
                            <div class="form-group">
                                <label for="inputCname">课程号</label>
                                <input type="text" class="form-control" id="inputSname" placeholder="课程号" name="cid">
                            </div>
                            <div class="form-group">
                                <label for="inputDid">教师号</label>
                                <input type="text" class="form-control" id="inputDid" placeholder="教师" name="tid">
                            </div>
                            <div class="form-group">
                                <label for="inputSpid">上课地点</label>
                                <input type="text" class="form-control" id="inputSpid" placeholder="上课地点" name="location">
                            </div>
                            <div class="form-group">
                                <label for="inputSpid">上课容量</label>
                                <input type="text" class="form-control" id="inputSpid" placeholder="上课容量" name="capacity">
                            </div>
                            <div class="form-group">
                                <label for="inputSpid">上课时间</label>
                                <input type="text" class="form-control" id="inputSpid" placeholder="上课地点" name="classtime">
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block" id="submit">Submit</button>
                        </form>
                    </div>

                </div><!--/span-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="admin.jsp" class="list-group-item">管理员主页</a>
                        <a href="getPlan.jsp" class="list-group-item">课程计划列表</a>
                        <a href="#" class="list-group-item active">添加课程计划</a>
                        <a href="findCourse.jsp" class="list-group-item">查找课程计划</a>
                    </div>
                </div><!--/span-->
            </div><!--/row-->


            <footer class="navbar-fixed">
                <hr>
                <p>&copy; Company 2013</p>
            </footer>

        </div><!--/.container-->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="../js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/offcanvas.js"></script>
    </body>
</html>
