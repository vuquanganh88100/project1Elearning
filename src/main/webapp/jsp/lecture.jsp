<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
    <style>
        /* Your CSS styles here */
    </style>
</head>
<body>
<div class="container">
    <h1>Course Details</h1>
    <h2>Course Name: ${courseDto.courseName}</h2>

    <h3>Lectures:</h3>
    <ul>
        <c:forEach var="lecture" items="${lectures}">
            <li>
                <h4>Lecture Title: ${lecture.lectureTitle}</h4>
                <div class="video-container">
                    <iframe width="560" height="315" th:src="@{https://www.youtube.com/embed/{url}(url=${lecture.videoUrl}}" ></iframe>
                </div>
            </li>
        </c:forEach>
    </ul>

    <a href="/study/admin/backend/lecture/upload">Back to Upload</a>
</div>

</body>
</html>
