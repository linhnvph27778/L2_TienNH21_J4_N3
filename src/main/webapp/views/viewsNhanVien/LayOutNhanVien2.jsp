<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .nav-link{
            color: #0b2e13
        }
        .b:hover{
            color:black;
        }
        .w{
            text-decoration: none;
            color: black;
        }
        .tab{

            color: black;
        }
        .active{

            color: brown;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<nav>
    <div class="row">
        <div class="col-4">
            <div class="row mt-1">
                <div class="col-10">
                    <h2 class="a offset-3 " style="font-style: italic;color: #0b2e13;text-shadow: #0c2b4b 2px 3px">Greet Sneaker</h2>
                </div>

            </div>


        </div>

        <div class="col-8">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active b" aria-current="page" href="#" style="color: black;">
                        <i class="bi bi-house-door-fill">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                                <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
                            </svg>
                        </i>
                        Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link b" href="#">
                        <i class="bi bi-person-fill" style="">
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

<div class="row mt-3" style="min-height: 500px;">
    <div class="col-md-3 ">
        <div class="row">
            <div class="col-3 offset-1">
                Quản trị
            </div>
            <div class="col-8">
                <hr>
            </div>
        </div>
        <div class="list-group mt-3">

            <a class="w tab active list-group-item btn btn-outline-primary" >
                <img src="/images/sneaker.png" alt="">
                Quản lí giày
            </a>

            <a class="w tab list-group-item btn btn-outline-secondary" >
                <i class="bi bi-file-bar-graph-fill">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-bar-graph-fill" viewBox="0 0 16 16">
                        <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm-2 11.5v-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-2.5.5a.5.5 0 0 1-.5-.5v-4a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5h-1zm-3 0a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-1z"/>
                    </svg>
                </i>Thống kê
            </a>

            <a class="w tab list-group-item btn btn-outline-danger" ><i class="bi bi-box2-heart-fill">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box2-heart-fill" viewBox="0 0 16 16">
                    <path d="M3.75 0a1 1 0 0 0-.8.4L.1 4.2a.5.5 0 0 0-.1.3V15a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V4.5a.5.5 0 0 0-.1-.3L13.05.4a1 1 0 0 0-.8-.4h-8.5ZM8.5 4h6l.5.667V5H1v-.333L1.5 4h6V1h1v3ZM8 7.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
                </svg>
            </i>Bán hàng
            </a>

            <a class="w tab list-group-item btn btn-outline-success">

                <img src="/images/account.png">
                Quản lí tài khoản
            </a>

        </div>
    </div>
    <div class="col-md-9">
        <jsp:include page="${ view }"/>

    </div>
</div>


<footer class="text-center">
    @Sneaker

</footer>
</body>

<script>
    const tabs = document.querySelectorAll('.tab');
    tabs.forEach(
        tab=>{
            tab.addEventListener('click',()=>{
                tabs.forEach(tab=>{
                    tab.classList.remove('active');
                });
                tab.classList.add('active');
            });
        }
    );
</script>
</html>
