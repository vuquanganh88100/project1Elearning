<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Material Design for Bootstrap</title>
    <!-- MDB icon -->
    <link rel="icon" href="/img/mdb-favicon.ico" type="image/x-icon" />
    <!-- Font Awesome -->
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />
    <!-- Google Fonts Roboto -->
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"
    />
    <!-- MDB -->
    <link rel="stylesheet" href="/css/mdb.min.css" />
</head>
<body>
<!--Main Navigation-->
<header>
    <!-- Sidebar -->
    <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white">
        <div class="position-sticky">
            <div class="list-group list-group-flush mx-3 mt-4">
                <a
                        href='/study/admin/backend/upload'
                        class="list-group-item list-group-item-action py-2 ripple"
                        aria-current="true"

                >
                    <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>COURSE</span>
                </a>
                <a href='/study/admin/backend/user/list' class="list-group-item list-group-item-action py-2 ripple">
                    <i class="fas fa-chart-area fa-fw me-3"></i><span>USER</span>
                </a>
                <a href='/study/admin/backend/lecture/upload' class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-lock fa-fw me-3"></i><span>LECTURE</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-chart-line fa-fw me-3"></i><span>Quiz</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple">
                    <i class="fas fa-chart-pie fa-fw me-3"></i><span>Exam</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-chart-bar fa-fw me-3"></i><span>Orders</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-globe fa-fw me-3"></i><span>International</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-building fa-fw me-3"></i><span>Partners</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-calendar fa-fw me-3"></i><span>Calendar</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-users fa-fw me-3"></i><span>Users</span></a
                >
                <a href="#" class="list-group-item list-group-item-action py-2 ripple"
                ><i class="fas fa-money-bill fa-fw me-3"></i><span>Sales</span></a
                >
            </div>
        </div>
    </nav>
    <!-- Sidebar -->

    <!-- Navbar -->
    <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
        <!-- Container wrapper -->
        <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#sidebarMenu"
                    aria-controls="sidebarMenu"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>

            <!-- Brand -->
            <a class="navbar-brand" href="#">
                <img
                        src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
                        height="25"
                        alt="MDB Logo"
                        loading="lazy"
                />
            </a>
            <!-- Search form -->
            <form class="d-none d-md-flex input-group w-auto my-auto">
                <input
                        autocomplete="off"
                        type="search"
                        class="form-control rounded"
                        placeholder='Search (ctrl + "/" to focus)'
                        style="min-width: 225px;"
                />
                <span class="input-group-text border-0"><i class="fas fa-search"></i></span>
            </form>

            <!-- Right links -->
            <ul class="navbar-nav ms-auto d-flex flex-row">
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
                            href="#"
                            id="navbarDropdownMenuLink"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        <img
                                src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img (31).webp"
                                class="rounded-circle"
                                height="22"
                                alt="Avatar"
                                loading="lazy"
                        />
                    </a>

                    <ul
                            class="dropdown-menu dropdown-menu-end"
                            aria-labelledby="navbarDropdownMenuLink"
                    >
                        <li>
                            <a class="dropdown-item" href="#">My profile</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Settings</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/study/home/logout">Logout</a>
                        </li>
                    </ul>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <div class="nav-item dropdown">
                        <a href="#" data-toggle="dropdown" class="nav-link " aria-expanded="false">${fn:substring(pageContext.request.userPrincipal.name, 0, 3)}</a>
                        <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown1111">
                        </ul>
                    </div>
                </sec:authorize>
                <!-- Avatar -->

            </ul>
        </div>
        <!-- Container wrapper -->
    </nav>
    <!-- Navbar -->
</header>
<!--Main Navigation-->

<!--Main layout-->
<main style="margin-top: 58px;">
    <div class="container pt-4"></div>
</main>
<!--Main layout-->
<style>

</style>
<!-- MDB -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Custom scripts -->
<script type="text/javascript"></script>
</body>
</html>
<style>

    @media (min-width: 991.98px) {
        main {
            padding-left: 240px;
        }
    }

    /* Sidebar */
    .sidebar {
        position: fixed;
        top: 0;
        bottom: 0;
        left: 0;
        padding: 58px 0 0; /* Height of navbar */
        box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
        width: 240px;
        z-index: 600;
    }

    @media (max-width: 991.98px) {
        .sidebar {
            width: 100%;
        }
    }
    .sidebar .active {
        border-radius: 5px;
        box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
    }

    .sidebar-sticky {
        position: relative;
        top: 0;
        height: calc(100vh - 48px);
        padding-top: 0.5rem;
        overflow-x: hidden;
        overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
    }
</style>
