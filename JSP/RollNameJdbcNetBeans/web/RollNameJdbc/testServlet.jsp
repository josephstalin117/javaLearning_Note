<%-- 
    Document   : testServlet
    Created on : Dec 13, 2013, 3:00:15 PM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
    <div class="jumbotron">
        <div class="row">
            <form role="form" action="/servlet/testServlet" method="get">
                <div class="form-group">
                    <label for="inputId" id="testClick">学号</label>
                    <input type="text" class="form-control" id="inputId" placeholder="id" name="id" autocomplete="off">
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary col-md-4 col-md-offset-4" id="submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
