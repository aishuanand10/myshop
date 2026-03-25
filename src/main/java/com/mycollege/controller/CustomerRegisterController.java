package com.mycollege.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mycollege.model.CustomerDao;
import com.mycollege.model.Customer;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class CustomerRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDao customerDao;

    public void init() {
        customerDao = new CustomerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	response.getWriter().println("Success");
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String mobile = request.getParameter("mobile");

        Customer customer = new Customer(firstName, lastName, username, password, email, dob, mobile);

        customerDao.saveCustomer(customer);
        
        response.sendRedirect("Welcome.html");
       // RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
        //dispatcher.forward(request, response);
    }
}