<%-- 
    Document   : updateinformation
    Created on : Dec 23, 2013, 8:39:11 AM
    Author     : josephstalin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#0099FF" text="#FFFFFF">
        <div align="center">

            <p>


                <%

                    String stu_id = (String) session.getAttribute("id");

                    if (stu_id == null) {
                        response.sendRedirect("login.jsp");
                    }

                %>

                <font color="#00FF00" size="+3" face="方正舒体">更改您的个人信息 </font></p>

            <p>&nbsp; </p>

        </div>


        <form name="form1" method="post" action="StudentLoginSvlt">

            <input type="hidden" name="action" value="update">

            <input type="hidden" name="id" value="<%=stu_id%>">

            <table width="55%"  border="1" align="center">

                <tr>

                    <td>新密码：</td>

                    <td><input name="password1" type="password" id="password1"></td>

                </tr>

                <tr> 

                    <td width="42%">确认：</td>

                    <td width="58%"> <input name="password2" type="password" id="password2" > </td>

                </tr>

                <tr> 

                    <td>电话：</td>

                    <td> <input name="tel" type="text" id="tel2"> </td>

                </tr>

                <tr> 

                    <td>E_mail:</td>

                    <td> <input name="e_mail" type="text" > </td>

                </tr>

            </table>

            <p align="center">

                <label></label>

            </p>

            <p align="center">&nbsp;</p>

            <p align="center">

                <input type="submit" name="Submit" value="提交">

            </p>

        </form>

        <a href="student.jsp">&lt;&lt;Back </a> 


    </body>
</html>
