<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .header {
            text-align: center;
            padding: 20px 0;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px 5px 0 0;
        }
        .navbar {
            text-align: center;
            margin: 20px 0;
        }
        .navbar a {
            display: inline-block;
            padding: 10px 20px;
            margin: 0 10px;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
            border: 1px solid #007bff;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        .navbar a:hover {
            background-color: #007bff;
            color: #fff;
        }
        .navbar a:first-child {
            border-left: none;
        }
        .content {
            text-align: center;
            margin: 20px 0;
        }
        .content p {
            font-size: 24px;
            color: #333;
        }
        .footer {
            text-align: center;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome Admin</h1>
        </div>
        <div class="navbar">
            <a href="http://localhost:8080/demo/adminHome.jsp">Home</a>
            <a href="http://localhost:8080/demo/addcar.jsp">Add a Car</a>
            <a href="http://localhost:8080/demo/DeleteCar.jsp">Delete a Car</a>
            
        </div>
        <div class="content">
            <p>Welcome to the Admin Page. Use the navigation bar to manage cars.</p>
        </div>
    </div>
    <div class="footer">
        <p>&copy; 2024 Car Management System</p>
    </div>
</body>
</html>
