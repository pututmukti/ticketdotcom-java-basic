<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Mahasiswa</h1>
            
            <p>Jumlah mahasiswa ${name}</p>

        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>No</th>
                <th>Nim</th>
                <th>Nama</th>
                <th>Nilai Akhir</th>
                <th>Grade</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${mahasisList}" var="mahasiswa">
                <tr>
                		<td>${mahasiswa.id}</td>
                	    <td>${mahasiswa.nim}</td>
                	    <td>${mahasiswa.namaMahasiswa}</td>
                    <td>${mahasiswa.nilaiAkhir}</td>
                    <td>${mahasiswa.grade}</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${mahasiswa.id}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
            <tr>
		      <td colspan="6">Jumlah Mahasiswa : ${jumlahMahasiswa}</td>
		    </tr>
		    <tr>
		      <td colspan="6">Jumlah Mahasiswa yg Lulus : ${jumlahMahasiswaLulus}</td>
		    </tr>
		    <tr>
		      <td colspan="6">Jumlah Mahasiswa yg Tidak Lulus : ${jumlahMahasiswaTidakLulus}</td>
		    </tr>
        </table>
        <a href="<spring:url value="/mahasiswaAdd" />" class="btn btn-primary">Add Mahasiswa</a>
        

<%@include file="/WEB-INF/views/template/footer.jsp" %>
