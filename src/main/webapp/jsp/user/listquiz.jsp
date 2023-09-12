<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <scrip src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></scrip>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container d-flex justify-content-center">
    <ul class="list-group mt-5 text-white">
        <c:forEach items="${quizDtos}" var="quizDto">
            <li class="list-group-item d-flex justify-content-between align-content-center"  >
                <div class="d-flex flex-row">
                    <img src="https://img.icons8.com/color/100/000000/folder-invoices.png" width="40" onclick="window.location.href='${pageContext.request.contextPath}/study/home/course${courseId}/quizs/${quizId}"/>
                    <div class="ml-2">
                        <h6 class="mb-0">${quizDto.testName}</h6>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
<style>
    body{
        background: #4527A0;
    }

    .list-group{
        width: 400px !important;

    }

    .list-group-item{
        margin-top:10px;
        border-radius: none;
        background: #5E35B1;
        cursor: pointer;
        transition: all 0.3s ease-in-out;
    }


    .list-group-item:hover{
        transform: scaleX(1.1);
    }



    .check{
        opacity: 0;
        transition: all 0.6s ease-in-out;
    }

    .list-group-item:hover .check {
        opacity: 1;

    }

    .about span{
        font-size: 12px;
        margin-right: 10px;

    }

    input[type=checkbox] {
        position: relative;
        cursor: pointer;
    }
    input[type=checkbox]:before {
        content: "";
        display: block;
        position: absolute;
        width: 20px;
        height: 20px;
        top: 0px;
        left: 0;
        border: 1px solid #10a3f9;
        border-radius: 3px;
        background-color: white;

    }
    input[type=checkbox]:checked:after {
        content: "";
        display: block;
        width: 7px;
        height: 12px;
        border: solid #007bff;
        border-width: 0 2px 2px 0;
        -webkit-transform: rotate(45deg);
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
        position: absolute;
        top: 2px;
        left: 6px;
    }

    input[type="checkbox"]:checked + .check { opacity: 1; }
</style>