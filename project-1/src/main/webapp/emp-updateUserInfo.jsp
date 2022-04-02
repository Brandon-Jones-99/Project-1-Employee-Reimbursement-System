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
  <title>Update User Info</title>
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
        <h1><span class="span-orange">Update</span> User Information</h1>
      </div>
    
      <div class="submission-form">
        <br>
        <div class = "form-holder">
          <h2>Commit Update?
          </h2>
          <form action=<% request.getContextPath(); %>"Servlet" method="POST">
          	<a href="viewOrUpdateUserInfo.jsp"><input type="hidden" name="action" value="update-user-info"></a>
            <input type="submit" value="Update">
            <label for="update-username"><h3><span class="span-orange">Username: </span>${user.username}</h3></label>
            <input type="text" id="update-username" name="update-username" placeholder="(insert new username)">
            <label for="update-password"><h3><span class="span-orange">Password: </span>${user.password}</h3></label>
            <input type="text" id="update-password" name="update-password" placeholder="(insert new password)">
			<label for="update-email"><h3><span class="span-orange">Email: </span>${user.email}</h3></label>
            <input type="text" id="update-email" name="update-email" placeholder="(insert new email)">
          </form>
          <br><br>
          <p>(if you need to change your first name, last name, user id, or user type, please see a system administrator)</p>
        </div>
      </div>
    </div>
  </div>

<script src="./scripts.js"></script>

</body>
</html>