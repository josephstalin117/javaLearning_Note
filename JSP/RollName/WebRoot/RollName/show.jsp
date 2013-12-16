<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="rollName.randomRoll"%>
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
	String num2;
	num = request.getParameter("num");
	method = request.getParameter("method");
	num2 = request.getParameter("num2");
%>

<div id="wrap" class="container">
	<div class="jumbotron">
		<button type="button" class="btn btn-default navbar-btn">
			<a href="show.jsp?num=<%=num%>&num2=<%=num2%>&method=<%=method%>"
				class="navbar-link">点名</a>
		</button>

		<%
			String id = session.getId();
			out.println("sessionId " + id + "<br>");
		%>

		<%

			int n;
			int n2;
			//历史记录
			if(session.getAttribute("sessionNum")==null){
				session.setAttribute("sessionNum", num);
				session.setAttribute("sessionNum2", num2);
				session.setAttribute("sessionMethod", method);
			
				String sessionNumber = (String) session.getAttribute("sessionNum");
				String sessionNumber2 = (String) session
						.getAttribute("sessionNum2");
				String sessionMethod = (String) session
						.getAttribute("sessionMethod");
				
				//添加历史记录
				ArrayList list=new ArrayList();
				
				session.setAttribute("result",list);
				list=(ArrayList)session.getAttribute("result");
			}
			
			//第n次
			session.setAttribute("sessionNum", num);
			session.setAttribute("sessionNum2", num2);
			session.setAttribute("sessionMethod", method);
		
			String sessionNumber = (String) session.getAttribute("sessionNum");
			String sessionNumber2 = (String) session
					.getAttribute("sessionNum2");
			String sessionMethod = (String) session
					.getAttribute("sessionMethod");
			List list=(ArrayList)session.getAttribute("result");
			out.print("<br>");
			
			
			
			
			//随机生成点名
			int i=randomRoll.goTo(sessionMethod);
			if(i==1){
				n = randomRoll.stratifiedSampling(num, num2);
				out.print("<br>");
				out.print("两班" + n + "号童鞋被点到名字");
				out.print("<br>");
				int sessionSum=Integer.parseInt(sessionNumber)+Integer.parseInt(sessionNumber2);
				out.print("两班学生总数" + sessionSum);
			}else{
				n = randomRoll.simpleSampling(num);
				n2 = randomRoll.simpleSampling(num2);
				
				out.print("<br>");
				out.print("1班" + n + "号童鞋被点到名字");
				out.print("<br>");
				out.print("2班" + n2 + "号童鞋被点到名字");
			}
			list.add(n);
			
			
			session.setAttribute("result",list);

			//输出
			out.print("<br>");
			out.print("学生总数" + sessionNumber);
			out.print("<br>");
			out.print("抽样方法" + sessionMethod);
			out.print("<br>");
			out.print("历史记录");
			out.print("<br>");
			

			

			//int sessionHistory = (Integer) session.getAttribute("sessionHistory");
			//randomRoll.add(sessionHistory);


			
			List list2=(ArrayList)session.getAttribute("result");

			
			//response.setHeader("refresh","2");

		%>
		<div class="panel panel-default">
			<table class="table">
				<tr>
					<th>历史记录</th>
				</tr>
				<%
					Iterator<Integer> it = list2.iterator();
					out.print(list2.get(0));
					//out.print(list2);
					
					while (it.hasNext()) {
						out.print("<tr>");
						out.print("<td>");
						out.print(it.next());
						out.print("<td>");
						out.print("<tr>");
					}
				%>
			</table>
		</div>
	</div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
