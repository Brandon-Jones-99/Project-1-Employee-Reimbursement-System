package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoDB;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoDB;
import com.revature.services.ReimbursementService;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// current user and reimbursement objects;
	User currentUser = null;
	Reimbursement currentReimbursement = null;

	
	
	// GET methods
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		
		case "view-pending-requests": {
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			List<Reimbursement> finalReimbursementList = new ArrayList<Reimbursement>();
			List<Reimbursement> reimbursementList = reimbursementDao
					.getUserReimbursementsByStatus(currentUser.getUserId());
			{

				for (Reimbursement r2 : reimbursementList) {
					if (r2.getReimbursementStatus() == Reimbursement.ReimbursementStatus.SUBMITTED) {
						finalReimbursementList.add(r2);
					}
				}
				request.setAttribute("pendingList", finalReimbursementList);
				request.getRequestDispatcher("emp-viewPendingRequestsB.jsp").forward(request, response);
			}

		}
			break;
		
		case "view-resolved-requests": {
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();

			List<Reimbursement> finalReimbursementList = new ArrayList<Reimbursement>();
			List<Reimbursement> reimbursementList = reimbursementDao
					.getUserReimbursementsByStatus(currentUser.getUserId());

			{
				for (Reimbursement r : reimbursementList) {
					if (r.getReimbursementStatus() != Reimbursement.ReimbursementStatus.SUBMITTED) {
						finalReimbursementList.add(r);
					}
				}
				request.setAttribute("resolvedList", finalReimbursementList);
				request.getRequestDispatcher("emp-viewResolvedRequestsB.jsp").forward(request, response);
			}
		}

			break;
		
		
		case "view-requests-by-employee": {
			int employee_id_no = Integer.parseInt(request.getParameter("view-requests-by-employee-id-no"));
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			
				List<Reimbursement> reimbursementlist = reimbursementDao.getReimbursementsById(employee_id_no);

				request.setAttribute("by-Employee", reimbursementlist);
				request.getRequestDispatcher("fm-viewRequestsByEmployeeB.jsp").forward(request, response);
		}
			break;
		
		
		case "see-request": {
			int reimbursement_id_no = Integer.parseInt(request.getParameter("approval-request-reimbursement-id"));
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			currentReimbursement = reimbursementDao.getReimbursement(reimbursement_id_no);

			request.getSession().setAttribute("reimbursement", currentReimbursement);
			request.getRequestDispatcher("fm-approveOrDeny.jsp").forward(request, response);

		}
			break;
		
			
		
		case "view-all-employees": {
			UserDao userDao = new UserDaoDB();
			List<User> userlist = userDao.getAllUsers();

			request.setAttribute("employee-list", userlist);
			request.getRequestDispatcher("fm-viewAllEmployeesB.jsp").forward(request, response);
		}
			break;
			
			
		
		case "view-all-pending": {
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			List<Reimbursement> reimbursementlist = reimbursementDao.getReimbursementsByStatus(1);

			request.setAttribute("allPendingList", reimbursementlist);
			request.getRequestDispatcher("fm-viewAllPendingRequestsB.jsp").forward(request, response);
		}
			break;
		
		
		
		case "view-all-resolved": {
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			List<Reimbursement> reimbursementlist1 = reimbursementDao.getReimbursementsByStatus(2);
			List<Reimbursement> reimbursementlist2 = reimbursementDao.getReimbursementsByStatus(3);

			request.setAttribute("allResolvedList1", reimbursementlist1);
			request.setAttribute("allResolvedList2", reimbursementlist2);
			request.getRequestDispatcher("fm-viewAllResolvedRequestsB.jsp").forward(request, response);
		}
			break;
		
			
		default:
			break;
		}
	}
	
	
	
	
	
	//POST METHODS
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		switch(action) {
		
		
		case "login": {
			UserDao userDao = new UserDaoDB();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			currentUser = userDao.getUser(username, password);

			request.getSession().setAttribute("user", currentUser);

			if (currentUser.getUserType().equals(User.UserType.EMPLOYEE)) {
				request.getRequestDispatcher("/employeeHomepage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("financeManagerHomepage.jsp").forward(request, response);
			}

		}
			break;
		
		
		
		case "logout": {
			currentUser = null;
			request.setAttribute("user", null);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
			break;
		
		
		
		case "update-user-info": {
			UserDao userDao = new UserDaoDB();
			String updated_username = request.getParameter("update-username");
			String updated_password = request.getParameter("update-password");
			String updated_email = request.getParameter("update-email");

			if (!updated_username.equals("")) {
				currentUser.setUsername(updated_username);
			}

			if (!updated_password.equals("")) {
				currentUser.setPassword(updated_password);
			}

			if (!updated_email.equals("")) {
				currentUser.setEmail(updated_email);
			}

			userDao.updateUser(currentUser);
			request.getRequestDispatcher("emp-viewOrUpdateUserInfo.jsp").forward(request, response);

		}
			break;
			
			
		
		case "submit-request": {
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			Reimbursement r = new Reimbursement();

			double new_reimbursement_amount = Double.parseDouble(request.getParameter("reimbursement-amount"));
			r.setReimbursementAmount(new_reimbursement_amount);

			String new_reimbursement_type = request.getParameter("reimbursement-type");
			if (new_reimbursement_type.equals("LODGING")) {
				r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
			} else if (new_reimbursement_type.equals("TRAVEL")) {
				r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
			} else if (new_reimbursement_type.equals("FOOD")) {
				r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
			} else {
				r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
			}

			String new_reimbursement_description = request.getParameter("reimbursement-description");

			r.setReimbursementDescription(new_reimbursement_description);
			r.setTimeReimbursementSubmitted(LocalDateTime.now());
			r.setReimbursementAuthorId(currentUser.getUserId());
			r.setReimbursementStatus(Reimbursement.ReimbursementStatus.SUBMITTED);

			reimbursementDao.addReimbursement(r);
			reimbursementDao.updateReimbursementFirst(r);
			request.getRequestDispatcher("emp-submissionSuccess.jsp").forward(request, response);

		}
			break;
		
		
		
		case "approve": {
			UserDao userDao = new UserDaoDB();
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			ReimbursementService reimbursementService = new ReimbursementService(userDao, reimbursementDao);
			reimbursementService.approve(currentReimbursement, currentUser);

			currentReimbursement.setReimbursementResolverId(currentUser.getUserId());
			currentReimbursement.setTimeReimbursementResolved(LocalDateTime.now());
			currentReimbursement.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);

			reimbursementDao.updateReimbursementSecond(currentReimbursement);

			request.getRequestDispatcher("fm-approvalSuccessful.jsp").forward(request, response);

		}
			break;
		
		
		
		case "deny": {

			UserDao userDao = new UserDaoDB();
			ReimbursementDao reimbursementDao = new ReimbursementDaoDB();
			ReimbursementService reimbursementService = new ReimbursementService(userDao, reimbursementDao);
			reimbursementService.deny(currentReimbursement, currentUser);

			currentReimbursement.setReimbursementResolverId(currentUser.getUserId());
			currentReimbursement.setTimeReimbursementResolved(LocalDateTime.now());
			currentReimbursement.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);

			reimbursementDao.updateReimbursementSecond(currentReimbursement);

			request.getRequestDispatcher("fm-denialSuccessful.jsp").forward(request, response);

		}
			break;

			
		default:
			break;
		}

	}
}

//SOME HELPFUL JSP STUFF
		///////////////////request.getAttribute();
		////////int i = Interger.parseInt(req.getParameter("insert-name")

