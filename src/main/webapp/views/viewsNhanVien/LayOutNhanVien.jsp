<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/2d1/23
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--link icon--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />




    <title>Java5_Thanhdvph27747</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/CSS/bootstrap.min.css">
    <!--GOOGLE FONTS-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Play&display=swap" rel="stylesheet">
    <%--    css--%>


    <link rel="shortcut icon"
          href="/images/BMW_logo_blue.png" type="image/x-icon">
    <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <style>
        .b:hover{
            color: #0b2e13;
        }
    </style>

</head>
<body>
<%--<div class="text-center h-25 bg-light">--%>
<%--    <img src="/images/ban.png" class="" style="width: 100%;height: 100% ">--%>

<%--</div>--%>
<nav>
    <div class="row">
        <div class="col-4">
            <div class="row mt-1">
                <div class="col-md-4">
                    <h2 class="a offset-3 " style="font-style: italic;color: #0b2e13;text-shadow: #0c2b4b 2px 3px">Greet</h2>
                </div>

                <div class="col-md-8">
                    <input
                            placeholder="Tìm kiếm"
                            type="search"
                    />
                    <button class="btn btn-outline-primary " onclick="searchs()">
                        Search
                    </button>
                </div>
            </div>

        </div>
<%--        ----%>
    <div class="col-8">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active b" aria-current="page" href="#">
                        <i class="bi bi-house-door-fill">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                                <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
                            </svg>
                        </i>
                        Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link b" href="#">
                        <i class="bi bi-person-fill">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                                <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z"/>
                            </svg>
                        </i>
                        Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link b" href="#">
                        <i class="bi bi-box-arrow-in-right">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                                <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                            </svg>
                        </i>
                        Log Out</a>
                </li>

            </ul>
    </div>
    </div>
</nav>
<%--side left--%>
<div class="row mt-2" style="min-height: 500px;">
    <div class="col-3 " style="background: #491217">
        <div class="list-group">
                <a class="list-group-item mt-5 btn btn-outline-primary" href="#" style="border-radius: 7px;">
                    <img src="/images/sneaker.png" alt="">
                    <span>Quản lí giày</span></a>

                <a class="list-group-item mt-4 btn btn-outline-secondary" href="#" style="border-radius: 7px">
                    <i class="bi bi-file-bar-graph-fill">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-bar-graph-fill" viewBox="0 0 16 16">
                            <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm-2 11.5v-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-2.5.5a.5.5 0 0 1-.5-.5v-4a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5h-1zm-3 0a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-1z"/>
                        </svg>
                    </i>Thống kê</a>


                <a href="#" class="list-group-item  mt-4 btn btn-outline-danger" style="border-radius: 7px"><i class="bi bi-box2-heart-fill">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box2-heart-fill" viewBox="0 0 16 16">
                        <path d="M3.75 0a1 1 0 0 0-.8.4L.1 4.2a.5.5 0 0 0-.1.3V15a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V4.5a.5.5 0 0 0-.1-.3L13.05.4a1 1 0 0 0-.8-.4h-8.5ZM8.5 4h6l.5.667V5H1v-.333L1.5 4h6V1h1v3ZM8 7.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
                    </svg>
                </i>Bán hàng</a>


                <a class="list-group-item btn mt-4 btn-outline-success" href="#" style="border-radius: 7px">
                    <img src="/images/account.png">
                    <span>Quản lí tài khoản</span></a>

        </div>
    </div>
    <div class="col-9">
        <jsp:include page="${ view }"/>

    </div>
</div>


<footer class="text-center">
    @Sneaker
<%--    <div class="footer">--%>
<%--        <div class="row">--%>
<%--            <ul>--%>
<%--                <li><a href="https://www.facebook.com/duy.thanh.35977897"><i class="fa fa-facebook"></i></a></li>--%>
<%--                <li><a href="#"><i class="fa fa-instagram offset-1"></i></a></li>--%>
<%--                <li><a href="#"><i class="fa fa-youtube offset-1"></i></a></li>--%>
<%--                <li><a href="#"><i class="fa fa-twitter offset-1"></i></a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>

<%--        <div class="row">--%>
<%--            <ul>--%>
<%--                <li><a href="#">Contact us</a></li>--%>
<%--                <li><a href="#">Our Services</a></li>--%>
<%--                <li><a href="#">Privacy Policy</a></li>--%>
<%--                <li><a href="#">Terms & Conditions</a></li>--%>
<%--                <li><a href="#">Career</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>

<%--        <div class="row text-center">--%>
<%--            <label class="text-center">INFERNO Copyright © 2021 Inferno - All rights reserved || Designed By:--%>
<%--                @Thanhdvph27747</label>--%>
<%--        </div>--%>
<%--    </div>--%>

</footer>

<script src="/SP23B2_SOF3011_IT17321_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>