<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Live Car Updates</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
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
        td {
            background-color: #f9f9f9;
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
        <h2>Live Car Updates</h2>
        <div id="carUpdates"></div>
    </div>

    <script>
        if (typeof(EventSource) !== "undefined") {
            const source = new EventSource("http://localhost:8080/demo/car-updates");

            source.onmessage = function(event) {
                const cars = JSON.parse(event.data);
                displayLiveUpdates(cars);
            };

            source.onerror = function(event) {
                console.error("EventSource failed:", event);
            };
        } else {
            document.getElementById("carUpdates").innerHTML = "Sorry, your browser does not support server-sent events...";
        }

        function displayLiveUpdates(cars) {
            const carUpdatesDiv = document.getElementById('carUpdates');
            carUpdatesDiv.innerHTML = '';

            if (cars.length === 0) {
                carUpdatesDiv.innerHTML = '<p>No cars found.</p>';
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

            carUpdatesDiv.appendChild(table);
        }
    </script>
</body>
</html>

