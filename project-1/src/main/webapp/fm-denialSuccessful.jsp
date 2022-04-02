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
  <title>Reimbursement Denied!</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged-2">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "financeManagerHomepage.jsp">Dashboard</a>
            <a href = "fm-approveDenyPendingReimbursements.jsp" class="hidden-link">Approve/Deny</a>
            <a href = "fm-viewAllPendingRequests.jsp" class="hidden-link">View All Pending</a>
            <a href = "fm-viewAllResolvedRequests.jsp" class="hidden-link">View All Resolved</a>
            <a href = "fm-viewAllEmployees.jsp" class="hidden-link">View All Employees</a>
            <a href = "fm-viewRequestsByEmployee.jsp" class="hidden-link">View Requests By Employee</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1><span class="span-orange">Reimbursement Successfully Denied</span></h1>
      </div>
       <img src="denial.gif" alt="denial.gif">
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>