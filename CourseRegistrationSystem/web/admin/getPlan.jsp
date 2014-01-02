<%-- 
    Document   : getModel
    Created on : Jan 1, 2014, 4:15:18 PM
    Author     : josephstalin
--%>
<%@page import="java.util.Iterator"%>
<%@page import="DAOFactory.Plan"%>
<%@page import="java.util.List"%>
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
                            List<Plan> list = AdminServlet.AdminService.displayPlan();
                            for (Iterator<Plan> iter = list.iterator();
                                    iter.hasNext();) {
                                Plan p = iter.next();
                        %>

                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <img data-src="holder.js/300x200" alt="..." src="../images/avatar.png">
                                <div class="caption">
                                    <h3><%=p.getPid()%></h3>
                                    <p>课程号： <%=p.getCid()%></p>
                                    <p>教师号： <%=p.getTid()%></p>
                                    <p>上课地点： <%=p.getLocation()%></p>
                                    <p>上课容量： <%=p.getCapacity()%></p>
                                    <p>上课时间： <%=p.getClasstime()%></p>
                                    <p>
                                        <a href="updatePlan.jsp?pid=<%=p.getPid()%>" class="btn btn-primary" role="button">更新</a>
                                        <a data-toggle="modal" data-target="#deleteModal" class="btn btn-danger" role="button">删除</a>
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
                                        <p>是否删除这个课程</p>
                                    </div>
                                    <div class="modal-footer">
                                        <a type="button" class="btn btn-default" data-dismiss="modal">取消</a>
                                        <a type="button" class="btn btn-danger" href="../DeletePlanServlet?pid=<%=p.getPid()%>">确认删除</a>
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
                        <a href="admin.jsp" class="list-group-item">管理员主页</a>
                        <a href="#" class="list-group-item active">课程计划列表</a>
                        <a href="addPlan.jsp" class="list-group-item">添加课程计划</a>
                        <a href="findPlan.jsp" class="list-group-item">查找课程计划</a>
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
