package com.demo.servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.UserDao;
import com.demo.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDao userDAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        try {
            String hashedPassword = hashPassword(password);
            User user = new User(username, hashedPassword, email, firstname, lastname);
            boolean success = userDAO.registerUser(user);

            if (success) {
                // Redirect to login page after successful registration
                response.sendRedirect("http://localhost:8080/demo/login.jsp");
            } else {
                // Redirect to registration page with an error message
                response.sendRedirect("http://localhost:8080/demo/register.jsp?error=Registration+Failed");
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new ServletException(e);
        }
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}
