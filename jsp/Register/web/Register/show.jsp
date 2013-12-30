<%@page import="RegisterBean.Register" %>
<jsp:useBean id="register" type="RegisterBean.Register" scope="request"/>
<br>
<jsp:getProperty name="register" property="backNews"/>
<br>
<jsp:getProperty name="register" property="username" />
<br>
<jsp:getProperty name="register" property="email" />
<h1>this is show.jsp page!</h1>
