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
  <title>Employee View Pending Request B</title>
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
            <a href = "emp-viewPendingRequests.jsp" class="hidden-link">Pending</a>
            <a href = "emp-viewResolvedRequests.jsp">Resolved</a>
            <a href = "emp-viewOrUpdateUserInfo.jsp">View/Update Info</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1>Your <span class="span-orange">Pending</span> Requests</h1>
      </div>
      <div class="dao-retrieval-holder">
      <c:forEach items='<%=request.getAttribute("pendingList")%>' var="r">
      <h4><span class="span-orange">Reimbursement ID:</span> ${r.reimbursementId} <span class="span-orange">  Amount: </span>$${r.reimbursementAmount} <span class="span-orange">  Submitted: </span>${r.timeReimbursementSubmitted}</h4>
      <h4><span class="span-orange">Description: </span>${r.reimbursementDescription} <span class="span-orange">  Author ID: </span>${r.reimbursementAuthorId}<span class="span-orange">  Type: </span>${r.reimbursementType} <span class="span-orange">  Status: </span>${r.reimbursementStatus}</h4>
      <br>
      </c:forEach>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>