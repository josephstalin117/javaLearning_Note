<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="headerFooter/header.jsp" />
	<div class="container">
		<div class="jumbotron">
			This is my read page. <br>
		</div>
	</div>
<%@ include file="headerFooter/footer.jsp"%>
