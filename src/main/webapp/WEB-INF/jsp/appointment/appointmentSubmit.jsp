<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp" />

<section class="registersubmit" id="registersubmit" >

    <div class="container min-vh-100">
        <br>
        <br><br><br><br> <br>
        <br><br><br><br><br><br>

        <div>
            <fmt:formatDate var="fmtDate" value="${appointmentdate}" pattern="MM/dd/yyyy"/>
<%--            <fmt:formatDate pattern="MM-dd-yyyy" value = "${appointment.apptDate}"/>--%>
              <h2>Your appointment is successfully scheduled at "${fmtDate} ${appointmenttime}"</h2>

        </div>

    </div>

</section>

<jsp:include page="../include/footer.jsp" />