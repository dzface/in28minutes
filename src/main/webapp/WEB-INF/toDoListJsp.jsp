<%@ include file="common/header.jspf"%>
        <%@ include file="common/navigation.jspf"%>
        <div class="container">
            <div>Your to do list</div>
            <table class="table">
                <thead>
                    <tr>
                        <th>description</th>
                        <th>target date</th>
                        <th>done</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach items="${list}" var = "item">
                    <tr>
                        <td>${item.description}</td>
                        <td>${item.targetDate}</td>
                        <td>${item.done}</td>
                        <td><a href="update-todo?id=${item.id}" class="btn btn-Info">Edit</a></td>
                        <td><a href="delete-todo?id=${item.id}" class="btn btn-warning">Del</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <%@ include file="common/footer.jspf"%>
    </body>

</html>