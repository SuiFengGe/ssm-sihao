<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragrma","no-cache");
    response.setDateHeader("Expires",0);
%>
<html>
<head>
    <title>首页</title>


    <style>
        div{
            text-align: center;
            padding-top: 7%;
        }
    </style>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background: url(image/bg.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<div >
    <div>
        <h1>繁星纵变，智慧永恒!</h1>
    </div>

    <div>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/user/toLogin" role="button">阅读，从心开始</a></p>

    </div>

</div>


</body>
</html>
