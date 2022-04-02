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
  <title>Approve or Deny Pending Reimbursements</title>
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
            <a href = "fm-viewAllPendingRequests.jsp">View All Pending</a>
            <a href = "fm-viewAllResolvedRequests.jsp">View All Resolved</a>
            <a href = "fm-viewAllEmployees.jsp">View All Employees</a>
            <a href = "fm-viewRequestsByEmployee.jsp">View Requests By Employee</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1><span class="span-salmon">Approve/Deny</span> Pending Reimbursements</h1>
      </div>
      <div class="submission-form">
        <div class = "form-holder">
          <h2>View Pending Requests to Approve or Deny?</h2>
          <form action=<% request.getContextPath(); %>"Servlet" method="GET">
          <input type="hidden" name="action" value="see-request">
          <label for="approval-request-reimbursement-id">Enter Reimbursement ID to Approve or Deny : </label>
          <input type="number" name="approval-request-reimbursement-id" id="approval-request-reimbursement-id"><br><br>
            <a href="fm-approveOrDeny.jsp"><input type="submit" value="Get Request"></a>
          </form>
        </div>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>