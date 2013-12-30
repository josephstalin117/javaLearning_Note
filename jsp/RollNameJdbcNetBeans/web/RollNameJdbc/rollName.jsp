<%@page import="rollName.curd"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
    <div class="jumbotron">
        <%
            String id = curd.simpleSampling();
            out.println(id);
            out.print("号同学被选中");
            curd.insertLog(id);
        %>
    </div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
