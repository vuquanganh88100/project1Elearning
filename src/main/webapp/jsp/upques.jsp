<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Survey Form</title>
    <style type="text/css">
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #888888;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        h1 {
            text-align: center;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], select {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
<h1>Survey Form</h1>
<form action="/study/admin/backend/exam/save" method="post">
    <label for="quizId">Select Course:</label>
    <select id="quizId" name="quizId">
        <c:forEach var="exam" items="${quizDtos}">
            <option value="${exam.quizId}"> ${exam.testName}</option>
        </c:forEach>
    </select>
    <label for="quesNum">Question number :</label>
    <input type="text" id="quesNum" name="quesNum" required>
    <label for="content">Question:</label>
    <input type="text" id="content" name="content" required>

    <label for="option1">Answer A:</label>
    <input type="text" id="option1" name="option1" required>

    <label for="option2">Answer B:</label>
    <input type="text" id="option2" name="option2" required>

    <label for="option3">Answer C:</label>
    <input type="text" id="option3" name="option3" required>

    <label for="option4">Answer D:</label>
    <input type="text" id="option4" name="option4" required>

    <label for="correctAns">Correct Answer:</label>
    <select id="correctAns" name="correctAns">
        <option value="">--Please choose an option--</option>
        <option value="a" name="option1" value="option1">A</option>
        <option value="b"name="option2"value="option2">B</option>
        <option value="c"name="option3"value="option3">C</option>
        <option value="d"name="option4"value="option4">D</option>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>


