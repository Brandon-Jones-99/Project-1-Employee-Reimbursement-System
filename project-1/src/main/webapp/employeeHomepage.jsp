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
  <title>Employee Homepage</title>
  <link rel="stylesheet" href="./finalStyles.css">
</head>
<body>
  <div class = "main-logged">
    <div class = "menu-logged">
      <div class = "header-class">
      <h1>Hello <span class="span-rose">${user.firstName} ${user.lastName}</span></h1>
    <h1><span class="magic-letters">W</span><span class="magic-letters">e</span><span class="magic-letters">l</span><span class="magic-letters">c</span><span class="magic-letters">o</span><span class="magic-letters">m</span><span class="magic-letters">e</span> <span class="magic-letters">t</span><span class="magic-letters">o</span> <span class="magic-letters">t</span><span class="magic-letters">h</span><span class="magic-letters">e</span> <span class="magic-letters-2">E</span><span class="magic-letters-2">m</span><span class="magic-letters-2">p</span><span class="magic-letters-2">l</span><span class="magic-letters-2">o</span><span class="magic-letters-2">y</span><span class="magic-letters-2">e</span><span class="magic-letters-2">e</span> <span class="magic-letters">D</span><span class="magic-letters">a</span><span class="magic-letters">s</span><span class="magic-letters">h</span><span class="magic-letters">b</span><span class="magic-letters">o</span><span class="magic-letters">a</span><span class="magic-letters">r</span><span class="magic-letters">d</span><span class="magic-letters">!</span></h1>
    <h2><span class="magic-letters">W</span><span class="magic-letters">h</span><span class="magic-letters">a</span><span class="magic-letters">t</span> <span class="magic-letters">W</span><span class="magic-letters">o</span><span class="magic-letters">u</span><span class="magic-letters">l</span><span class="magic-letters">d</span> <span class="magic-letters">Y</span><span class="magic-letters">o</span><span class="magic-letters">u</span> <span class="magic-letters">L</span><span class="magic-letters">i</span><span class="magic-letters">k</span><span class="magic-letters">e</span> <span class="magic-letters">T</span><span class="magic-letters">o</span> <span class="magic-letters">D</span><span class="magic-letters">o</span><span class="magic-letters">?</span></h2>
      </div>
      <h2><a href = "emp-submitRequest.jsp">- Submit a Reimbursement Request -</a></h2>
      <h2><a href = "emp-viewPendingRequests.jsp">- View Pending Requests -</a></h2>
      <h2><a href = "emp-viewResolvedRequests.jsp">- View Resolved Requests -</a></h2>
      <h2><a href = "emp-viewOrUpdateUserInfo.jsp">- View/Update User Information -</a></h2>
      <form><input type="hidden" name="action" value="logout">
      <h2><a href="index.jsp">- Log Out -</a></h2>
      </form>
    </div>
  </div>
</body>
</html>

