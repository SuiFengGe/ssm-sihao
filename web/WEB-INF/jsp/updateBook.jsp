<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改数据</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--隐藏域：用来传递一个bookId的值，用于书籍的搜索--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}">
        <div class="form-group">
            <label>书籍名称</label>
            <input type="text" class="form-control" name="bookName" value="${QBook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量</label>
            <input type="text" class="form-control" name="bookCounts" value="${QBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>作者代码</label>
            <input type="text" class="form-control" name="aid" value="${QBook.aid}" required>
        </div>

        <button type="submit" class="btn btn-default">修改</button>
    </form>
</div>
</body>
</html>

