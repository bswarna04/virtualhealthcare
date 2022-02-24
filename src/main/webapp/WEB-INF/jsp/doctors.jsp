<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="include/header.jsp" />


<section class="doctors" id="doctors">

    <div class="container">

        <h1 class="heading"><span> Our Doctors </span></h1><br>
        <h1  style="text-align: center; background-color : steelblue"><span>Please select your doctor to make an appointment </span></h1><<br>


        <div class="box-container">

        <c:forEach items="${doctor_list}" var="doctor">


            <div class="box" >
<%--                <input type="radio" name="select">--%>
                <a href="/appointments?doctorid=${doctor.id}&doctorname=${doctor.firstName} ${doctor.lastName}" >

                    <h3 style="color:black;"> ${doctor.firstName} ${doctor.lastName}, ${doctor.specialization}</h3>

                    <img src="/pub/images/${doctor.doctorimg}" alt="" width="100" height="100">

                </a>
            </div>

        </c:forEach>


<%--            <div class="box" >--%>
<%--&lt;%&ndash;                <input type="radio" name="select">&ndash;%&gt;--%>
<%--                <a href="/appointments" title="doc1">--%>
<%--                    <h3 style="color:black;"> Ashley Dilley, PA--%>
<%--                        Family Medicine</h3>--%>
<%--                    <img src="/pub/images/docpic6.jpg" alt="" width="100" height="100">--%>

<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="box" >--%>
<%--&lt;%&ndash;                <input type="radio" name="select">&ndash;%&gt;--%>
<%--                <a href="/appointments" title="doc3">--%>
<%--                    <h3 style="color:black;"> Richard Kelly, PA--%>
<%--                        Family Medicine</h3>--%>
<%--                    <img src="/pub/images/docpic4.jpg" alt="" width="100" height="100">--%>

<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="box" >--%>
<%--&lt;%&ndash;                <input type="radio" name="select">&ndash;%&gt;--%>
<%--                <a href="/appointments" title="doc4">--%>
<%--                    <h3 style="color:black;"> Lalita Ram, MD--%>
<%--                        Family Medicine</h3>--%>
<%--                    <img src="/pub/images/docpic2.jpg" alt="" width="100" height="100">--%>

<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="box" >--%>
<%--&lt;%&ndash;                <input type="radio" name="select">&ndash;%&gt;--%>
<%--                <a href="/appointments" title="doc5">--%>
<%--                    <h3 style="color:black;"> Sunny Wang, PA--%>
<%--                        Family Medicine</h3>--%>
<%--                    <img src="/pub/images/docpic5.jpg" alt="" width="100" height="100">--%>

<%--                </a>--%>
<%--            </div>--%>

<%--            <div class="box">--%>
<%--&lt;%&ndash;                <input type="radio" name="select">&ndash;%&gt;--%>
<%--                <a href="/appointments" title="doc6">--%>
<%--                    <h3 style="color:black;"> Heather Williams, MD--%>
<%--                        Family Medicine</h3>--%>
<%--                    <img src="/pub/images/docpic1.jpg" alt="" width="100" height="100">--%>

<%--                </a>--%>
<%--            </div>--%>


        </div>

    </div>
</section>








<jsp:include page="include/footer.jsp" />