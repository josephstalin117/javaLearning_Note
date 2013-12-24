<%-- 
    Document   : admin
    Created on : Dec 23, 2013, 9:17:38 AM
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

                String admin_id = (String) session.getAttribute("id");//从session中获得id值

                if (admin_id == null) {
                    response.sendRedirect("login.jsp");
                }

            %>

            <font color="#00FF00" size="+2" face="华文行楷">您以经成功通过验证! 您可以更改以下内容：</font></p>

        <p> </p> </p>

    <table align="center" >

        <tr> 

            <td><a href="getStudent.jsp">学生&gt;&gt;</a> </td>

            <td ><a href="getteacher.jsp">教师&gt;&gt; </a></td>

            <td><a href="getcourse.jsp">课程&gt;&gt;</a></td>

            <td><a href="getClass.jsp">班级&gt;&gt;</a></td>

        </tr>

    </table>    

    <p>&nbsp;</p><p>&nbsp;</p>

    <p><a href="login_confirm?action=logout">&lt;&lt;注销 </a> </div> </p>


</body>
</html>
