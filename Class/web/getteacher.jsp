<%-- 
    Document   : getteather
    Created on : Dec 23, 2013, 9:18:38 AM
    Author     : josephstalin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="teacher" scope="page" class="javaBean.Teacher"/>

    <body bgcolor="#0099FF" text="#FFFFFF" link="#00FF00">

        <%

            String id = "", name = "", title = "", password = "";

        %>

        <p align="center"><font color="#00FF00" size="+3" face="华文行楷">所有教师</font></p>

        <p><a href="addteacher.jsp">新增教师</a></p>



        <p>&nbsp;</p>

        <table width="75%"  border="1" align="center">

            <tr> 

                <td>教师号</td>

                <td>姓名</td>

                <td>职称</td>

                <td>密码</td>

                <td>删除</td>

                <td>更改</td>

            </tr>

            <!--
            
            根据id值，调用JavaBean的查询数据库的方法，从而得到数据库得到ResultSet类型的结果集-->



            <%        ResultSet rs = teacher.getAll();

                while (rs.next()) {

                    id = rs.getString("id");

                    name = rs.getString("name");

                    title = rs.getString("title");

                    password = rs.getString("password");


            %>

            <tr>

                <td><%=id%></td>

                <td><%=name%></td>

                <td><%=title%></td>

                <td><%=password%></td>

                <td><a href="TeacherSvlt?action=delete&id=<%=id%>">删除</a></td>

                <td><a href="updatetea.jsp?id=<%=id%> ">更新</a></td>

            </tr>

            <%

                }

            %>

        </table>

        <p><a href="admin.jsp">&lt;&lt;BackTo Admin</a></p>


    </body>
</html>
