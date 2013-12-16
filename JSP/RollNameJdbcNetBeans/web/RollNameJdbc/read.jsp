<%@page import="rollName.curd"%>
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
                    <label for="inputId" id="testClick">学号</label>
                    <input type="text" class="form-control" id="inputId" placeholder="id" name="id" autocomplete="off">
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4" id="submit">提交</button>
                </div>
            </form>
<%
    //获取用户表单输入数据
    String id = request.getParameter("id");
    if (id != null) {
    //业务处理
        ArrayList<String> readList = new ArrayList<String>();
        readList = (ArrayList<String>) curd.read(id);
        String name = readList.get(0);
        String birthday = readList.get(1);
        String sex = readList.get(2);
        out.print("姓名：");
        out.print("<b>"+name+"</b><br>");
        out.print("生日：");
        out.print("<b>"+birthday+"</b><br>");
        out.print("性别：");
        out.print("<b>"+sex+"</b><br>");
    }
%>
        </div>
        <div class="alert alert-danger fade in hide" id="finder">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
            <strong>test</strong>
        </div>
    </div>
</div>
<script src="js/read.js"></script>
<%@ include file="headerFooter/footer.jsp"%>