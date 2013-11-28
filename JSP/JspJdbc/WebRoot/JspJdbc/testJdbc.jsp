<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testJdbc.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>



	<%
		Connection con;
		Statement sql;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			out.print(e);
		}
		try {
			String uri = "jdbc:mysql://localhost:3306/hehe";
			con = DriverManager.getConnection(uri, "root", "lyz133551");
			sql = con.createStatement();
			rs = sql.executeQuery("SELECT * FROM hehe_user");
			out.print("<table border=2>");
			out.print("<tr>");
			out.print("<th width=100>" + "user_id");
			out.print("<th width=100>" + "username");
			out.print("<th width=100>" + "userpass");
			out.print("<th width=100>" + "email");
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString(1) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("<td>" + rs.getString(4) + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			con.close();
		} catch (SQLException e1) {
			out.print(e1);
		}
	%>
</body>
</html>
