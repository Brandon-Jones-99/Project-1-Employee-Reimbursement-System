<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./finalStyles.css">
  <title>HomePage</title>
</head>
<body>
 <video autoplay muted loop> <source src = "./blueSkyVideo1.mp4"></video>
<!--  <div class="backup-background">   -->
<div class = "main">
  <div class = "magic">
    <div class = "menu">
      <div class = "header-class"><h1>Login Form</h1></div>
      <div><p>Please select your position at the company, then login using your credentials</p></div>
      <div class = "form-container">

          <p class="form-message">Invalid Credentials, Please Try Again</p>
          
      <form action="<% request.getContextPath(); %>Servlet" method="POST">
        <input type="hidden" name="action" value="login">
        <input type="radio" id="employee" name="employee-type" value="employee" required checked>
        <label for ="employee"><span class="span-orange">Employee</span></label>
        <input type="radio" id="finance-manager" name="employee-type" value="finance-manager" required>
        <label for ="finance-manager"><span class = "span-salmon">Finance Manager</span></label><br><br>
        <label for ="username">Your Username</label><br>
        <input type="text" name="username" id ="username" required><br><br>
        <label for ="password">Your Password</label><br>
        <input type="password" name="password" id="password" required>
        <br><br>
        <input type ="submit" value="Login" id="login_submit">
        <br>
        </form>
      </div>
    </div>
  </div>
</div>
<!--</div> -->

<script src ="./scripts.js"></script>

</body>
</html>