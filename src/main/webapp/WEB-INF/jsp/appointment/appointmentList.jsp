<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<section class="signin" id="signin" >

    <div class="container min-vh-100">

        <h3 class="heading"><span> Appointments List</span></h3>

        <form action="/appointmentList" method="GET">



            <%--        <form  id="signinform" action="/loginSubmit" method="get">--%>

            <%--&lt;%&ndash;            <h1 style="color:red">${errorMessage}</h1>&ndash;%&gt;--%>

<%--            <div class="inputBox">--%>
<%--                <input type="text" name="search" placeholder="Enter your search" required>--%>

<%--            </div>--%>



<%--            <input type="submit" name="search"  value="Search"  class="button">--%>



<%--        </form>--%>

<%--    </div>--%>



<div >



<table class="table table-striped">
    <tr>
        <td><b>Id</b></td>
<%--        <td><b>PatientName</b></td>--%>
<%--        <td><b>DoctorName</b></td>--%>
        <td><b>AppointmentDate</b></td>
        <td><b>AppointmentTime</b></td>
        <td><b>Status</b></td>
<%--        <td><b>Edit</b></td>--%>
<%--        <td><b>Delete</b></td>--%>

    </tr>
    <c:forEach items="${appointmentListKey}" var="appointment">
        <tr>
            <td>${appointment.id}</td>
<%--            <td>${appointment.username}</td>--%>
<%--            <td>${appointment.email}</td>--%>
            <td>${appointment.apptDate}</td>
            <td>${appointment.apptTime}</td>
            <td>${appointment.status}</td>
<%--            <td><a href="/registration-url-path/register?id=${appointment.id}">Edit</a></td>--%>
<%--            <td><a href="/registration-url-path/deleteUser?id=${appointment.id}">Delete</a></td>--%>

<%--        </tr>--%>
    </c:forEach>
</div>
</section>


