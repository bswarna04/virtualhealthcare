<jsp:include page="../include/header.jsp" />

<section class="signin" id="signin" >

    <div class="container min-vh-100">

        <h3 class="heading"><span> Sign In</span></h3>

        <form action="/login/loginSecurityPost" method="POST">

            <h1 style="color:red">${errorMessage}</h1>

            <div class="inputBox">
                <input type="text" name="username" placeholder="Enter Username" required>

            </div>

            <div class="inputBox">
                <input type="password" name="password" placeholder="Enter Password"  required>

            </div>

            <input type="submit" name="signinform" id="signinsubmit" value="submit"  class="button"><br>

            <div><h4>Don't have an account? <span><a href="/register">Signup here</a></span></h4></div>

        </form>

    </div>

</section>

<script src="/pub/js/main.js"></script>

<jsp:include page="../include/footer.jsp" />