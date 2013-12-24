<%-- 
    Document   : index
    Created on : Dec 22, 2013, 8:16:58 PM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <SCRIPT language=JavaScript>

        function Year_Month() {

            var now = new Date();

            var yy = now.getYear();

            var mm = now.getMonth() + 1;

            var cl = '<font color="#0000df">';

            if (now.getDay() == 0)
                cl = '<font color="#c00000">';

            if (now.getDay() == 6)
                cl = '<font color="#00c000">';

            return(cl + yy + '年' + mm + '月</font>');
        }

        function Date_of_Today() {

            var now = new Date();

            var cl = '<font color="#ff0000">';

            if (now.getDay() == 0)
                cl = '<font color="#c00000">';

            if (now.getDay() == 6)
                cl = '<font color="#00c000">';

            return(cl + now.getDate() + '</font>');
        }

        function Day_of_Today() {

            var day = new Array();

            day[0] = "星期日";

            day[1] = "星期一";

            day[2] = "星期二";

            day[3] = "星期三";

            day[4] = "星期四";

            day[5] = "星期五";

            day[6] = "星期六";

            var now = new Date();

            var cl = '<font color="#0000df">';

            if (now.getDay() == 0)
                cl = '<font color="#c00000">';

            if (now.getDay() == 6)
                cl = '<font color="#00c000">';

            return(cl + day[now.getDay()] + '</font>');
        }

        function CurentTime() {

            var now = new Date();

            var hh = now.getHours();

            var mm = now.getMinutes();

            var ss = now.getTime() % 60000;

            ss = (ss - (ss % 1000)) / 1000;

            var clock = hh + ':';

            if (mm < 10)
                clock += '0';

            clock += mm + ':';

            if (ss < 10)
                clock += '0';

            clock += ss;

            return(clock);
        }

        function refreshCalendarClock() {

            document.all.calendarClock1.innerHTML = Year_Month();

            document.all.calendarClock2.innerHTML = Date_of_Today();

            document.all.calendarClock3.innerHTML = Day_of_Today();

            document.all.calendarClock4.innerHTML = CurentTime();
        }

        var webUrl = webUrl;

        document.write('<table border="0" cellpadding="0" cellspacing="0"><tr><td>');

        document.write('<table id="CalendarClockFreeCode" border="0" cellpadding="0" cellspacing="0" width="60" height="70" ');

        document.write('style="position:absolute;visibility:hidden" bgcolor="#eeeeee">');

        document.write('<tr><td align="center"><font ');

        document.write('style="cursor:hand;color:#ff0000;font-family:宋体;font-size:14pt;line-height:120%" ');

        if (webUrl != 'netflower') {

            document.write('</td></tr><tr><td align="center"><font ');

            document.write('style="cursor:hand;color:#2000ff;font-family:宋体;font-size:9pt;line-height:110%" ');

        }

        document.write('</td></tr></table>');

        document.write('<table border="0" cellpadding="0" cellspacing="0" width="61" bgcolor="#C0C0C0" height="70">');

        document.write('<tr><td valign="top" width="100%" height="100%">');

        document.write('<table border="1" cellpadding="0" cellspacing="0" width="58" bgcolor="#FEFEEF" height="67">');

        document.write('<tr><td align="center" width="100%" height="100%" >');

        document.write('<font id="calendarClock1" style="font-family:宋体;font-size:7pt;line-height:120%"> </font><br>');

        document.write('<font id="calendarClock2" style="color:#ff0000;font-family:Arial;font-size:14pt;line-height:120%"> </font><br>');

        document.write('<font id="calendarClock3" style="font-family:宋体;font-size:9pt;line-height:120%"> </font><br>');

        document.write('<font id="calendarClock4" style="color:#100080;font-family:宋体;font-size:8pt;line-height:120%"><b> </b></font>');

        document.write('</td></tr></table>');

        document.write('</td></tr></table>');

        document.write('</td></tr></table>');

        setInterval('refreshCalendarClock()', 1000);

    </SCRIPT>

    <body bgcolor="#0099FF" OnLoad="Scroll()">
        <form name="tmForm">


        </form>

        <p> 

            <%

                String getmessage = (String) session.getAttribute("error");

                if (getmessage == null) {
                    getmessage = "";
                }

            %>

    <p1><font color="red"><%=getmessage%></font></p1></p>

<p align="center"><font color="#33FF00" size="+4" face="华文行楷">学生课绩管理系统</font></p>

<form name="frmLogin" method="post" action="login_confirm" onSubmit="return isValid(this);">

    <p> 

    <div align="center"> 

        <table width="47%" height="232" border=1 align="center"  >

            <tr > 

                <td height="44" colspan="2">

                    <div align="center"><font color="#FFFFFF" size="+2" face="华文行楷">请你输入</font></div></td>

            </tr>

            <tr > 

                <td><div align="center"><font color="#FFFFFF"><strong>用户</strong></font><font color="#FFFFFF"><strong>：</strong></font></div></td>

                <td><input name="kind" type="radio" value="student" checked >

                    <font color="#FFFFFF" size="+2" face="华文行楷">学生 </font> 

                    <input type="radio" name="kind" value="teacher">

                    <font color="#FFFFFF" size="+2" face="华文行楷"> 教师 </font>

                    <input type="radio" name="kind" value="admin">

                    <font color="#FFFFFF" size="+2" face="华文行楷">管理员</font></td>

            </tr>

            <tr > 

                <td width="27%"><div align="center"><strong><font color="#FFFFFF">登陆名</font><font color="#FFFFFF">：</font></strong></div></td>

                <td width="73%"><input name="id" type="text" id="id" size="20" maxlength="20"></td>

            </tr>

            <tr> 

                <td><div align="center"><strong> <font color="#FFFFFF">密码：</font></strong></div></td>

                <td><input name="password" type="password" id="password" size="8" maxlength="8"></td>

            </tr>

            <tr > 

                <td colspan="2"><div align="center"> 

                        <input type="submit" name="Submit" value="登陆">

                    </div></td>

            </tr>

        </table>

        <table>

        </table>    

    </div>

</form>


</body>
</html>
