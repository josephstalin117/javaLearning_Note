<%--
Document   : index
Created on : Dec 20, 2013, 8:29:08 AM
Author     : josephstalin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/carousel.css" rel="stylesheet">
        <title>学生选课系统</title>
    </head>
    <%
        String error = (String) session.getAttribute("error");

        if (error != null) {
            if (error.equals("fail")) {
    %>
    <script>
        $("#submit").click(function() {
            alert("帐号密码错误！");
            return false;
        });

    </script>
    <%
            }
        }
    %>
    <body>
        <!--nav-->
        <div class="navbar-wrapper">
            <div class="container">
                <div class="navbar navbar-inverse navbar-static-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#">CRS Project</a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">主页</a></li>
                                <li><a href="#about">关于</a></li>
                                <li><a href="#contact">联系我们</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li class="dropdown-header">Nav header</li>
                                        <li><a href="#">Separated link</a></li>
                                        <li><a href="#">One more separated link</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/nav-->
        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" src="images/bg0.jpg">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 style="font-family: 微软雅黑">学生选课系统</h1>
                            <p>曾经我是一个孤独男孩，在没有遇到它之前，我的世界是黑白的</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button" data-toggle="modal" data-target="#myModal">Login in</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" src="images/bg1.jpg">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 style="font-family: 微软雅黑">学生选课系统</h1>
                            <p>但是就是他让我找回了男人往日的自信</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button" data-toggle="modal" data-target="#myModal">Login in</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" src="images/bg2.jpg">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 style="font-family: 微软雅黑">学生选课系统</h1>
                            <p>妈妈再也不担心我的选课了</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button" data-toggle="modal" data-target="#myModal">Login in</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
        </div><!-- /.carousel -->
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">欢迎登陆CRS选课系统</h4>
                    </div>
                    <form role="form" action="LoginServlet" method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Account</label>
                                <input type="text" class="form-control" id="inputAccount" name="username" placeholder="Enter account">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Your Role</label>
                                <select class="form-control" id="inputRole" name="role">
                                    <option value="1">学生</option>
                                    <option value="2">教师</option>
                                    <option value="3">管理员</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" id="submit">Login in</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->
        <div class="container marketing">
            <!-- Three columns of text below the carousel -->
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" data-src="holder.js/140x140" alt="Generic placeholder image" src="images/0.jpg">
                    <h2>潘晨峰</h2>
                    <p>首席创意师</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" data-src="holder.js/140x140" alt="Generic placeholder image" src="images/0.jpg">
                    <h2>林永泽</h2>
                    <p>项目经理，首席架构师</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" data-src="holder.js/140x140" alt="Generic placeholder image" src="images/0.jpg">
                    <h2>马钰杰</h2>
                    <p>首席数据库工程师</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
            </div><!-- /.row -->
            <!-- START THE FEATURETTES -->
            <hr class="featurette-divider">
            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">强劲架构<span class="text-muted">高内聚，低藕合</span></h2>
                    <p class="lead">采用基于抽象工厂的系统内核，可拓展性极强，完整的MVC分层。</p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image" src="images/DAOFactory.png">
                </div>
            </div>
            <hr class="featurette-divider">
            <div class="row featurette">
                <div class="col-md-5">
                    <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image" src="images/QR.jpg">
                </div>
                <div class="col-md-7">
                    <h2 class="featurette-heading">构建丰富的前端界面。 <span class="text-muted">css+div+js</span></h2>
                    <p class="lead">基于bootstrap前端框架，兼容移动端的响应式布局</p>
                </div>
            </div>
            <hr class="featurette-divider">
            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">完善安全的基于角色的权限控制<span class="text-muted">让您的数据更安全</span></h2>
                    <p class="lead">密码经过md5加密,同时基于角色的信息管理让系统更加文件</p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="Generic placeholder image" src="images/R.png">
                </div>
            </div>
            <hr class="featurette-divider">
            <!-- /END THE FEATURETTES -->
            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="#">Back to top</a></p>
                <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>
        </div><!-- /.container -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>