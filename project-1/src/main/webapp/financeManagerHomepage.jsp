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
  <title>Finance Manager Homepage</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged-2">
    <div class = "menu-logged">
      <div class = "header-class">
      <h1>Hello <span class="span-rose">${user.firstName} ${user.lastName}</span></h1>
        <h1><span class="magic-letters-4">W</span><span class="magic-letters-4">e</span><span class="magic-letters-4">l</span><span class="magic-letters-4">c</span><span class="magic-letters-4">o</span><span class="magic-letters-4">m</span><span class="magic-letters-4">e</span> <span class="magic-letters-4">t</span><span class="magic-letters-4">o</span> <span class="magic-letters-4">t</span><span class="magic-letters-4">h</span><span class="magic-letters-4">e</span> <span class="magic-letters-3">F</span><span class="magic-letters-3">i</span><span class="magic-letters-3">n</span><span class="magic-letters-3">a</span><span class="magic-letters-3">n</span><span class="magic-letters-3">c</span><span class="magic-letters-3">e</span> <span class="magic-letters-3">M</span><span class="magic-letters-3">a</span><span class="magic-letters-3">n</span><span class="magic-letters-3">a</span><span class="magic-letters-3">g</span><span class="magic-letters-3">e</span><span class="magic-letters-3">r</span> <span class="magic-letters-4">D</span><span class="magic-letters-4">a</span><span class="magic-letters-4">s</span><span class="magic-letters-4">h</span><span class="magic-letters-4">b</span><span class="magic-letters-4">o</span><span class="magic-letters-4">a</span><span class="magic-letters-4">r</span><span class="magic-letters-4">d</span><span class="magic-letters-4">!</span></h1>
        <h2><span class="magic-letters-4">W</span><span class="magic-letters-4">h</span><span class="magic-letters-4">a</span><span class="magic-letters-4">t</span> <span class="magic-letters-4">W</span><span class="magic-letters-4">o</span><span class="magic-letters-4">u</span><span class="magic-letters-4">l</span><span class="magic-letters-4">d</span> <span class="magic-letters-4">Y</span><span class="magic-letters-4">o</span><span class="magic-letters-4">u</span> <span class="magic-letters-4">L</span><span class="magic-letters-4">i</span><span class="magic-letters-4">k</span><span class="magic-letters-4">e</span> <span class="magic-letters-4">T</span><span class="magic-letters-4">o</span> <span class="magic-letters-4">D</span><span class="magic-letters-4">o</span><span class="magic-letters-4">?</span></h2>
      </div>
      <h2><a href = "fm-approveDenyPendingReimbursements.jsp">- Approve/Deny Pending Reimbursement Requests -</a></h2>
      <h2><a href = "fm-viewAllPendingRequests.jsp">- View All Pending Reimbursement Requests -</a></h2>
      <h2><a href = "fm-viewAllResolvedRequests.jsp">- View All Resolved Requests -</a></h2>
      <h2><a href = "fm-viewAllEmployees.jsp">- View All Employees -</a></h2>
      <h2><a href = "fm-viewRequestsByEmployee.jsp">- View Reimbursement Requests By Employee -</a></h2>
      <form><input type="hidden" name="action" value="logout">
      <h2><a href="index.jsp">- Log Out -</a></h2>
      </form>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>