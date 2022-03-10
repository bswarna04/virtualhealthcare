<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />



    <section class="signin" id="signin" >

        <div class="container min-vh-100">


<form method="get" action="/medicalRecords">

    <h3 class="heading"><span>Medical Records</span></h3>
    <div class="inputBox">
    <sec:authorize access="hasAnyAuthority('ADMIN')">
                       <input type="text" name="search" placeholder="Enter Record Type" required>

                       <input type="submit" class="button"><br><br><br>
    </sec:authorize>

               </div>



</form>


<form method="get" action="/saveRecord">
<table class="table table-striped">
    <input type="hidden"  name="editID" value="${editRecID}">
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
            <c:set var = "editID" value = "${editRecID}"/>
            <c:set var = "currentRecID" value = "${record.id}"/>

            <c:choose>
                <c:when test="${editID == 0 or editID != currentRecID}">
                    <td>${record.recordType}</td>
                </c:when>
                <c:when test="${editID == currentRecID}">
                    <td class="inputBox">

                        <select name="recordType" required>
                            <option value="RT" disabled selected>Select RecordType</option>
                            <option value="EHR">Electronic Health Record</option>
                            <option value="HX">Medical History</option>
                            <option value="PE">Physical Examination</option>
                            <option value="PO">Physicians Order</option>
                            <option value="Other">Other</option>
                        </select>
                    </td>
                </c:when>
            </c:choose>

            <td><a href="${record.fileName}" target="_blank">${record.fileName}</a></td>
            <td><fmt:formatDate pattern="MM-dd-yyyy" value = "${record.dateUploaded}"/></td>
            <td>${record.patient.firstName} ${record.patient.lastName}</td>
            <td><a class="btn btn-primary"  role="button" href="/viewrecords?editRecID=${record.id}">Edit</a></td>
            <td><a class="btn btn-primary"  role="button" onclick="myFunction1()"
               href="/deleteRecord?id=${record.id}">Delete</a></td>

<%--            <td><a href="/deleteRecord?id=${record.id}">Delete</a></td>--%>

        </tr>
    </c:forEach>

</table>
<c:if test = "${editID > 0}">
    <div class>
        <input type="submit" name="" value="Save" class="button">
    </div>
</c:if>
</form>
        </div>

</section>
<script>
    function myFunction1() {
        confirm("Do you really want to delete this record?");

    }
</script>


<%--<jsp:include page="../include/footer.jsp" />--%>

