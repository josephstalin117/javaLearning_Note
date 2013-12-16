<%@page import="rollName.curd"%>
<%@page import="rollName.Jdbc"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="rollName.tool"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
    //设定字符集
    request.setCharacterEncoding("UTF-8");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
    <div class="jumbotron">
        <div class="row">
            <form role="form" action="" method="get">
                <div class="form-group">
                    <input type="text" class="form-control" id="inputName" placeholder="name" name="name">
                    <label for="inputName">姓名</label>
                </div>
                <div class="form-group">
                    <select id="year" class="form-control" name="year">
                        <option>选择年</option>
                    </select>年
                    <select id="month" class="form-control" name="month">
                        <option value="">选月</option>
                    </select>月
                    <select id="day" class="form-control" name="day">
                        <option>选择日</option>
                    </select>日
                </div>
                <div class="form-group">
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" value="1">
                            男
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" value="0">
                            女
                        </label>
                    </div>
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4">插入</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%
    //获取用户表单输入数据
    String name = request.getParameter("name");

    if (name != null) {
        int year=Integer.parseInt(request.getParameter("year"));
        int month=Integer.parseInt(request.getParameter("month"));
        int day=Integer.parseInt(request.getParameter("day"));
        int sex = Integer.parseInt(request.getParameter("sex"));

        //业务处理
        int r = curd.insert(name, year, month, day, sex);

        //用户反馈
        if (r == 0) {
            session.setAttribute("state", "填加学生基本信息失败.");
        }
        if (r == 1) {
            session.setAttribute("state", "成功填加一条学生基本信息.");
        }

        //返回主界面
        response.sendRedirect("index.jsp");
    }
%>
<script src="js/insert.js"></script>
<%@ include file="headerFooter/footer.jsp"%>