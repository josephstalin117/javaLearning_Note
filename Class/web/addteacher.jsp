<%-- 
    Document   : addteacher
    Created on : Dec 23, 2013, 9:20:03 AM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#0099FF" text="#FFFFFF" link="#66FF00">

        <p>

            <%

                String admin_id = (String) session.getAttribute("id");

                if (admin_id == null) {
                    response.sendRedirect("login.jsp");
                }

            %>

        </p>

        <p align="center"><font color="#00FF00" size="+3" face="华文行楷">新增教师</font></p>

        <form name="form1" method="post" action="TeacherSvlt">

            <input type="hidden" name="action" value="new">

            <p>&nbsp;</p>

            <div align="center">

                <table width="51%"  border="1">

                    <tr> 

                        <td width="33%">教师姓名</td>

                        <td width="67%"><input name="name" type="text" id="name"></td>

                    </tr>

                    <tr> 

                        <td>教师号</td>

                        <td><input name="id" type="text" id="id"></td>

                    </tr>

                    <tr> 

                        <td>密码</td>

                        <td><input name="password" type="password" id="password"></td>

                    </tr>

                    <tr> 

                        <td>职称</td>

                        <td><select name="title" size="1" id="title">

                                <option>讲师</option>

                                <option>教授</option>

                            </select></td>

                    </tr>

                </table>

                <p>

                    <input name="确定" type="submit" id="确定" value="提交">

                </p>

            </div>

        </form>



        <p>&nbsp;</p>

        <p><a href="getteacher.jsp">&lt;&lt;Back</a></p>


    </body>
</html>
