<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
<jsp:setProperty property="*" name="user"/>

<jsp:useBean id="reimbursement" class="com.revature.beans.Reimbursement" scope="session" />
	<jsp:setProperty property="*" name="reimbursement" />
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee View Resolved Requests</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "employeeHomepage.jsp">Dashboard</a>
            <a href = "emp-submitRequest.jsp">Submit Request</a>
            <a href = "emp-viewPendingRequests.jsp">Pending</a>
            <a href = "emp-viewResolvedRequests.jsp" class="hidden-link">Resolved</a>
            <a href = "emp-viewOrUpdateUserInfo.jsp">View/Update Info</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1>View <span class="span-orange">Resolved </span>Requests</h1>
      </div>
      <div class="submission-form">
        <div class = "form-holder">
          <h2>View Your Resolved Requests?
          </h2>
          <form action=<% request.getContextPath(); %>"Servlet" method="GET">
          	<input type="hidden" name="action" value="view-resolved-requests">
            <input type="submit" value="Yes, Please">
          </form>
        </div>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>