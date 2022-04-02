<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
<jsp:setProperty property="*" name="user"/>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View or Update User Info</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged">
    <div class = "menu-logged">
      <div class = "nav-block">
          <nav class = "nav-holder">
            <a href = "employeeHomepage.jsp">Dashboard</a>
            <a href = "emp-submitRequest.jsp">Submit Request</a>
            <a href = "emp-viewPendingRequests.jsp">Pending</a>
            <a href = "emp-viewResolvedRequests.jsp">Resolved</a>
            <a href = "emp-viewOrUpdateUserInfo.jsp"class="hidden-link">View/Update Info</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
      </div>
      <div class = "header-class">
        <h1>View User Information</h1>
      </div>
      <h3><span class="span-orange">User ID: </span>${user.userId}</h3>
      <h3><span class="span-orange">First name: </span>${user.firstName}</h3>
      <h3><span class="span-orange">Last name: </span>${user.lastName}</h3>
      <h3><span class="span-orange">Username: </span>${user.username}</h3>
      <h3><span class="span-orange">Password: </span>${user.password}</h3>
      <h3><span class="span-orange">User Type: </span>${user.userType}</h3>
      <h3><span class="span-orange">Email: </span>${user.email}</h3>
      <div class="submission-form">
        <br>
        <div class>
          <h2>Do You Want To <span class="span-orange">Update</span> Your User Info?
          </h2>
            <a href="emp-updateUserInfo.jsp"><input type="submit" value="Go To Update Form"></a>
        </div>
      </div>
    </div>
  </div>

<script src="./scripts.js"></script>

</body>
</html>