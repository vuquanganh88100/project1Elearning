<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap Navbar Dropdown Login and Signup Form with Social Buttons</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: 'Varela Round', sans-serif;
        }
        .form-control {
            box-shadow: none;
            font-weight: normal;
            font-size: 13px;
        }
        .navbar {
            background: rgb(225, 155, 234)!important;
            padding-left: 16px;
            padding-right: 16px;
            border-bottom: 1px solid #dfe3e8;
            border-radius: 0;
        }
        .nav-link img {
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin: -8px 0;
            float: left;
            margin-right: 10px;
        }
        .navbar .navbar-brand {
            padding-left: 0;
            font-size: 20px;
            padding-right: 50px;
        }
        .navbar .navbar-brand b {
            color: #33cabb;
        }
        .navbar .form-inline {
            display: inline-block;
        }
        .navbar a {
            color: #888;
            font-size: 15px;
        }
        .search-box {
            position: relative;
        }
        .search-box input {
            padding-right: 35px;
            border-color: #dfe3e8;
            border-radius: 4px !important;
            box-shadow: none
        }
        .search-box .input-group-text {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 7px;
            height: 100%;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
        }
        .navbar .sign-up-btn {
            min-width: 110px;
            max-height: 36px;
        }
        .navbar .dropdown-menu {
            color: #999;
            font-weight: normal;
            border-radius: 1px;
            border-color: #e5e5e5;
            box-shadow: 0 2px 8px rgba(0,0,0,.05);
        }
        .navbar a, .navbar a:active {
            color: #888;
            padding: 8px 20px;
            background: transparent;
            line-height: normal;
        }
        .navbar .navbar-form {
            border: none;
        }
        .navbar .action-form {
            width: 280px;
            padding: 20px;
            left: auto;
            right: 0;
            font-size: 14px;
        }
        .navbar .action-form a {
            color: #33cabb;
            padding: 0 !important;
            font-size: 14px;
        }
        .navbar .action-form .hint-text {
            text-align: center;
            margin-bottom: 15px;
            font-size: 13px;
        }
        .navbar .btn-primary, .navbar .btn-primary:active {
            color: #fff;
            background: #33cabb !important;
            border: none;
        }
        .navbar .btn-primary:hover, .navbar .btn-primary:focus {
            color: #fff;
            background: #31bfb1 !important;
        }

        .navbar .social-btn .btn i {
            margin-right: 5px;
            font-size: 16px;
            position: relative;
            top: 2px;
        }
        .or-seperator {
            margin-top: 32px;
            text-align: center;
            border-top: 1px solid #e0e0e0;
        }
        .or-seperator b {
            color: #666;
            padding: 0 8px;
            width: 30px;
            height: 30px;
            font-size: 13px;
            text-align: center;
            line-height: 26px;
            background: #fff;
            display: inline-block;
            border: 1px solid #e0e0e0;
            border-radius: 50%;
            position: relative;
            top: -15px;
            z-index: 1;
        }
        .navbar .action-buttons .dropdown-toggle::after {
            display: none;
        }
        .form-check-label input {
            position: relative;
            top: 1px;
        }
        @media (min-width: 1200px){
            .form-inline .input-group {
                width: 300px;
                margin-left: 30px;
            }
        }
        @media (max-width: 768px){
            .navbar .dropdown-menu.action-form {
                width: 100%;
                padding: 10px 15px;
                background: transparent;
                border: none;
            }
            .navbar .form-inline {
                display: block;
            }
            .navbar .input-group {
                width: 100%;
            }
        }
    </style>
    <script>
        // Prevent dropdown menu from closing when click inside the form
        $(document).on("click", ".action-buttons .dropdown-menu", function(e){
            e.stopPropagation();
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a href="#" class="navbar-brand">VQA<b>EDU</b></a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <div class="navbar-nav">
            <a href="#" class="nav-item nav-link">Home</a>
            <div class="nav-item dropdown">
                <a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle">Services</a>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">Web Design</a>
                    <a href="#" class="dropdown-item">Web Development</a>
                    <a href="#" class="dropdown-item">Graphic Design</a>
                    <a href="#" class="dropdown-item">Digital Marketing</a>
                </div>
            </div>
            <a href="#" class="nav-item nav-link">Blog</a>
            <a href="#" class="nav-item nav-link">Contact</a>
        </div>
        <form class="form-inline ml-auto">
            <div class="input-group search-box">
                <input type="text" id="search" class="form-control" placeholder="Search here...">
                <div class="input-group-append">
                    <span class="input-group-text">
                        <i class="material-icons">&#xE8B6;</i>
                    </span>
                </div>
            </div>
        </form>
        <sec:authorize access="!isAuthenticated()">
            <div class="navbar-nav ml-auto action-buttons">
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle mr-4" onclick="window.location.href='/study/home/login'">Login</a>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle sign-up-btn"onclick="window.location.href='/study/home/signup'">Sign up</a>
                </div>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="nav-item dropdown">
                <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle mr-4" aria-expanded="false">${fn:substring(pageContext.request.userPrincipal.name, 0, 3)}</a>
                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown1111">
                    <li><a class="dropdown-item" href="/backend/user/change-pass">Đổi mật khẩu</a></li>
                    <li><a class="dropdown-item" href="/backend/brand/category">Thông tin tài khoản</a></li>
                    <li><a class="dropdown-item" href="/study/home/logout">Đăng xuất</a></li>
                </ul>
            </div>
        </sec:authorize>
    </div>
</nav>

</body>
</html>