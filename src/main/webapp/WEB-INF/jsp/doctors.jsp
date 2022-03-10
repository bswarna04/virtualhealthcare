<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="include/header.jsp" />


<section class="doctors" id="doctors">

    <div class="container">

        <h1 class="heading"><span> Our Doctors </span></h1><br>
        <h1  style="text-align: center; background-color : steelblue"><span>Please select your doctor to make an appointment </span></h1><br>


        <div class="box-container">

        <c:forEach items="${doctor_list}" var="doctor">


            <div class="box" >

                <a href="/appointments?doctorid=${doctor.id}&doctorname=${doctor.firstName} ${doctor.lastName}" >

                    <h3 style="color:black;"> ${doctor.firstName} ${doctor.lastName}, ${doctor.specialization}</h3>

                    <img src="/pub/images/${doctor.doctorimg}" alt="" width="100" height="100">

                </a>
            </div>

        </c:forEach>


        </div>

    </div>
</section>

<jsp:include page="include/footer.jsp" />