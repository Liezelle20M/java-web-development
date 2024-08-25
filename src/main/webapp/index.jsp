<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Selection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .container {
            text-align: center;
        }
        button {
            font-size: 18px;
            padding: 10px 20px;
            margin: 10px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Selection</h1>
        <button onclick="handleUser()">User</button>
        <button onclick="handleAdmin()">Admin</button>
    </div>

    <script>
        function handleUser() {
            // Redirect to user-specific page or perform user-specific actions
            window.location.href = 'http://localhost:8080/demo/userHome.jsp'; // Replace with the actual user page URL
        }

        function handleAdmin() {
            // Prompt for admin credentials
            const username = prompt('Enter admin username:');
            const password = prompt('Enter admin password:');

            // Predefined admin credentials
            const adminUsername = 'admin';
            const adminPassword = 'password123';

            if (username === adminUsername && password === adminPassword) {
                // Redirect to admin-specific page or perform admin-specific actions
                window.location.href = 'http://localhost:8080/demo/adminHome.jsp'; // Replace with the actual admin page URL
            } else {
                alert('Invalid credentials. Please try again.');
            }
        }
    </script>
</body>
</html>

