package com.mycollege.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mycollege.model.CustomerDao;
import com.mycollege.model.Customer;

/**
 * @author Aishwarya Anandakumar
 */

@WebServlet("/listCustomers")
public class ListCustomersController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDao customerDao;

    public void init() {
        customerDao = new CustomerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        listCustomers(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        listCustomers(request, response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String mobile = request.getParameter("mobile");
		*/
    	
        List<Customer> customers = new ArrayList<>();

        customers = customerDao.getCustomerList();
        request.setAttribute("customers", customers);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listcustomers.jsp");
        dispatcher.forward(request, response);
    }
}