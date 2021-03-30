<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragrma","no-cache");
  response.setDateHeader("Expires",0);
%>
<html>
<head>
  <title>登录页面</title>
 <script>
document.onreadystatechange = function () {
           if (document.readyState == "complete") {
               document.body.style.display = "block";
            } else {
                document.body.style.display = "none";
             }
       }
 </script>

  <!-- 引入 Bootstrap -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body background="/image/bg.jpg" style="background-size:100% 100% ; background-attachment: fixed">
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>登录页面</small>
        </h1>
      </div>
    </div>
  </div>

  <div style="background-color: cadetblue;width: 300px ; height: 380px;">

  <div style="background: whitesmoke;color: red;height: 50px;">
    <img src="../../image/logo.png" style="float: left;height: 90%">
    <label style="line-height: 50px;padding-left:10% ">${sessionScope.get('msg')}</label>
  </div>

  <form action="${pageContext.request.contextPath}/user/login" method="post">
    <div class="form-group" style="padding-top: 20px;padding-left: 20px">
      <label>用户名</label>
      <input type="text" style="width:85%;" class="form-control" name="username" required>
    </div>
    <div class="form-group" style="padding-left: 20px">
      <label>密码</label>
      <input type="password" style="width:85%;" class="form-control" name="password" required>
    </div>
    <div class="form-group" style="padding-left: 20px">
      <div style="display: inline-block;width: 40%">
        <label>验证码</label>
        <input style="width:85%;" type="text" class="form-control" id="verifyCode" name="verifyCode" required>
      </div>
      <div style="display: inline-block;">
        <img style="width:100%;padding-right: 20px;padding-bottom: 3px" id="checkcode" src="checkCode" alt="" width="100" height="32" class="passcode" onclick="this.src=this.src+'?'">
      </div>
    </div>
    <div class="form-group" style="text-align: center;width: 85%">
      <button type="submit" style="width: 30%;background-color: lightskyblue" class="btn btn-default">提交</button>
    </div>

  </form>
  <div class="reg" style="padding-left: 20px">没有账户？<a href="${pageContext.request.contextPath}/user/doLogout">立即注册</a></div>
</div>
</div>
</body>
</html>