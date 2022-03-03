<jsp:include page="../include/header.jsp" />

<section class="signin">

    <div class="container min-vh-100">

        <h3 class="heading"><span>Upload Records</span></h3>

        <form method="POST" enctype="multipart/form-data" action="/user/fileUploadSubmit">

            <div class="inputBox">

                <select name="recordType" required>
                    <option value="RT" disabled selected>Select RecordType</option>
                    <option value="EHR">Electronic Health Record</option>
                    <option value="HX">Medical History</option>
                    <option value="PE">Physical Examination</option>
                    <option value="PO">Physicians Order</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="inputBox">

                <input type="file" name="file" placeholder="Select file" required><br><br>


            </div>

            <input type="submit" name="uploadform" id="filesubmit" value="Submit"  class="button"><br>

        </form>

    </div>

</section>


<jsp:include page="../include/footer.jsp" />