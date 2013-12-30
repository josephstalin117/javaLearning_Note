<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="headerFooter/header.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="wrap" class="container wrap">

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
					placeholder="请输入1班人数" name="num" autocomplete="off" /> 
				<input type="text" class="form-control" id="InputNumber2" placeholder="请输入2班人数" name="num2" autocomplete="off">
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
	</div>

	<script type="text/javascript">
		
	</script>



</div>
<%@ include file="headerFooter/footer.jsp"%>