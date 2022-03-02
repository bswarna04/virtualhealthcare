<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp" />



    <section class="signin" id="signin" >

        <div class="container min-vh-100">

<%--            <h3 class="heading"><span>Medical Records</span></h3>--%>

<form method="get" action="/medicalRecords">

    <h3 class="heading"><span>Medical Records</span></h3>
    <div class="inputBox">

                       <input type="text" name="search" placeholder="Enter Record Type" required>

                       <input type="submit" class="button"><br><br><br>


               </div>



</form>

<table class="table table-striped">
    <tr>

        <td><b>Record Type</b></td>
        <td><b>File Name</b></td>
        <td><b>Date Uploaded</b></td>
        <td><b>Patient Name</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>

    </tr>
    <c:forEach items="${recordsKey}" var="record" >
        <tr>

            <td>${record.recordType}</td>
            <td>${record.fileName}</td>
            <td><fmt:formatDate pattern="MM-dd-yyyy" value = "${record.dateUploaded}"/></td>
            <td>${record.patient.firstName} ${record.patient.lastName}</td>
            <td><a href="/registration-url-path/register?id=${record.id}">Edit</a></td>
            <td><a href="/deleteRecord?id=${record.id}">Delete</a></td>

        </tr>
    </c:forEach>

</table>
        </div>

</section>



<jsp:include page="../include/footer.jsp" />

