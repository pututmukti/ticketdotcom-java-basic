<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Change Word</h1>
        </div>

        <form:form action="${pageContext.request.contextPath}/changewordProcess" method="post"
                   commandName="word">
        <div class="form-group">
        		<h2>Change Upper to Lower Word</h2>
            <label for="name">Input Data</label>
            <form:input path="upperLowerWord" id="upperLowerWord" class="form-Control"/>
            <br>
            <p> Result : ${resultUpperLowerWord} </p>
        </div>

        <div class="form-group">
        		<h2>Remove Vocal Word</h2>
            <label for="name">Input Data</label>
            <form:input path="removeVocalWord" id="removeVocalWord" class="form-Control"/>
            <br>
            <p> Result : ${resultRemoveVocalWord} </p>
        </div>

        <div class="form-group">
            <h2>Calculate Same Word and Remove</h2>
            <label for="name">Input Data</label>
            <form:input path="calculateSameWord" id="calculateSameWord" class="form-Control"/>
            <br>
            <p> Result : ${resultCalculateSameWord} </p>
        </div>

        <div class="form-group">
            <h2>Calculate Word</h2>
            <label for="price">Input Data</label>
            <form:textarea path="calculateWord" id="calculateWord" class="form-Control"/>
            <br>
            <p> Result :  </p>
            <br>
            <p> Jumlah kata :  ${countWord} </p>
            <br>
            <p> Jumlah kata yang hanya muncul satu kali :  ${countUniqueWord} </p>
            <br>
            <p> kata yang paling banyak muncul :  <br> ${countAlwaysWord} </p>
            <br>
            <p> kata yang paling sedikit muncul :  <br> ${countRareWord} </p>
        </div>


        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/mahasiswaList" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
