<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="nav.jsp"></jsp:include>
<link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous"
/>

<div class="containerCourse" id="containerCourse">
    <div class="category" id="quiz"onclick="window.location.href='${pageContext.request.contextPath}/study/home/course${courseId}/quizs'" >
        <img src="https://media.istockphoto.com/id/1186386668/vector/quiz-in-comic-pop-art-style-quiz-brainy-game-word-vector-illustration-design.jpg?s=612x612&w=0&k=20&c=mBQMqQ6kZuC9ZyuV5_uCm80QspqSJ7vRm0MfwL3KLZY=" width="300px" height="200px" alt="Albums Solo">
        <h2>QUIZ</h2>
    </div>
    <div class="category" id="lecture"onclick="window.location.href='${pageContext.request.contextPath}/study/home/course${courseId}/lectures'">
        <img src="data:image/png;base64,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" width="300px" height="200px" alt="Albums Duet">
        <h2>LECTURE VIDEO</h2>
    </div>
</div>
<style>
    .containerCourse {
        display: flex;
        flex-wrap: nowrap;
        justify-content: space-between;
        width: 100%;
        max-width: 1440px;
        margin: 0 auto;
        background-color: #fff;
        padding: 50px;
        margin-top: 50px;
    }
    .category {
        flex-basis: 48%;
        margin: 20px;
        padding: 20px;
        border-radius: 10px;
        box-sizing: border-box;
        text-align: center;
        background: linear-gradient(45deg, #ff0084, #33001b);
        color: white;
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
    }

    .category:hover {
        transform: translateY(-5px);
        box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.3);
    }

    .category img {
        max-width: 100%;
        height: auto;
        margin-bottom: 10px;
        border-radius: 50%;
        border: 2px solid white;
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
    }

    .category h2 {
        margin: 0;
        font-size: 24px;
        font-weight: 600;
        color: white;
    }
    #quiz{
        background: aqua;
    }
    #lecture{
        background: coral;
    }
</style>
