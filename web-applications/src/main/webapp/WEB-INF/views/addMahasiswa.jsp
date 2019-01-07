<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Mahasiswa</h1>

            <p class="lead">Fill the below information to add a Mahasiswa:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/addMahasiswa" method="post"
                   commandName="mahasiswa">
        <div class="form-group">
            <label for="name">Nim</label>
            <form:input path="nim" id="nim" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="name">Nama Mahasiswa</label>
            <form:input path="namaMahasiswa" id="namaMahasiswa" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="name">Nilai Kehadiran</label>
            <form:input path="nilaiKehadiran" id="nilaiKehadiran" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Nilai UTS</label>
            <form:input path="nilaiUts" id="nilaiUts" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Nilai UAS</label>
            <form:input path="nilaiUas" id="nilaiUas" class="form-Control"/>

        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/mahasiswaList" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
