<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Selection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
            width: 80%;
            max-width: 400px;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 15px 25px;
            font-size: 18px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            margin: 10px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome</h1>
        <a href="http://localhost:8080/demo/login.jsp" class="button">Login</a>
        <a href="http://localhost:8080/demo/register.jsp" class="button">Register</a>
    </div>
</body>
</html>
