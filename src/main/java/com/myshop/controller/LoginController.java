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

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDao customerDao;

    public void init() {
        customerDao = new CustomerDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.getWriter().println("Success");
        login(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("Login.html");
    }

    private void login(HttpServletRequest request,
            HttpServletResponse response)
 throws IOException, ServletException {

// get values from login form
String uname= request.getParameter("username");
String pwd = request.getParameter("password");
response.getWriter().println(uname);
response.getWriter().println(pwd);

// check user using DAO
Customer customer = null;
  //  customerDao.findCustomer(username, password);

// if user exists
if (customer != null) {

 System.out.println("Login success: "
         + customer.getEmail());

 // send data to JSP
 request.setAttribute("customer", customer);

 RequestDispatcher dispatcher =
         request.getRequestDispatcher("listcustomers.jsp");

 dispatcher.forward(request, response);

} else {

 System.out.println("Invalid login");

 // go back to login page
 response.sendRedirect("welcome.html");
}
}

}