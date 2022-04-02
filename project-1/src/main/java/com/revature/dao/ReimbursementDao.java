package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimbursementDao {

	
	public Reimbursement addReimbursement(Reimbursement r);
	
	public Reimbursement getReimbursement(Integer in);
	
	public List<Reimbursement> getUserReimbursementsByStatus(Integer author);
	
	public List<Reimbursement> getReimbursementsByStatus(Integer integer);
	
	
	public List<Reimbursement> getAllResolvedRequests(Reimbursement r2);
	
	
	public List<Reimbursement> getAllReimbursements();
	
	
	public List<Reimbursement> getReimbursementsById(Integer userId);
	
	
	public Reimbursement updateReimbursementFirst(Reimbursement r);
	
	public Reimbursement updateReimbursementSecond(Reimbursement r);
	
}
