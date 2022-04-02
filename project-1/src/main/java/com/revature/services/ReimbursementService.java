package com.revature.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.revature.beans.Reimbursement;
import com.revature.beans.Reimbursement.ReimbursementStatus;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;

public class ReimbursementService {
	
	UserDao userDao;
	ReimbursementDao reimbursementDao;
	
	public ReimbursementService(UserDao udao, ReimbursementDao rdao) {
		this.userDao = udao;
		this.reimbursementDao = rdao;
	}

	public Reimbursement approve(Reimbursement r, User u)  {
		
		r = reimbursementDao.getReimbursement(r.getReimbursementId());
			if (r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.SUBMITTED)) {
				r.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
				r.setTimeReimbursementResolved(LocalDateTime.now());
				r.setReimbursementResolverId(u.getUserId());
				reimbursementDao.updateReimbursementSecond(r);
			} 
		return r;
		
	}
	
	public Reimbursement deny(Reimbursement r, User u) {
		r = reimbursementDao.getReimbursement(r.getReimbursementId());
		if (r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.SUBMITTED)) {
			r.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
			r.setTimeReimbursementResolved(LocalDateTime.now());
			r.setReimbursementResolverId(u.getUserId());
			reimbursementDao.updateReimbursementSecond(r);
		} 
	return r;
		
	}
	
}
