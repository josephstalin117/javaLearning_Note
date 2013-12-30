<%@page import="rollName.curd"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
    <div class="jumbotron">
        <div class="row">
            <form role="form" action="" method="get">
                <div class="form-group">
                    <label for="inputId" id="testClick">删除学号</label>
                    <input type="text" class="form-control" id="inputId" placeholder="id" name="id" autocomplete="off">
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4" id="submit">提交</button>
                </div>
            </form>
        </div>
        <%
            //获取用户表单输入数据
            int r=-1;
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                //业务处理
                r = curd.delete(id);
            }
            //用户反馈
            if (r == 0) {
                session.setAttribute("state", "删除学生基本信息失败.");
                response.sendRedirect("index.jsp");
            }
            if (r == 1) {
                session.setAttribute("state", "成功删除一条学生基本信息.");
                response.sendRedirect("index.jsp");
            }

            //返回主界面
%>
    </div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
