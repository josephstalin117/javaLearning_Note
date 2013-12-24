<%-- 
    Document   : updatestu
    Created on : Dec 23, 2013, 9:19:33 AM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#0099FF" text="#FFFFFF" link="#33FF00">

        <jsp:useBean id="stu" scope="request" class="javaBean.Student"/>

        <p>

            <%

                String stu_id = request.getParameter("id");

            %>

        </p>

        <p align="center"><font color="#00FF00" size="+3" face="方正舒体">更新学生</font></p>

        <p align="center">&nbsp;</p>

        <form  method="post" action="StudentSvlt">

            <input type="hidden" name="action" value="update">

            <input type="hidden" name="id" value="<%=stu_id%>">

            <table width="49%" height="50"  border="1" align="center" cellpadding="0" cellspacing="0">

                <tr> 

                    <td width="48%">学生姓名</td>

                    <td width="52%"><input name="name" type="text"  id="name" ></td>

                </tr>

                <tr> 

                    <td>密码</td>

                    <td><input name="password" type="password" id="password" maxlength="10"></td>

                </tr>

                <tr> 

                    <td>学生所在系</td>

                    <td><select name="dep" size="1" id="dep">

                            <option>计算机</option>

                            <option>机械系</option>

                            <option>电子系</option>

                            <option>数理系</option>

                        </select></td>

                </tr>

                <tr> 

                    <td>性别</td>

                    <td><select name="sex" size="1" id="select">

                            <option>男</option>

                            <option>女</option>

                        </select></td>

                </tr>

                <tr> 

                    <td>籍贯</td>

                    <td><select name="jiguan" size="1" id="jiguan">

                            <option>陕西</option>

                            <option>河南</option>

                            <option>山东</option>

                            <option>内蒙古</option>

                            <option>河北</option>

                        </select></td>

                </tr>

            </table>

            <p align="center"> 

                <input type="submit" name="Submit" value="提交">

            </p>

        </form>

        <p>&nbsp;</p>

        <p><a href="getStudent.jsp">&lt;&lt;Back</a></p>


    </body>
</html>
