/*package com.revature;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.*;
import com.revature.beans.Reimbursement.ReimbursementStatus;
import com.revature.beans.Reimbursement.ReimbursementType;
import com.revature.dao.*;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.services.ReimbursementService;

// <<<< N O T E   F R O M   T H E    D E V E L O P E R >>>> //

//THIS DRIVER WAS USED TO TEST DAO METHODS, IT ISN'T USED DURING RUNTIME
//YOU CAN COMMENT OUT THE TOP AND BOTTOM TO RUN TESTS IN THE CONSOLE



  public class Driver {
	
	
	public UserDao userDao = new UserDaoDB();
	public ReimbursementDao rddb = new ReimbursementDaoDB();
	
	public ReimbursementService reimbursementService = new ReimbursementService(userDao, rddb);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		driver.test_time();
		
	}
	
		public void test_time() {
		
		Scanner scanner = new Scanner(System.in);
		
		//LOGIN
//		System.out.println("username");
//		String username = scanner.next();
//		System.out.println("password");
//		String password = scanner.next();
//		try { userDao.getUser(username, password);
//		
//		System.out.println("Login is Successful\n");
//		} catch (InvalidCredentialsException e) {
//			System.out.println("Sorry, your login has failed");
//		}
	
		
		
		
		//VIEW USER INFO (getUser(int id))
//		System.out.println("user id");
//		int x = scanner.nextInt();
//		System.out.println(userDao.getUser(x));
		
		
		
		
		
		//UPDATE USER INFO
//		User u;
//		System.out.println("user id");
//		int x = scanner.nextInt();
//		u = userDao.getUser(x);
//		u.setEmail("yasha392@revature.com");
//		u.setEmail("takepictureseveryday@aol.com");
//		System.out.println(userDao.updateUser(u));
		
		
		
		
		//VIEW ALL USERS (printing out of order?)
//		System.out.print(userDao.getAllUsers());
		
		
		
		
		//ADD REIMBURSEMENT
//		Reimbursement r = new Reimbursement();
		
//		r.setReimbursementAmount(40.11);
//		r.setTimeReimbursementSubmitted(LocalDateTime.now());
//		r.setReimbursementDescription("Mercado Pit Stop (gasoline)");
//		r.setReimbursementAuthorId(3);
//		r.setReimbursementStatus(ReimbursementStatus.SUBMITTED);
//		r.setReimbursementType(ReimbursementType.TRAVEL);
//		System.out.println(rddb.addReimbursement(r));
		

		
		//APPROVE REIMBURSEMENT
//		 Reimbursement re = rddb.getReimbursement(5);
//		 reimbursementService.approve(re);
//		
//	
//		 System.out.println(rddb.getReimbursement(5));
		
		
		 
		 //DENY REIMBURSEMENT
//		 Reimbursement re = rddb.getReimbursement(3);
//		 reimbursementService.deny(re);
//		 
//		 System.out.println(rddb.getReimbursement(3));
		 
		
		 
		 
		
		//GET PENDING REQUESTS (GetReimbursementByStatus)
//		System.out.println("1 = SUBMITTED, 2 = APPROVED, 3 = DENIED");
//		int x = scanner.nextInt();
//		
//		System.out.println(rddb.getReimbursementsByStatus(x));
//		
		
		
		
		//VIEW RESOLVED REQUESTS
//		System.out.println(rddb.getAllResolvedRequests());
		
		
		
		
		//GET ALL REIMBURSEMENTS
//		System.out.print(rddb.getAllReimbursements());
		

		
		
		//GET REIMBURSEMENTS BY ID
		
//		System.out.println(userDao.getAllUsers());
//		System.out.println("Select id from 1");
//		int x = scanner.nextInt();
//		
//		System.out.println(rddb.getReimbursementsById(x));
		
		
		
		
scanner.close();
	}
}

*/
