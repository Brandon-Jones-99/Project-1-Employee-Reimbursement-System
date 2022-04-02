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
  <title>Approve or Deny</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged-2">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "financeManagerHomepage.jsp">Go Back</a>
            <a href = "fm-approveDenyPendingReimbursements.jsp" class="hidden-link">Go Back<a>
            <a href = "fm-viewAllPendingRequests.jsp" class="hidden-link">View All Pending</a>
            <a href = "fm-viewAllResolvedRequests.jsp" class="hidden-link">View All Resolved</a>
            <a href = "fm-viewAllEmployees.jsp" class="hidden-link">View All Employees</a>
            <a href = "fm-viewRequestsByEmployee.jsp" class="hidden-link">View Requests By Employee</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
      <h1>Reimbursement Info</h1>
        <h3><span class="span-salmon">Reimbursement ID: </span> ${reimbursement.reimbursementId}</h3>
        <h3><span class="span-salmon">Reimbursement Amount: </span>$${reimbursement.reimbursementAmount}</h3>
       <h3><span class="span-salmon">Submitted: </span> ${reimbursement.timeReimbursementSubmitted}</h3>
       <h3><span class="span-salmon">Description: </span> ${reimbursement.reimbursementDescription}</h3>
        <h3><span class="span-salmon">Author ID : </span> ${reimbursement.reimbursementAuthorId}</h3>
        <h3><span class="span-salmon">Reimbursement Type: </span> ${reimbursement.reimbursementType}</h3>
      </div>
      <div class="submission-form">
        <div class = "form-holder">
          <h2>Approve?</h2>
          <form action=<% request.getContextPath(); %>"Servlet" method="POST">
          <input type="hidden" name="action" value="approve">
          <label for="approve"></label>
          <input type="submit" name="approve" id="approve" value="Approve">
          </form>
        </div>
        <div class = "form-holder">
          <h2>Deny?</h2>
          <form action=<% request.getContextPath(); %>"Servlet" method="POST">
          <input type="hidden" name="action" value="deny">
          <label for="deny"></label>
          <input type="submit" name="deny" id="deny" value="Deny">
          </form>
        </div>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>