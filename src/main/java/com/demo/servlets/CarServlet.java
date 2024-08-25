package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.CarDao;
import com.demo.model.Car;

public class CarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarDao carDAO = new CarDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Car> cars = carDAO.getAllCars();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><head><title>All Cars</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
            out.println(".nav-bar { background-color: #007bff; padding: 10px; color: #fff; text-align: center; }");
            out.println(".nav-bar a { color: #fff; text-decoration: none; padding: 10px 15px; font-weight: bold; transition: background-color 0.3s; }");
            out.println(".nav-bar a:hover { background-color: #0056b3; }");
            out.println(".container { width: 80%; max-width: 1000px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("table { width: 100%; border-collapse: collapse; }");
            out.println("table, th, td { border: 1px solid #ddd; }");
            out.println("th, td { padding: 10px; text-align: left; }");
            out.println("th { background-color: #007bff; color: #fff; }");
            out.println("td { background-color: #f9f9f9; }");
            out.println("</style>");
            out.println("</head><body>");

            out.println("<div class='nav-bar'>");
            out.println("<a href='http://localhost:8080/demo/userpage.jsp'>Home</a>");
            out.println("<a href='http://localhost:8080/demo/Search.jsp'>Search a Car</a>");
            out.println("<a href='http://localhost:8080/demo/cars'>List Cars</a>");
            out.println("<a href='http://localhost:8080/demo/SSE.jsp'>Car Live Updates</a>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<h1>All Cars</h1>");
            out.println("<table><tr><th>ID</th><th>Registration</th><th>Make</th><th>Model</th><th>Color</th><th>Year</th><th>Price</th></tr>");

            for (Car car : cars) {
                out.println("<tr>");
                out.println("<td>" + car.getId() + "</td>");
                out.println("<td>" + car.getRegistration() + "</td>");
                out.println("<td>" + car.getMake() + "</td>");
                out.println("<td>" + car.getModel() + "</td>");
                out.println("<td>" + car.getColor() + "</td>");
                out.println("<td>" + car.getYear() + "</td>");
                out.println("<td>" + car.getPrice() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</div>");
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

