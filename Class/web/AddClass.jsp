<%-- 
    Document   : AddClass
    Created on : Dec 23, 2013, 9:21:28 AM
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
    <jsp:useBean id="classp" scope="page" class="javaBean.Classp"/>

    <body bgcolor="#0099FF" text="#FFFFFF">

        <p>

            <%

                String admin_id = (String) session.getAttribute("id");

                if (admin_id == null) {
                    response.sendRedirect("login.jsp");
                }

                String name = "";

                String id = "";

            %>

        </p>

        <p align="center"><font color="#00FF00" size="+3" face="华文行楷">新增班级 </font></p>

        <form name="form1" method="post" action="ClassSvlt">

            <input type="hidden" name="action" value="new">

            <table width="38%"  border="1" align="center">

                <tr> 

                    <td width="29%">班级号</td>

                    <td width="71%"><input name="id" type="text" id="id2"> </td>

                </tr>

                <tr> 

                    <td>教师</td>

                    <td><select name="tea_id" size="1" id="tea_id">

                            <%              ResultSet rs = classp.getTeachers();

                                while (rs.next()) {

                                    id = rs.getString("id");

                                    name = rs.getString("name");

                            %>

                            <option value="<%=id%>"><%=name%></option>

                            <%

                                }

                            %>

                        </select></td>

                </tr>

                <tr> 

                    <td>课程</td>

                    <td><select name="cour_id" id="cour_id">

                            <%              rs = classp.getCourses();

                                while (rs.next()) {

                                    id = rs.getString("id");

                                    name = rs.getString("name");

                            %>

                            <option value="<%=id%>"><%=name%></option>

                            <%

                                }

                            %>

                        </select></td>

                </tr>

                <tr> 

                    <td>教室ID</td>

                    <td><select name="room_id" size="1" id="room_id">

                            <option>101</option>

                            <option>102</option>

                            <option>103</option>

                            <option>104</option>

                            <option>105</option>

                            <option>201</option>

                            <option>202</option>

                            <option>203</option>

                            <option>204</option>

                            <option>205</option>

                            <option>301</option>

                            <option>302</option>

                            <option>303</option>

                            <option>304</option>

                            <option>305</option>

                            <option>306</option>

                        </select></td>

                </tr>

                <tr> 

                    <td>上课时间</td>

                    <td><select name="cour_time" size="1" id="cour_time">

                            <option value="Mon_1">星期一/一节</option>

                            <option value="Mon_2">星期一/二节</option>

                            <option value="Mon_3">星期一/三节</option>

                            <option value="Tues_1">星期二/一节</option>

                            <option value="Tues_2">星期二/二节</option>

                            <option value="Tues_3">星期二/三节</option>

                            <option value="Wed_1">星期三/一节</option>

                            <option value="Wed_2">星期三/二节</option>

                            <option value="Wed_3">星期三/三节</option>

                            <option value="Thurs_1">星期四/一节</option>

                            <option value="Thurs_2">星期四/二节</option>

                            <option value="Thurs_3">星期四/三节</option>

                            <option value="Fri_1">星期五/一节</option>

                            <option value="Fri_2">星期五/二节</option>

                            <option value="Fri_3">星期五/三节</option>

                        </select></td>

                </tr>

            </table>

            <p align="center"> 

                <input type="submit" name="Submit" value="提交">

            </p>

            <p>&nbsp;</p>

        </form>

        <a href="getClass.jsp">&lt;&lt;Back </a> 


    </body>
</html>
