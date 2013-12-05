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
                    <label for="inputId">学号</label>
                    <input type="text" class="form-control" id="inputId" placeholder="id" name="id">
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
