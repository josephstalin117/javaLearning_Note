<%-- 
    Document   : updateUser
    Created on : Dec 10, 2013, 11:15:20 AM
    Author     : josephstalin
--%>
<%@page import="bean.ShowRecordByPage"%>
<%@page import="bean.Jdbc"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //获取地址栏传入参数
            String id = request.getParameter("id");

            //
            if (id != null) {
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                String sql = "select * from hehe_user where id=" + id;

                try {
                    con = Jdbc.getCon();
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        // 根据业务需要取得相应数据并进行处理
%>
        <form action="">
            id:
            <input type="text" name="tid" value="<%=rs.getInt("id")%>">
            <br>
            username:
            <input type="text" name="tgbk" value="<%=rs.getString("username")%>">
            <br>
            <input type="submit" value="update">
        </form>

        <%
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    Jdbc.free(rs, ps, con);
                }
            }
        %>


        <%
            //获取用户表单输入数据
            String tid = request.getParameter("tid");
            String tgbk = request.getParameter("tgbk");

            if (tgbk != null) {
                        //数据类型转换
                //业务处理
                int r = Jdbc
                        .writeDb(
                                "update hehe_user set username=? where id=?",
                                new Object[]{tgbk, Integer.parseInt(tid)});

                        //用户反馈
                //返回主界面
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
