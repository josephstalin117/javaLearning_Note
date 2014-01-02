<%-- 
    Document   : updateCourse
    Created on : Jan 1, 2014, 8:01:57 PM
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
        <title>JSP Page</title>
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

        <%
            String cid = request.getParameter("cid");
        %>

        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs">
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron">
                        <form role="form" action="../UpdateCourseServlet" method="post" class="form-horizontal">
                            <div class="form-group">
                                <input type="hidden" class="form-control" id="inputSid" placeholder="课程号" name="cid" value="<%=cid%>">
                            </div>
                            <div class="form-group">
                                <label for="inputCname">课程名</label>
                                <input type="text" class="form-control" id="inputSname" placeholder="课程名" name="cname">
                            </div>
                            <div class="form-group">
                                <label for="inputDid">课程简介</label>
                                <input type="text" class="form-control" id="inputDid" placeholder="课程简介" name="cintroduction">
                            </div>
                            <div class="form-group">
                                <label for="inputSpid">学分</label>
                                <input type="text" class="form-control" id="inputSpid" placeholder="学分" name="credit">
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block" id="submit">Submit</button>
                        </form>

                    </div>
                </div><!--/span-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="admin.jsp" class="list-group-item">管理员主页</a>
                        <a href="getStudent.jsp" class="list-group-item">学生列表</a>
                        <a href="addStudent.jsp" class="list-group-item">添加学生</a>
                        <a href="findStudent.jsp" class="list-group-item">查找学生</a>
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
