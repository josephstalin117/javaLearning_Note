<%-- 
    Document   : getStudent
    Created on : Dec 23, 2013, 9:17:51 AM
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
    <jsp:useBean id="student" scope="page" class="javaBean.Student"/>

    <body bgcolor="#0099FF" text="#FFFFFF" link="#33FF00">

        <p>

            <%

                String admin_id = (String) session.getAttribute("id"); // 从session中获得id值

                if (admin_id == null) {
                    response.sendRedirect("login.jsp");
                }

                String name = "", id = "", password = "", jiguan = "", dep = "", sex = "", tel = "", mail = "";

                int mark = 0;

            %>

        </p>

        <p>&nbsp;</p>

        <p align="center"><font color="#00FF00" size="+3" face="华文行楷">所有学生</font></p>

        <p><a href="addstudent.jsp"><font size="+1" face="华文行楷">增加学生</font></a></p>



        <div align="center">

            <table width="75%"  border="1">

                <tr> 

                    <td>学生号</td>

                    <td>姓名</td>

                    <td>密码</td>

                    <td>籍贯</td>

                    <td>系别</td>

                    <td>性别</td>

                    <td>学分</td>

                    <td>电话</td>

                    <td><p>E_mail</p></td>

                    <td>删除</td>

                    <td>更新</td>

                </tr>

                <%          ResultSet rs = student.getStudent();

                    while (rs.next()) {

                        id = rs.getString("id");

                        name = rs.getString("name");

                        password = rs.getString("password");

                        jiguan = rs.getString("jiguan");

                        dep = rs.getString("department");

                        sex = rs.getString("sex");

                        mark = rs.getInt("mark");

                        tel = rs.getString("tel");

                        if (tel == null || tel.equals("")) {
                            tel = "没有";
                        }

                        mail = rs.getString("e_mail");

                        if (mail == null || mail.equals("")) {
                            mail = "没有";
                        }


                %>

                <tr> 

                    <td><%=id%></td>

                    <td><%=name%></td>

                    <td><%=password%></td>

                    <td><%=jiguan%></td>

                    <td><%=dep%></td>

                    <td><%=sex%></td>

                    <td><%=mark%></td>

                    <td><%=tel%></td>

                    <td><%=mail%></td>

                    <td><a href="StudentSvlt?action=delete&id=<%=id%>">删除</a></td>

                    <td><a href="updatestu.jsp?id=<%=id%> ">更新</a> </td>

                </tr>

                <%

                    }

                %>

            </table>

        </div>

        <p align="center">&nbsp; </p>

        <a href="admin.jsp">&lt;&lt;Back </a> 


    </body>
</html>
