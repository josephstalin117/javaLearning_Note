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
            <form role="form" action="updateChange.jsp" method="get">
                <div class="form-group">
                    <label for="inputId" id="testClick">学号</label>
                    <input type="text" class="form-control" id="inputId" placeholder="id" name="id" autocomplete="off">
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4" id="submit">提交</button>
                </div>
            </form>
        </div>
        <div class="alert alert-danger fade in hide" id="finder">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
            <strong>test</strong>
        </div>
    </div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
