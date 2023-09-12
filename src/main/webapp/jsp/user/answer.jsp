<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="nav.jsp"></jsp:include>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Details</title>
    <style>

        body {
            overflow-y: scroll;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/study/home/save" method="post">
    <input type="hidden" name="quizId" value="${quizDto.quizId}" />

    <div class="container">
        <ul>
            <c:forEach var="exam" items="${examDtoList}" varStatus="status">
                <div class="quiz-container" id="quiz${status.index}">
                    <div class="quiz-header">
                        <h2 id="question${status.index}">Question ${status.index + 1}: ${exam.content}</h2>
                        <ul>
                            <li>
                                <input type="radio" name="selectedAns[${status.index}]" id="a${status.index}" value="a" class="answer"onclick="updateAnswer(${status.index}, 'A')">

                                <label for="a${status.index}" id="a_text${status.index}"> ${exam.option1}</label>
                            </li>
                            <li>
                                <input type="radio" name="selectedAns[${status.index}]" id="b${status.index}" value="b" class="answer"onclick="updateAnswer(${status.index}, 'B')">

                                <label for="b${status.index}" id="b_text${status.index}"> ${exam.option2}</label>
                            </li>
                            <li>
                                <input type="radio" name="selectedAns[${status.index}]" id="c${status.index}" value="c" class="answer"onclick="updateAnswer(${status.index}, 'C')">
                                <label for="c${status.index}" id="c_text${status.index}"> ${exam.option3}</label>
                            </li>
                            <li>
                                <input type="radio" name="selectedAns[${status.index}]" id="d${status.index}" value="d" class="answer"onclick="updateAnswer(${status.index}, 'D')">
                                <label for="d${status.index}" id="d_text${status.index}"> ${exam.option4}</label>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
        </ul>
        <c:forEach var="correctAnswer" items="${answerDto.correctAns}" varStatus="status">
            <input type="hidden" name="correctAns[${status.index}]" value="${correctAnswer}" />
        </c:forEach>

        <button type="submit">Submit Answers</button>
        <input type="hidden" name="score" value="${answerDto.score}" />
        <input type="hidden" name="answerResults" value="${answerDto.answerResults}" />
        <input type="hidden" name="userId" value="${answerDto.userId}" />


    </div>
</form>

</body>
</html>

<script>
    // Initialize an array to store selected answers
    // Initialize an array to store selected answers
    var selectedAnswers = [];
    // Initialize an array to store correct answers
    var correctAnswers = [];

    function updateAnswer(questionIndex, selectedOption, correctOption) {
        // Update the selected answer for the specified question
        selectedAnswers[questionIndex] = selectedOption;
        // Update the correct answer for the specified question
        correctAnswers[questionIndex] = correctOption;
    }

    // Function to submit the selected answers and correct answers to the server
    function submitAnswers() {
        // Create an object to hold the selected answers and correct answers
        var answerDto = {
            selectedAnswers: selectedAnswers,
            correctAnswers: correctAnswers
        };

        // Send the answerDto to your server using AJAX or a form submission
        // You can use libraries like jQuery or plain JavaScript for this purpose
        // Example using jQuery AJAX:
        $.ajax({
            url: '/your-server-endpoint',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(answerDto),
            success: function(response) {
                // Handle the server response as needed
                alert('Answers submitted successfully');
            },
            error: function() {
                // Handle errors
                alert('Error submitting answers');
            }
        });
    }

</script>
<style>
    /* coding with nick */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap');
    *{
        box-sizing: border-box;
    }
    body{
        background-color: #b8c6db;
        background-image: linear-gradient(315deg, #b8c6db 0%, #f5f7f7 100%);
        font-family: 'Poppins', sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0;
    }
    .quiz-container{
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px 2px rgba(100, 100, 100, 0.1);
        width: 600px;
        margin-top: 20px;
        /* You can remove overflow properties for .quiz-container */
    }
    .quiz-header{
        padding: 4rem;
    }
    h2{
        padding: 1rem;
        text-align: center;
        margin: 0;
    }
    ul{
        list-style-type: none;
        padding: 0;
    }
    ul li{
        font-size: 1.2rem;
        margin: 1rem 0;
    }
    ul li label{
        cursor: pointer;
    }
    button{
        background-color: #03cae4;
        color: #fff;
        border: none;
        display: block;
        width: 100%;
        cursor: pointer;
        font-size: 1.1rem;
        font-family: inherit;
        padding: 1.3rem;
    }
    button:hover{
        background-color: #04adc4;
    }
    button:focus{
        outline: none;
        background-color: #44b927;
    }
</style>

