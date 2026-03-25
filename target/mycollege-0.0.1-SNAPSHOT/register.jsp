<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration Page</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

</head>
<body>
 <div class="container">
 <div class="row text-center" style="color: tomato;">
  <h2>Customer Registration with JSP, Servlet and Hibernate</h2>
 </div>
 <hr>
  <div class="row col-md-10 col-md-offset-3"> 
   
   <div class="card card-body">
   
    <h2>User Register Form</h2>
    <div class="col-md-8 col-md-offset-3">

     <form action="<%=request.getContextPath()%>/register" method="post">

      <div class="form-group">
       <label for="uname">First Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="First Name"
        name="firstName" required>
      </div>

      <div class="form-group">
       <label for="uname">Last Name:</label> <input type="text"
        class="form-control" id="uname" placeholder="last Name"
        name="lastName" required>
      </div>

      <div class="form-group">
       <label for="uname">User Name:</label> <input type="text"
        class="form-control" id="username" placeholder="User Name"
        name="username" required>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="password" required>
      </div>

      <div class="form-group">
       <label for="uname">Email:</label> <input type="text"
        class="form-control" id="email" placeholder="Enter Email Address"
        name="email" required>
      </div>

      <div class="form-group">
       <label for="uname">Date Of Birth:</label> <input type="text"
        class="form-control" id="dob" placeholder="Date Of Birth"
        name="dob" required>
      </div>

      <div class="form-group">
       <label for="uname">Mobile:</label> <input type="text"
        class="form-control" id="mobile" placeholder="Mobile Number"
        name="mobile" required>
      </div>

      <button type="submit" class="btn btn-primary">Register</button>

     </form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>