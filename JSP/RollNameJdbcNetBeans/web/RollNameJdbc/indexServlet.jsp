<%-- 
    Document   : indexServlet
    Created on : Dec 13, 2013, 3:49:08 PM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="headerFooter/header.jsp" />
<div class="container warp">
    <div class="jumbotron">
        <div class="row">
            <h1 class="text-center">开始点名(servlet)</h1>
        </div>
        <div class="row">
            <form role="form" action="/RollNameServlet" method="get">
                <input id="bt"
                       class="btn btn-lg btn-primary col-md-4 col-md-offset-4"
                       role="button" type="submit" value="开始点名" />
            </form>
            <br>
            <a href="/RollNameServlet">testServlet</a>
            <a href="/servlet/testServlet">testServlet</a>
        </div>
    </div>
</div>
</div>
<%@ include file="headerFooter/footer.jsp"%>
