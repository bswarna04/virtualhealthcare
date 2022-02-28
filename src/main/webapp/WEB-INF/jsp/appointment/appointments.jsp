<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp" />

<section class="appointments" id="appointments">

    <div class="container min-vh-100">

        <div class="row justify-content-center">


            <h1 class="heading"><span> make an appointment</span></h1>



            <div class="col-md-10" >

                <form action="/appointmentSubmit" method="GET">

                    <div class="inputBox">
                        <input type="hidden"  name="id">
                    </div>
                    <div class="inputBox">
                        <input type="hidden"  name="doctorId" value="${doctor_id}">
                    </div>
                    <div class="inputBox">
                        <input type="hidden"  name="patientId" value="${patient_id}">
                    </div>
                    <div class="inputBox">
                        <input type="hidden"  name="status" value="Scheduled">
                    </div>

                    <div class="inputBox">
                        <input type="text" placeholder="patientname" value="${patient_name}" >
                        <input type="text" placeholder="doctorname"  value="${docname}" >
                    </div>



                    <div class="inputBox">

                        <input type="date" name="apptDate" placeholder="Enter appointmentdate" value="${formBeanKey.apptDate}" required>

                        <select name="apptTime" value="${formBeanKey.apptTime}" required>
                            <option value="" disabled selected>Select time</option>
                            <option value="09 am">09 am</option>
                            <option value="11 am">11 am</option>
                            <option value="03 pm">03 pm</option>
                            <option value="04 pm">04 pm</option>
                        </select>
                    </div>
                    <div class="inputBox">
                        <input type="email" placeholder="your email"  value="${patient_email}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$">
                        <input type="text" placeholder="phone"  value="${phone_number}">
                    </div>


                    <textarea name="message" cols="30" rows="10" value="${formBeanKey.message}" placeholder="message ( optional )"></textarea><br><br>
                    <div class>
                        <input type="submit" name="" id="sid" value="make appointment" class="button">
                        <input type="submit" name="" id="cancel" value="cancel appointment" class="button">
                    </div>


                </form>

            </div>


        </div>

    </div>

</section>

<jsp:include page="../include/footer.jsp" />