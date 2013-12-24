<%-- 
    Document   : updateClass
    Created on : Dec 23, 2013, 9:21:19 AM
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

    <body bgcolor="#0099FF" text="#FFFFFF" link="#00FF00">

        <%

            String id = request.getParameter("id");

            String tea_id = "", cour_id = "", room_id = "", cour_time = "", name = "";

        %>

        <div align="center"><font color="#00FF00" size="+3" face="方正舒体">更新班级</font> 

            <form  method="post" action="ClassSvlt">

                <input type="hidden" name="action" value="update">

                <input type="hidden" name="id" value="<%=id%>">

                <table width="40%" border="1">

                    <tr> 

                        <td width="34%">教师</td>

                        <td width="66%"><select name="tea_id" size="1" id="tea_id">

                                <%

                                    ResultSet rs = classp.getTeachers();

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

                        <td>教室</td>

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

                <p>

                    <input name="Submit" type="submit" value="确定">

                </p>

                <%        String tea_id0 = request.getParameter("tea_id0");

                    String cour_time0 = request.getParameter("cour_time0");


                %>

                <input type="hidden" name="tea_id0" value="<%=tea_id0%>">

                <input type="hidden" name="cour_time0" value="<%=cour_time0%>">

            </form>

            <div align="left"><a href="getClass.jsp"><font size="+1">&lt;&lt;Back</font></a></div>

        </div>


    </body>
</html>
