package com.demo.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.database.UserDao;
import com.demo.model.User;
import com.google.gson.Gson;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{


    
   
    private static final long serialVersionUID = 1L;
	private UserDao userDAO = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            String hashedPassword = hashPassword(password);
            User user = userDAO.loginUser(username, hashedPassword);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (user != null) {
                // Set session attribute for logged-in user
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                response.getWriter().write(new Gson().toJson("Login Successful"));
                response.sendRedirect("http://localhost:8080/demo/userpage.jsp");

                // Set sessionStorage item to indicate successful login
                response.getWriter().write("<script>sessionStorage.setItem('loggedIn', 'true');</script>");
            } else {
                response.getWriter().write(new Gson().toJson("Invalid Credentials"));
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new ServletException(e);
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        // Reuse the hashing method from RegisterServlet
        RegisterServlet registerServlet = new RegisterServlet();
        return registerServlet.hashPassword(password);
    }



}
