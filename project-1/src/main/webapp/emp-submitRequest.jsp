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
  <title>Employee Submit Request</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged">
    <div class = "menu-logged">
      <div class = "nav-block">
        <div class = "nav-holder">
          <nav>
            <a href = "employeeHomepage.jsp">Dashboard</a>
            <a href = "emp-submitRequest.jsp" class="hidden-link">Submit Request</a>
            <a href = "emp-viewPendingRequests.jsp">Pending</a>
            <a href = "emp-viewResolvedRequests.jsp">Resolved</a>
            <a href = "emp-viewOrUpdateUserInfo.jsp">View/Update Info</a>
            <a href = "index.jsp">Log Out</a>
          </nav>
        </div>
      </div>
      <div class = "header-class">
        <h1>Submit a <span class="span-orange">Reimbursement Request</span></h1>
        <div class="submission-form">
          <h2>Please Enter Your Request Information</h2><br>
          <div class="form-holder">
            <form action=<% request.getContextPath(); %>"Servlet" method="POST">
          	<input type="hidden" name="action" value="submit-request">
          	<label for ="reimbursement-type">Reimbursement Type: </label>
              <select name="reimbursement-type" id="reimbursement-type" required>
                <option value="LODGING">Lodging</option>
                <option value="TRAVEL">Travel</option>
                <option value="FOOD">Food</option>
                <option value="OTHER">Other</option>
              </select><br><br><br>
              <label for ="reimbursement-amount">Reimbursement Amount: </label>
              $<input type ="number" step=".01" id="reimbursement-amount" name="reimbursement-amount" value="reimbursement-amount" required><br><br><br>
             
              <label for="reimbursement-description">Enter a Description (250 char max)
              </label><br><br>
              <textarea id="reimbursement-description" name="reimbursement-description" maxlength="250" class="text-area-class"> 
              </textarea><br><br>
              <input type ="submit" value="Submit Request">


            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src ="./scripts.js"></script>
  
</body>
</html>