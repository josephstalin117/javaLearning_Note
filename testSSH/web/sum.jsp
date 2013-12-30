<%-- 
    Document   : sum
    Created on : Dec 26, 2013, 10:15:41 AM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        求代数和
        <br/>
        <s:form action="mystruts/sum.action" >                
            <s:textfield name="operand1" label=" 操作数1"/>
            <s:textfield name="operand2"  label=" 操作数2" />        
            <s:submit value="代数和" />            
        </s:form>
    </body>
</html>
