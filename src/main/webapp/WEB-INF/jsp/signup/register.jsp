
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../include/header.jsp" />

<section class="signup" id="signup">

    <div class="container min-vh-100">

        <h3 class="heading"><span> Signup</span></h3>

        <form  id="signupform" action="/registerSubmit" method="GET">

            <div class="inputBox">
                <input type="hidden"  name="id" value="${formBeanKey.id}">

            </div>
            <div class="inputBox">
                  <input type="text"  name="username"  value="${formBeanKey.username}" placeholder="Enter username" required>

              </div>

            <div class="inputBox">
                <input type="text"  name="firstName"  value="${formBeanKey.firstName}" placeholder="Enter Firstname" required>


            </div>

            <div class="inputBox">
                <input type="text"  name="lastName" value="${formBeanKey.lastName}" placeholder="Enter Lastname"  required>

            </div>

                 <div class="inputBox">

                     <input placeholder="Enter your Date of Birth" class="textbox-n" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" value="${formBeanKey.dateOfBirth}" name="dateOfBirth" />


                 </div>
               <div class="inputBox">

               <input type="text"  name="phoneNumber" value="${formBeanKey.phoneNumber}" placeholder="Enter PhoneNumber"  required>

                </div>

            <div class="inputBox">
                <input type="text"  name="email" value="${formBeanKey.email}" placeholder="Enter Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" required>

            </div>

            <div class="inputBox">
                <input type="password"  name="password" value="${formBeanKey.password}" placeholder="Enter Password"  required>

            </div>

            <div class="inputBox">
                <input type="password"  name="confirmPassword" value="${formBeanKey.confirmPassword}" placeholder="Reenter Password"  required>

            </div>

            <input type="submit"  id="signupsubmit" value="Signup"  class="button"><br>



        </form>

        <div style="color:red">
            <c:forEach items="${formBeanKey.errorMessages}" var="message">
                <span style="color:red">${message}</span><br>
            </c:forEach>

        </div>

    </div>

</section>



<%--<jsp:include page="../include/footer.jsp" />--%>