<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="nav.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Lecture</title>
    <style>
        /* Your CSS styles here */
    </style>
</head>
<body>
<div class="container">
    <h1>Upload Lecture</h1>
    <%--@elvariable id="lectureDto" type=""--%>
    <f:form id="uploadForm" action="/study/admin/backend/lecture/save" method="post" modelAttribute="lectureDto">
        <label for="courseId">Select Course:</label>
        <select id="courseId" name="courseId">
            <c:forEach var="course" items="${courseList}">
                <option value="${course.courseId}"> ${course.courseName}</option>
            </c:forEach>
        </select>
        <label for="lectureTitle">Lecture Name:</label>
        <input type="text" id="lectureTitle" name="lectureTitle" required>
        <label for="videoUrl">YouTube Link:</label>
        <input type="text" id="videoUrl" name="videoUrl" required>
        <button type="submit">Upload</button>
    </f:form>
    <div id="videoContainer"></div>
</div>

</body>
</html>
