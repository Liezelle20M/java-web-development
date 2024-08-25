<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add a New Car</title>
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
            border-radius: 8px;
            margin-top: 20px;
        }
        .header {
            text-align: center;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border-radius: 8px 8px 0 0;
        }
        .navbar {
            display: flex;
            justify-content: center;
            background-color: #007bff;
            padding: 10px;
            border-radius: 0 0 8px 8px;
            margin-bottom: 20px;
        }
        .navbar a {
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            font-size: 18px;
            transition: background-color 0.3s, color 0.3s;
            border-radius: 5px;
            margin: 0 10px;
        }
        .navbar a:hover {
            background-color: #0056b3;
        }
        form {
            max-width: 600px;
            margin: auto;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
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
    <div class="navbar">
        <a href="http://localhost:8080/demo/adminHome.jsp">Home</a>
            <a href="http://localhost:8080/demo/addcar.jsp">Add a Car</a>
            <a href="http://localhost:8080/demo/DeleteCar.jsp">Delete a Car</a>
    </div>
    <div class="container">
        <div class="header">
            <h2>Add a New Car</h2>
        </div>
        <form id="addCarForm" action="addCar" method="post">
            <label for="addregistration">Registration:</label>
            <input type="text" id="addregistration" name="registration" required><br>
            <label for="addmake">Make:</label>
            <input type="text" id="addmake" name="make" required><br>
            <label for="addmodel">Model:</label>
            <input type="text" id="addmodel" name="model" required><br>
            <label for="addcolor">Color:</label>
            <input type="text" id="addcolor" name="color" required><br>
            <label for="addyear">Year:</label>
            <input type="number" id="addyear" name="year" required><br>
            <label for="addprice">Price:</label>
            <input type="number" step="0.01" id="addprice" name="price" required><br>
            <button type="submit">Add Car</button>
        </form>
    </div>
    <div class="footer">
        <p>&copy; 2024 Car Management System</p>
    </div>
</body>
</html>



