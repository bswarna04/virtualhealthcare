<jsp:include page="../include/header.jsp" />

<section class="signin">

    <div class="container min-vh-100">

        <h3 class="heading"><span>Upload Records</span></h3>

        <form method="POST" enctype="multipart/form-data" action="/user/fileUploadSubmit">


            <div class="inputBox">

                <input type="text" name="filetitle" placeholder="Enter title" required><br><br>


            </div>

            <div class="inputBox">

                <input type="file" name="file" placeholder="Select file" required><br><br>


            </div>

            <input type="submit" name="uploadform" id="filesubmit" value="Submit"  class="button"><br>



        </form>

    </div>



</section>


<%--<h3 class="heading"><span>Upload Records</span></h3>--%>

<%--<form method="POST" enctype="multipart/form-data" action="/user/fileUploadSubmit">--%>
<%--    Title : <input type="text" name="title"/><br><br>--%>
<%--    Select File: <input type="file" name="file"/><br><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>


<jsp:include page="../include/footer.jsp" />