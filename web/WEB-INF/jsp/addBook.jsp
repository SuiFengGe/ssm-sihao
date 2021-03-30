<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    <div class="form-group">
        <label>书籍名称</label>
        <input type="text" class="form-control" name="bookName" required>
    </div>
    <div class="form-group">
        <label>书籍数量</label>
        <input type="text" class="form-control" name="bookCounts" required>
    </div>
    <div class="form-group">
        <label>作者代码</label>
        <input type="text" class="form-control" name="aid" required>
    </div>

    <button type="submit" class="btn btn-default">提交</button>
</form>
</div>
</body>
</html>
