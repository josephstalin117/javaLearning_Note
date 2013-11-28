<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="headerFooter/header.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
	}

	public class RollName {
		private String num;
		private String method;
	}%>
<div id="wrap" class="container">

	<div class="jumbotron">
		<%
			String id = session.getId();
			out.println("sessionId " + id);
		%>
		<h1 style="text-align:center">开始点名啦</h1>
		<div class="form-group">
			<form class="form-inline" role="form" method="get" action="show.jsp">
				<label class="sr-only" for="exampleInputEmail2"> 随机点名 </label>
				 <input type="text" class="form-control" id="InputNumber"
					placeholder="请输入班级人数" name="num" autocomplete="off" />
				<input id="bt" class="btn btn-lg btn-primary" role="button" type="submit" value="开始点名" /> 
				<input type="hidden" id="selectedsex" name="method" />
				<!-- Single button -->
				<div class="btn-group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown" id="dropdownMethodTitle">
						选择点名模式 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="dropdownMethod">
						<li class="sex" id="stratified"><a href="#">分层抽样</a></li>
						<li class="sex" id="simple"><a href="#">简单抽样</a></li>
						<li class="divider"></li>
						<li class="sex" id="convenience"><a href="#">方便抽样</a></li>
					</ul>
				</div>
			</form>

		</div>

		<br> <b>学号是：</b> <br>
		<%=personList%>
		<%
			judge();
			int n = (int) (Math.random() * 60) + 1;
			addPerson(n + "号童鞋被点到名字");
			
			String sessionNumber=(String)session.getAttribute("sessionNum");
			String sessionMethod=(String)session.getAttribute("sessionMethod");
			
			out.print("<br>");
			out.print(sessionNumber);
			out.print("<br>");
			out.print(sessionMethod);
		%>
	</div>

	<script type="text/javascript">
		
	</script>



</div>
<%@ include file="headerFooter/footer.jsp"%>