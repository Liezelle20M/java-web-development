package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.CarDao;
import com.demo.model.Car;
import com.google.gson.Gson;

@WebServlet("/car-updates")
public class CarUpdatesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarDao carDAO = new CarDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            Runnable task = () -> {
                try {
                    List<Car> cars = carDAO.getAllCars();
                    String json = new Gson().toJson(cars);
                    out.write("data: " + json + "\n\n");
                    out.flush();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            };
            
            // Schedule the task to run every 5 seconds
            executor.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

            // Keep the connection open until the client disconnects
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10000); // Check every 10 seconds for interruption
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                }
            }

            executor.shutdownNow(); // Shut down the executor when done
        }
    }
}


