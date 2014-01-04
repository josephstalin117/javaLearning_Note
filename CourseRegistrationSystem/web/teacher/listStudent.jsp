<%-- 
    Document   : listStudent
    Created on : Jan 2, 2014, 9:36:46 PM
    Author     : josephstalin
--%>
<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@page import="DAOFactory.TeacherDAO"%>
<%@page import="DAOFactory.DAOFactory"%>
<%@page import="CloudServlet.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/offcanvas.css" rel="stylesheet">
        <title>学生列表</title>
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
                            String pid = request.getParameter("pid").trim();
                            DAOFactory cloudFactory = DAOFactory.getDAOFactory();

                            TeacherDAO teaDAO = cloudFactory.getTeacherDAO();

                            CachedRowSet cr = teaDAO.getStudents(pid);
                            while (cr.next()) {
                                int sid = cr.getInt("sid");

                                String sname = cr.getString("sname");


                        %>

                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <img data-src="holder.js/300x200" alt="..." src="../images/avatar.png">
                                <div class="caption">
                                    <p>学号： <%=sid%></p>
                                    <p>姓名： <%=sname%></p>
                                    <p>
                                        <a href="marking.jsp?sid=<%=sid%>" class="btn btn-primary" role="button">打分</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div><!--/span-->

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="teacher.jsp" class="list-group-item">教师主页</a>
                        <a href="#" class="list-group-item active">教授课程</a>
                        <a href="../setting.jsp" class="list-group-item">个人设置</a>
                    </div>
                </div><!--/span-->
            </div><!--/row-->


            <footer class="">
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
