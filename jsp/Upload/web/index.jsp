<%-- 
    Document   : index
    Created on : Dec 17, 2013, 10:15:55 AM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="FileUploadServlet" method='post' enctype='multipart/form-data'>

                <%-- 类型enctype用multipart/form-data，这样可以把文件中的数据作为流式数据上传，不管是什么文件类型，均可上传。--%>
                请选择要上传的背景<input type='file' name="images">
                <br>
                <input type='submit' value='提交'>
            </form>
        </div>
    </body>
</html>
