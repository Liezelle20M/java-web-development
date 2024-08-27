# Car Listing Web Application

Welcome to the Car Listing Web Application repository! 🚗 This project is a web-based application built with Java, Maven, SQL, JavaScript, HTML, CSS, and JDBC. It allows users to browse and search for cars, register and log in, and provides admin functionality for managing the car inventory.

# Features

- Car Listings: View a comprehensive list of cars with details like make, model, year, and price.
- Search Functionality: Search for cars using various filters.
- List of cars real-time using Server-Sent Events (SSE).
- User Authentication: Register for an account or log in to access additional features.
- Admin Panel:
  Add New Car: Admins can add new cars to the inventory.
  Delete Car: Admins can remove cars from the inventory.

# Setup Environment:

- Ensure you have Java and Maven installed on your machine.
- Configure your database settings in the src/main/resources/db.properties file.


# Build the Project:

- Run mvn clean install to build the project and install dependencies.

# Deploy the Application:

- Deploy the built .war file to a servlet container like Apache Tomcat.
- Start the servlet container and access the application via http://localhost:8080/index.jsp

# Technologies Used

- Java: Main programming language for server-side logic.
- Maven: Build automation tool.
- SQL: Database management for storing car and user information.
- JDBC: Java Database Connectivity for interacting with the SQL database.
- JavaScript: Enhancements and real-time updates using SSE.
- HTML/CSS: Frontend design and layout.
