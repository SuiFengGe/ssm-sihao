<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body background="/image/bg.jpg" style="background-size:100% 100% ; background-attachment: fixed">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户注册</small>
                </h1>
            </div>
        </div>
    </div>
    <div style="background-color: cadetblue;width: 300px ; height: 350px;">

        <div style="background: whitesmoke;color: red;height: 50px;">
            <img src="../../image/logo.png" style="float: left;height: 90%">
        </div>

<form action="${pageContext.request.contextPath}/user/addUser" method="post">
    <div class="form-group" style="padding-top: 20px;padding-left: 20px">
        <label>用户名</label>
        <input type="text" style="width:85%;" class="form-control" name="username" required>
    </div>
    <div class="form-group" style="padding-left: 20px">
        <label>密码</label>
        <input type="password" style="width:85%;" class="form-control" name="password" required>
    </div>
    <div class="form-group" style="padding-left: 20px">
        <label>邮箱</label>
        <input type="email" style="width:85%;" class="form-control" name="email" required>
    </div>
    <div class="form-group" style="text-align: center;width: 85%">
        <button type="submit" style="width: 30%;background-color: lightskyblue" class="btn btn-default">提交</button>
    </div>

</form>
</div>
</div>
</body>
</html>