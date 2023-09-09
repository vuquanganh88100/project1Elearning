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
    <h1>Upload Quiz</h1>
    <%--@elvariable id="quizDto" type=""--%>
    <f:form id="uploadForm" action="/study/admin/backend/quiz/save" method="post" modelAttribute="quizDto">
        <label for="courseId">Select Course:</label>
        <select id="courseId" name="courseId">
            <c:forEach var="course" items="${courselist}">
                <option value="${course.courseId}"> ${course.courseName}</option>
            </c:forEach>
        </select>
        <label for="testName">Quiz Name:</label>
        <input type="text" id="testName" name="testName" required>
        <button type="submit">Upload</button>
    </f:form>
    <div></div>
</div>

</body>
</html>
