<%-- 
    Document   : updateChange
    Created on : Dec 5, 2013, 2:55:55 PM
    Author     : josephstalin
--%>

<%@page import="rollName.tool"%>
<%@page import="java.lang.String"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="rollName.curd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headerFooter/header.jsp" />

<div class="container warp">
    <div class="jumbotron">
        <%
            String name=null;
            String birthday=null;
            String sex=null;
            String year=null;
            String month=null;
            String day=null;
            String tid=null;
        %>
        <%

            //获取用户表单输入数据
            String id = request.getParameter("id");
            if (id != null) {
                //业务处理
                ArrayList<String> readList = new ArrayList<String>();
                readList = (ArrayList<String>) curd.read(id);
                name = readList.get(0);
                birthday = readList.get(1);
                sex = readList.get(2);

                ArrayList<String> list = new ArrayList<String>();
                list = (ArrayList<String>) tool.timeFormat(birthday);
                year = list.get(0);
                month = list.get(1);
                day = list.get(2);
                session.setAttribute("id", id);
            }
        %>
        <div class="row">
            <form role="form" action="" method="get">
                <div class="form-group">
                    <input type="text" class="form-control" id="inputName" placeholder="name" name="name" value="<%=name%>">
                    <label for="inputName">姓名</label>
                </div>
                <div class="form-group">
                    <select id="year" class="form-control" name="year">
                        <option value="<%=year%>"><%=year%></option>

                    </select>年
                    <select id="month" class="form-control" name="month">
                        <option value="<%=month%>"><%=month%></option>
                    </select>月
                    <select id="day" class="form-control" name="day">
                        <option value="<%=day%>"><%=day%></option>
                    </select>日
                </div>
                <div class="form-group">
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" value="1">
                            男
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="sex" value="0">
                            女
                        </label>
                    </div>
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4">插入</button>
                </div>
            </form>
        </div>
        <%
            //获取用户表单输入数据
            String wname = request.getParameter("name");

            if (wname != null) {
                int wyear = Integer.parseInt(request.getParameter("year"));
                int wmonth = Integer.parseInt(request.getParameter("month"));
                int wday = Integer.parseInt(request.getParameter("day"));
                int wsex = Integer.parseInt(request.getParameter("sex"));
                int uid=Integer.parseInt((String) session.getAttribute("id"));
                
                
                
                //业务处理
                int r = curd.update(uid, wname, wyear, wmonth, wday, wsex);

                //用户反馈
                if (r == 0) {
                    session.setAttribute("state", "修改学生基本信息失败.");
                }
                if (r == 1) {
                    session.setAttribute("state", "成功修改学生基本信息");
                }

                //返回主界面
                response.sendRedirect("index.jsp");
            }
        %>
    </div>
</div>
<script src="js/update.js"></script>
<%@ include file="headerFooter/footer.jsp"%>