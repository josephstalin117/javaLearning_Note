<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="headerFooter/header.jsp" />
    This is my rollName page. <br>
<%@ include file="headerFooter/footer.jsp"%>
