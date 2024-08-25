<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            padding: 20px;
            background-color: #fff;
            margin: 20px auto;
            max-width: 900px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        nav {
            margin: 20px 0;
            background-color: #007bff;
            padding: 10px;
            border-radius: 4px;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 4px;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        nav a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, User!</h1>
        <nav>
            <a href="http://localhost:8080/demo/userpage.jsp">Home</a>
            <a href="http://localhost:8080/demo/Search.jsp">Search a Car</a>
            <a href="http://localhost:8080/demo/cars">List Cars</a>
            <a href="http://localhost:8080/demo/SSE.jsp">Car Live Updates</a>
        </nav>
    </div>
</body>
</html>
