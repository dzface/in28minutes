<html>
    <head>
        <title>
            Login
        </title>
    </head>
    <body>
    <h1>Login</h1>
        <div class="container">
            <form method="post">
                Name : <input type="text", name = "name"><br>
                Password : <input type="password", name = "password">
                <input type="submit">
            </form>
            <pre>${errorMessage}</pre>
        </div>
    </body>
</html>