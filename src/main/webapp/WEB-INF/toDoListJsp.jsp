
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>
            To do list
        </title>
    </head>
    <body>
        <div class="container">
            <div>Welcome ${name}</div>
            <div>Your to do list</div>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>description</th>
                        <th>target date</th>
                        <th>done</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach items="${list}" var = "item">
                    <tr>
                    <td>${item.id}</td>
                    <td>${item.description}</td>
                    <td>${item.targetDate}</td>
                    <td>${item.done}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

</html>