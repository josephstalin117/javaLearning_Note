<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />


<%
	String num;
	String method;
	num = request.getParameter("num");
	method = request.getParameter("method");
%>

<div id="wrap" class="container">
	<div class="jumbotron">
		<button type="button" class="btn btn-default navbar-btn">
			<a href="show.jsp?num=<%=num%>&method=<%=method%>" class="navbar-link">点名</a>
		</button>
			
		<%
			String id = session.getId();
			out.println("sessionId " + id + "<br>");
		%>

		<%
			int number = Integer.parseInt(num);
			int n = (int) (Math.random() * number) + 1;

			out.print("<br>");
			out.print(n + "号童鞋被点到名字");

			//历史记录
			session.setAttribute("sessionNum", num);
			session.setAttribute("sessionMethod", method);
			String sessionNumber = (String) session.getAttribute("sessionNum");
			String sessionMethod = (String) session.getAttribute("sessionMethod");

			//输出
			out.print("<br>");
			out.print(sessionNumber);
			out.print("<br>");
			out.print(sessionMethod);
		%>
	</div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
