<%-- 
    Document   : displaystu
    Created on : Dec 23, 2013, 9:04:30 AM
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
    <body>
        <jsp:useBean id="deter" scope="page" class="javaBean.Determine"/>

    <body bgcolor="#0099FF" text="#FFFFFF" link="#00FF00">

        <div align="center"> 

            <p>&nbsp;</p>

            <p><font color="#00FF00" size="+3" face="方正舒体">选报该课程的学生</font></p>

            <p>&nbsp;</p>

            <table width="75%" border="1">

                <tr> 

                    <td>学生姓名</td>

                    <td>所在系</td>

                    <td>性别</td>

                    <td>学分</td>

                    <td>Email</td>

                    <td>Tel</td>

                    <td>接受</td>

                </tr>

                <%

                    String class_id = request.getParameter("class_id");

                    String name = null;

                    String dep = null;

                    String sex = null;

                    int mark = 0;

                    String e_mail = null;

                    String tel = null;

                    ResultSet rs = deter.getStudents(class_id);

                    String stu_id = null;

                    while (rs.next()) {

                        stu_id = rs.getString("id");

                        name = rs.getString("name");

                        dep = rs.getString("department");

                        sex = rs.getString("sex");

                        mark = rs.getInt("mark");

                        e_mail = rs.getString("e_mail");

                        tel = rs.getString("tel");

                %>

                <tr> 

                    <td><%=name%></td>

                    <td><%=dep%></td>

                    <td><%=sex%></td>

                    <td><%=mark%></td>

                    <td><%=e_mail%></td>

                    <td><%=tel%></td>

                    <td><a href="MarkSvlt?stu_id=<%=stu_id%>&action=enrol&class_id=<%=class_id%> ">accept</a></td>

                </tr>

                <%

                    }

                %>  

            </table>

            <p>&nbsp;</p>

            <p align="left"><a href="choosestu.jsp">&lt;&lt;Back </a></p>

        </div>


    </body>
</html>
