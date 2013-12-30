<jsp:include page="headerFooter/header.jsp" />
<link href="css/signUp.css" rel="stylesheet">
<div class="container">

    <form class="form-signin" role="form" action="../HandelRegister" method="get">
        <h2 class="form-signin-heading">Register</h2>
        <input type="text" class="form-control" name="username" placeholder="Pick a username" required autofocus>
        <input type="email" class="form-control" name="email" placeholder="Your Email" required>
        <input type="password" class="form-control" name="password" placeholder="Create a Password" required>
        <p class="text-danger">By clicking "Sign up for Register", you agree to our terms of service and privacy policy.</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up for register</button>
    </form>
    <a href="http://localhost:8084/Register/HandelRegister">test</a>
</div> <!-- /container -->
<jsp:include page="headerFooter/footer.jsp"/>