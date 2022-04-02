package com.revature.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reimbursement implements Serializable {
	
	private static final long serialVersionUID = -662794077232408093L;


	public static enum ReimbursementType {
		LODGING, TRAVEL, FOOD, OTHER
	}
	
	public static enum ReimbursementStatus {
		SUBMITTED, APPROVED, DENIED
	}
	private Integer reimbursementId;
	private Double reimbursementAmount;
	private LocalDateTime timeReimbursementSubmitted;
	private LocalDateTime timeReimbursementResolved;
	private String reimbursementDescription;
	private Integer reimbursementAuthorId;
	private Integer reimbursementResolverId;
	private ReimbursementType reimbursementType;
	private ReimbursementStatus reimbursementStatus;
	//private Image 
	// implement image uploading at a later date
	
	
	//constructors
	public Reimbursement(Integer reimbursementId, Double reimbursementAmount, LocalDateTime timeReimbursementSubmitted,
			LocalDateTime timeReimbursementResolved, String reimbursementDescription, 
			Integer reimbursementAuthorId, Integer reimbursementResolverId,
			ReimbursementType reimbursementType, ReimbursementStatus reimbursementStatus) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.timeReimbursementSubmitted = timeReimbursementSubmitted;
		this.timeReimbursementResolved = timeReimbursementResolved;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementAuthorId = reimbursementAuthorId;
		this.reimbursementResolverId = reimbursementResolverId;
		this.reimbursementType = reimbursementType;
		this.reimbursementStatus = reimbursementStatus;	
		
		
	}

	public Integer getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(Integer reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	//noargs constructor
	public Reimbursement() {
		super();
	}


	public Double getReimbursementAmount() {
		return reimbursementAmount;
	}


	public void setReimbursementAmount(Double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}


	public LocalDateTime getTimeReimbursementSubmitted() {
		return timeReimbursementSubmitted;
	}


	public void setTimeReimbursementSubmitted(LocalDateTime timeReimbursementSubmitted) {
		this.timeReimbursementSubmitted = timeReimbursementSubmitted;
	}


	public LocalDateTime getTimeReimbursementResolved() {
		return timeReimbursementResolved;
	}


	public void setTimeReimbursementResolved(LocalDateTime timeReimbursementResolved) {
		this.timeReimbursementResolved = timeReimbursementResolved;
	}


	public String getReimbursementDescription() {
		return reimbursementDescription;
	}


	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}


	public ReimbursementType getReimbursementType() {
		return reimbursementType;
	}


	public void setReimbursementType(ReimbursementType reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public ReimbursementStatus getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public Integer getReimbursementAuthorId() {
		return reimbursementAuthorId;
	}

	public void setReimbursementAuthorId(Integer reimbursementAuthorId) {
		this.reimbursementAuthorId = reimbursementAuthorId;
	}

	public Integer getReimbursementResolverId() {
		return reimbursementResolverId;
	}

	public void setReimbursementResolverId(Integer reimbursementResolverId) {
		this.reimbursementResolverId = reimbursementResolverId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", timeReimbursementSubmitted=" + timeReimbursementSubmitted + ", timeReimbursementResolved="
				+ timeReimbursementResolved + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbursementAuthorId=" + reimbursementAuthorId + ", reimbursementResolverId="
				+ reimbursementResolverId + ", reimbursementType=" + reimbursementType + ", reimbursementStatus="
				+ reimbursementStatus + "]";
	}

	




	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
