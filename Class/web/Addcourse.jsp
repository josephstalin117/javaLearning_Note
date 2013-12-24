<%-- 
    Document   : Addcourse
    Created on : Dec 23, 2013, 9:21:07 AM
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
    <jsp:useBean id="course" scope="session" class="javaBean.Course"/>

    <body bgcolor="#0099FF" text="#FFFFFF" link="#66FF00">

        <p>

            <%

                String admin_id = (String) session.getAttribute("id");

                if (admin_id == null) {
                    response.sendRedirect("login.jsp");
                }

                String cour_name = "", cour_id = "";

            %>

        </p>

        <p align="center"><font color="#00FF00" size="+3" face="华文行楷">新增课程</font></p>

        <form name="form1" method="post" action="CourseSvlt">

            <input type="hidden" name="action" value="new">

            <p>&nbsp;</p>

            <div align="center"></div>

            <table width="37%"  border="1" align="center">

                <tr> 

                    <td width="37%">课程名</td>

                    <td width="63%"><input name="name" type="text" id="name"></td>

                </tr>

                <tr> 

                    <td>课程号</td>

                    <td><input name="id" type="text" id="id"></td>

                </tr>

                <tr> 

                    <td>学分</td>

                    <td><select name="mark" size="1" id="mark">

                            <option value="1">1</option>

                            <option value="2">2</option>

                            <option value="3">3</option>

                            <option value="4">4</option>

                            <option value="5">5</option>

                        </select></td>

                </tr>

                <tr> 

                    <td>系别</td>

                    <td><select name="dep" size="1" id="dep">

                            <option>public</option>

                            <option>计算机</option>

                            <option>机械系</option>

                            <option>电子系</option>

                            <option>数理系</option>
                            <option>信息</option>


                        </select></td>

                </tr>

                <tr> 

                    <td>预修课</td>

                    <td><select name="prepare" size="1" id="prepare">

                            <option value="0">无预修课</option>

                            <!--
                            
                            根据id值，调用JavaBean的查询数据库的方法，从而得到数据库得到ResultSet类型的结果集-->



                            <%              ResultSet rs = course.getPrepares();

                                while (rs.next()) {

                                    cour_name = rs.getString("name");

                                    cour_id = rs.getString("id");

                            %>

                            <option value="<%=cour_id%>"><%=cour_name%></option>

                            <%

                                }

                            %>       

                        </select>

                    </td>

                </tr>

            </table>

            <p align="center"> 

                <input type="submit" name="Submit2" value="确定">

            </p>

            <p>&nbsp;</p>

        </form>

        <p><a href="getcourse.jsp">&lt;&lt;Back </a></p>


    </body>
</html>
