<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../include/header.jsp" />

<section class="signin" id="signin" >

    <div class="container min-vh-100">

        <h3 class="heading"><span> Appointments List</span></h3>

        <form action="/appointmentList" method="GET">

<div >

    <table class="table table-striped">
    <tr>
        <td><b>Id</b></td>
        <td><b>PatientName</b></td>
        <td><b>DoctorName</b></td>
        <td><b>AppointmentDate</b></td>
        <td><b>AppointmentTime</b></td>
        <td><b>Status</b></td>
        <td><b>Edit</b></td>

    </tr>
    <c:forEach items="${appointmentListKey}" var="appointment">
        <tr>

            <td>${appointment.id}</td>
            <td>${appointment.patient.firstName} ${appointment.patient.lastName}</td>
            <td>${appointment.doctor.firstName} ${appointment.doctor.lastName}</td>
            <td><fmt:formatDate pattern="MM-dd-yyyy" value = "${appointment.apptDate}"/></td>
            <td>${appointment.apptTime}</td>
            <td>${appointment.status}</td>

            <c:set var = "status" value = "${appointment.status}"/>
            <c:if test = "${status == 'Scheduled'}">
                    <td><a class="btn btn-primary"  role="button" onclick="myFunction()"
                           href="/cancelAppointment?id=${appointment.id}">Cancel</a></td>
            </c:if>

        </tr>
    </c:forEach>
        </form>
</div>

</section>
<script>
    function myFunction() {
        confirm("Are you sure you want to cancel the appointment?");

    }
</script>


