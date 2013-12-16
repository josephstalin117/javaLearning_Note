<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
	<div class="jumbotron">
		<div class="row">
			<%
				//set session
				String msg = (String) session.getAttribute("state");
				if (msg == null) {
					session.setAttribute("state", "please roll name");
				}

				msg = (String) session.getAttribute("state");
				out.write(msg);
			%>
		</div>
		<div class="row">
			<h1 class="text-center">开始点名</h1>
		</div>
		<div class="row">
			<input id="bt"
				class="btn btn-lg btn-primary col-md-4 col-md-offset-4"
				role="button" type="submit" value="开始点名" />
		</div>
	</div>
</div>

<%@ include file="headerFooter/footer.jsp"%>
