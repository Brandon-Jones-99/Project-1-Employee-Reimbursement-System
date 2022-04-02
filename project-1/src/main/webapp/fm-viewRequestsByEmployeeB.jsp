<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="user" class="com.revature.beans.User" scope="session" />
<jsp:setProperty property="*" name="user"/>

<jsp:useBean id="r" class="com.revature.beans.Reimbursement" scope="request" />
	
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Reimbursement Requests By Employee B</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged-2">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "financeManagerHomepage.jsp">Dashboard</a>
            <a href = "fm-approveDenyPendingReimbursements.jsp">Approve/Deny<a>
            <a href = "fm-viewAllPendingRequests.jsp">View All Pending</a>
            <a href = "fm-viewAllResolvedRequests.jsp">View All Resolved</a>
            <a href = "fm-viewAllEmployees.jsp">View All Employees</a>
            <a href = "fm-viewRequestsByEmployee.jsp" class="hidden-link">View Requests By Employee</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1><span class="span-salmon">Requests By</span> Employee</h1>
      </div>
      <div class="dao-retrieval-holder">
      <c:forEach items='<%=request.getAttribute("by-Employee")%>' var="r">
      <h4><span class="span-salmon">Reimbursement ID: </span>${r.reimbursementId} <span class="span-salmon">Amount: </span>$${r.reimbursementAmount} <span class="span-salmon">Submitted: </span>${r.timeReimbursementSubmitted} <span class="span-salmon">Resolved: </span>${r.timeReimbursementResolved}</h4>
      <h4><span class="span-salmon">Description: </span>${r.reimbursementDescription} <span class="span-salmon">Author ID: </span>${r.reimbursementAuthorId} <span class="span-salmon">Resolver ID: </span>${r.reimbursementResolverId}</h4>
      <h4><span class="span-salmon">Type: </span>${r.reimbursementType} <span class="span-salmon">Status: </span>${r.reimbursementStatus}</h4>
      <br>
      </c:forEach>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>