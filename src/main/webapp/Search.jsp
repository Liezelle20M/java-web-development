<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Cars</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        .nav-bar {
            background-color: #007bff;
            padding: 10px;
            color: #fff;
            text-align: center;
        }
        .nav-bar a {
            color: #fff;
            text-decoration: none;
            padding: 10px 15px;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .nav-bar a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="nav-bar">
        <a href="http://localhost:8080/demo/userpage.jsp">Home</a>
        <a href="http://localhost:8080/demo/Search.jsp">Search a Car</a>
        <a href="http://localhost:8080/demo/cars">List Cars</a>
        <a href="http://localhost:8080/demo/SSE.jsp">Car Live Updates</a>
    </div>
    <div class="container">
        <h2>Search Cars</h2>
        <form id="searchForm" method="POST" action="searchCars">
            <label for="makeSearch">Make:</label>
            <input type="text" id="makeSearch" name="make">
            <label for="modelSearch">Model:</label>
            <input type="text" id="modelSearch" name="model">
            <label for="yearSearch">Year:</label>
            <input type="number" id="yearSearch" name="year">
            <button type="submit">Search</button>
        </form>
        <div id="resultsDiv"></div>
    </div>

    <script>
        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            searchCars();
        });

        function searchCars() {
            const make = document.getElementById('makeSearch').value;
            const model = document.getElementById('modelSearch').value;
            const year = document.getElementById('yearSearch').value;

            const xhr = new XMLHttpRequest();
            xhr.open('POST', 'searchCars', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    const cars = JSON.parse(xhr.responseText);
                    console.log('Response received:', cars);
                    displayCars(cars);
                }
            };

            xhr.send('make=' + encodeURIComponent(make) + '&model=' + encodeURIComponent(model) + '&year=' + encodeURIComponent(year));
        }

        function displayCars(cars) {
            const resultsDiv = document.getElementById('resultsDiv');
            resultsDiv.innerHTML = '';

            if (!Array.isArray(cars) || cars.length === 0) {
                resultsDiv.innerHTML = '<p>No cars found.</p>';
                return;
            }

            const table = document.createElement('table');
            const headerRow = table.insertRow();
            headerRow.insertCell().innerText = 'ID';
            headerRow.insertCell().innerText = 'Registration';
            headerRow.insertCell().innerText = 'Make';
            headerRow.insertCell().innerText = 'Model';
            headerRow.insertCell().innerText = 'Color';
            headerRow.insertCell().innerText = 'Year';
            headerRow.insertCell().innerText = 'Price';

            cars.forEach(car => {
                const row = table.insertRow();
                row.insertCell().innerText = car.id;
                row.insertCell().innerText = car.registration;
                row.insertCell().innerText = car.make;
                row.insertCell().innerText = car.model;
                row.insertCell().innerText = car.color;
                row.insertCell().innerText = car.year;
                row.insertCell().innerText = car.price;
            });

            resultsDiv.appendChild(table);
        }
    </script>
</body>
</html>



