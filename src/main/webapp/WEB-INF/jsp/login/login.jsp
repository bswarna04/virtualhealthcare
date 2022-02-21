<jsp:include page="../include/header.jsp" />

<section class="signin" id="signin" >

    <div class="container min-vh-100">

        <h3 class="heading"><span> Sign In</span></h3>

        <form action="/login/loginSecurityPost" method="POST">

            <h1 style="color:red">${errorMessage}</h1>

<%--        <form  id="signinform" action="/loginSubmit" method="get">--%>

<%--&lt;%&ndash;            <h1 style="color:red">${errorMessage}</h1>&ndash;%&gt;--%>

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

<%--    <div>--%>

<%--        <h2>${signin_response}--%>
<%--&lt;%&ndash;            <span><a href="/signin">Signin here</a></span>&ndash;%&gt;--%>

<%--        </h2>--%>
<%--    </div>--%>

</section>



<jsp:include page="../include/footer.jsp" />