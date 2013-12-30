
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="testJdbc.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<jsp:include page="headerFooter/header.jsp" />
<div class="container" id="wrap">
	<div class="jumbotron">
	<div class="panel panel-default">
		<%
			List<String> hehe = new ArrayList<String>();
			List<String> nameArray = new ArrayList<String>();
			//out.print(testRead.heheRead().get(1));
			//out.print(testRead.heheRead().toString());
			for (int i = 0; i < testRead.readName().size(); i++) {
				hehe.add((String) testRead.readName().get(i));
			}
			%>
			<table class="table">
				<tr>
					<th>姓名</th>
				</tr>
			<%
			for (int i = 0; i < hehe.size(); i++) {
				out.print("<tr>");
				out.print("<td>");
				out.print(hehe.get(i));
				out.print("</tr>");
				out.print("</td>");
			}
			%>
			</table>
			<%
			//hehe=String.parseString(testRead.heheRead());
			//hehe=testRead.heheRead();
			//out.print(hehe);

			//out.print(testString);
			//hehe.add("123");
			//hehe = testRead.read();
			//out.print(hehe);
		%>
	</div>
	</div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
