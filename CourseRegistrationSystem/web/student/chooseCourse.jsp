<%-- 
    Document   : chooseCourse
    Created on : Jan 2, 2014, 9:35:44 AM
    Author     : josephstalin
--%>
<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@page import="DAOFactory.CourseDAO"%>
<%@page import="DAOFactory.DAOFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="DAOFactory.Course"%>
<%@page import="java.util.List"%>
<%@page import="CloudServlet.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/offcanvas.css" rel="stylesheet">
        <title>选课页面</title>
        <%
            LoginBean login = (LoginBean) session.getAttribute("login");
            String state = (String) session.getAttribute("state");

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
            <%
                if (state != null) {
            %>
            <div id="alert" class="alert alert-danger fade in">
                <button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
                <h4>提示</h4>
                <p><%=state%></p>
                <p>
            </div>
            <%
                }
            %>
            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs">
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="row">
                        <%
                            DAOFactory cloudFactory = DAOFactory.getDAOFactory();

                            CourseDAO couDAO = cloudFactory.getCourseDAO();

                            CachedRowSet cr = couDAO.displayChooseCourse(login.getUsername());
                            while (cr.next()) {
                                int cid = cr.getInt("cid");

                                String name = cr.getString("cname");

                                int pid = cr.getInt("pid");

                                int room_id = cr.getInt("location");

                                int cour_time = cr.getInt("classtime");

                                String tea_name = cr.getString("tname");

                        %>


                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <img data-src="holder.js/300x200" alt="..." src="../images/avatar.png">
                                <div class="caption">
                                    <h3><%=name%></h3>
                                    <p>课程计划号： <%=pid%></p>
                                    <p>课程号： <%=cid%></p>
                                    <p>上课地点： <%=room_id%></p>
                                    <p>上课时间： <%=cour_time%></p>
                                    <p>老师姓名： <%=tea_name%></p>
                                    <p>
                                        <a href="#" data-toggle="modal" data-target="#deleteModal" class="btn btn-primary" role="button">选择</a>
                                        <a type="button" class="btn btn-danger" href="../ChooseCourseServlet?sid=<%=login.getUsername()%>&pid=<%=pid%>">确认选择</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <!-- Modal -->
                        <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel">警告</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>是否选择这个课程</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a type="button" class="btn btn-default" data-dismiss="modal">取消</a>
                                        <a type="button" class="btn btn-danger" href="../ChooseCourseServlet?sid=<%=login.getUsername()%>&pid=<%=pid%>">确认选择</a>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal-dialog -->
                        </div><!-- /.modal -->
                        <%
                            }
                        %>
                    </div>
                </div><!--/span-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="student.jsp" class="list-group-item">学生主页</a>
                        <a href="#" class="list-group-item active">选课管理</a>
                        <a href="displayScore.jsp" class="list-group-item">成绩查询</a>
                        <a href="../setting.jsp" class="list-group-item">个人设置</a>
                    </div>
                </div><!--/span-->
            </div><!--/row-->
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="../js/jquery.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script src="../js/bootstrap.min.js"></script>
            <script src="../js/offcanvas.js"></script>
    </body>
</html>
