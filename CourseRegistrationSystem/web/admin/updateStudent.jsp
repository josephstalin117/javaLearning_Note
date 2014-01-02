<%-- 
    Document   : updateStudent
    Created on : Jan 1, 2014, 9:16:10 AM
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
        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
            String uuid = request.getParameter("uuid");
        %>

        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class="col-xs-12 col-sm-9">
                    <p class="pull-right visible-xs">
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron">
                        <form role="form" action="../UpdateStudentServlet" method="post" class="form-horizontal">
                            <div class="form-group">
                                <input type="hidden" class="form-control" id="inputSid" placeholder="学号" name="uuid" value="<%=uuid%>">
                            </div>
                            <div class="form-group">
                                <label for="inputSname">姓名</label>
                                <input type="text" class="form-control" id="inputSname" placeholder="姓名" name="sname">
                            </div>
                            <div class="form-group">
                                <label for="inputSex">性别</label>
                                <select class="form-control" id="inputSex" name="sex">
                                    <option value="0">女生</option>
                                    <option value="1">男生</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputDid">院号</label>
                                <input type="text" class="form-control" id="inputDid" placeholder="院号" name="did">
                            </div>
                            <div class="form-group">
                                <label for="inputSpid">专业号</label>
                                <input type="text" class="form-control" id="inputSpid" placeholder="院号" name="spid">
                            </div>
                            <div class="form-group">
                                <label for="dtp_input2" class="col-md-2 control-label">出生日期</label>
                                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" size="16" type="text" id="inputBirthday" name="birthday" value="" readonly>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="dtp_input2" value="" /><br/>
                            </div>
                            <div class="form-group">
                                <label for="dtp_input2" class="col-md-2 control-label">入学时间</label>
                                <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" size="16" type="text" id="inputEnrollment" value="" name="enrollment" readonly>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="dtp_input2" value="" /><br/>
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
        <script src="../js/bootstrap-datetimepicker.min.js"></script>
        <script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
        <script src="../js/updateStudent.js"></script>
        <script type="text/javascript">
            $('.form_date').datetimepicker({
                language: 'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0
            });
        </script>
    </body>
</html>
