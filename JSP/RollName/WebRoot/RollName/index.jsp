<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="headerFooter/header.jsp" />
<%!int count;
	StringBuffer personList;

	public void judge() {
		if (count == 0) {
			personList = new StringBuffer();
		}
	}

	public void addPerson(String p) {
		if (count == 0)
			personList.append(p);
		else
			personList.append("<br>" + p);
		count++;
	}%>
<div id="wrap" class="container">
	<%
		judge();
		int n = (int) (Math.random() * 60) + 1;
		out.print(n);
		addPerson(n + "号童鞋被点到名字");
	%>
	<br> 学号是： <br>
	<%=personList%>
</div>
<%@ include file="headerFooter/footer.jsp"%>