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
  <title>Submission Successful!</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "employeeHomepage.jsp">Back To Dashboard</a>
            <a href = "emp-submitRequest.jsp" class="hidden-link">Submit Request</a>
            <a href = "emp-viewPendingRequests.jsp" class="hidden-link">Pending</a>
            <a href = "emp-viewResolvedRequests.jsp" class="hidden-link">Resolved</a>
            <a href = "emp-viewOrUpdateUserInfo.jsp" class="hidden-link">View/Update Info</a>
            <a href = "index.jsp" class="hidden-link">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1><span class="span-orange">Submission Successfully Requested</span></h1>
      </div>
       <img src="success.gif" alt="success.gif">
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>