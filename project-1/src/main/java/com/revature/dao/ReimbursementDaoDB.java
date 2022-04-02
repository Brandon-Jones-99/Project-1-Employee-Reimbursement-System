package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.beans.Reimbursement.ReimbursementStatus;
import com.revature.beans.Reimbursement.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoDB implements ReimbursementDao {

	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public ReimbursementDaoDB() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}
	//NOT IN QUERY - RESOLVED, RESOLVER, 
	public Reimbursement addReimbursement(Reimbursement r) {
		String query = "insert into public.reimbursements (reimbursement_amount, time_submitted, description, author, reimbursement_status_id, reimbursement_type_id) values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, r.getReimbursementAmount());
			pstmt.setTimestamp(2, Timestamp.valueOf(r.getTimeReimbursementSubmitted()));
			pstmt.setString(3, r.getReimbursementDescription());
			pstmt.setInt(4, r.getReimbursementAuthorId());
			pstmt.setInt(5, 1); //ADDREIMBURSEMENT WILL ALWAYS BE A SUBMISSION AT (1)
			if(r.getReimbursementType().equals(Reimbursement.ReimbursementType.LODGING)) {
				pstmt.setInt(6, 111);
			} else if(r.getReimbursementType().equals(Reimbursement.ReimbursementType.TRAVEL)) {
				pstmt.setInt(6, 222);
			} else if(r.getReimbursementType().equals(Reimbursement.ReimbursementType.FOOD)) {
				pstmt.setInt(6, 333);
			} else {
					pstmt.setInt(6, 444);
				    }
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  } 
		
		return r;
	}
	
	public Reimbursement getReimbursement(Integer in) {
		
		String query = "select * from public.reimbursements where reimbursement_id ="+in.intValue();
		Reimbursement reimbursement = new Reimbursement();
		
		try {
			
			stmt=conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
			   	reimbursement.setReimbursementId(rs.getInt("reimbursement_id"));
				 reimbursement.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
				 reimbursement.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
//				 reimbursement.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
				 reimbursement.setReimbursementDescription(rs.getString("description"));
				 reimbursement.setReimbursementAuthorId(rs.getInt("author"));
				 reimbursement.setReimbursementResolverId(rs.getInt("resolver"));
				 if (rs.getInt("reimbursement_status_id") == 1) {
					 reimbursement.setReimbursementStatus(Reimbursement.ReimbursementStatus.SUBMITTED);
				 } else if (rs.getInt("reimbursement_status_id") == 2) {
					 reimbursement.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
				 } else {
					 reimbursement.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
				 };
				 if (rs.getInt("reimbursement_type_id") == 111) {
					 reimbursement.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
				 } else if (rs.getInt("reimbursement_type_id") == 222) {
					 reimbursement.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
				 } else if (rs.getInt("reimbursement_type_id") == 333) {
					 reimbursement.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
				 } else {
						 reimbursement.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
					 }
				 return reimbursement;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Reimbursement> getUserReimbursementsByStatus(Integer author) {
		String query = "select * from public.reimbursements where author=" + author;
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) { 
				Reimbursement r = new Reimbursement();
				r.setReimbursementId(rs.getInt("reimbursement_id"));
				r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
				 r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
				 if (rs.getTimestamp("time_resolved") != null) {
					 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
				 }
				 
//				 if (rs.getTimestamp("time_resolved") == null) {
//					 r.setTimeReimbursementResolved(LocalDateTime.now());
//				 } else {
//					 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
//				 }
				 
					 
					 
//				 reimbursement.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
				 
				 
				 r.setReimbursementDescription(rs.getString("description"));
				 r.setReimbursementAuthorId(rs.getInt("author"));
				 r.setReimbursementResolverId(rs.getInt("resolver"));
				 if (rs.getInt("reimbursement_status_id") == 1) {
					 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.SUBMITTED);
				 } else if (rs.getInt("reimbursement_status_id") == 2) {
					 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
				 } else {
					 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
				 };
				 if (rs.getInt("reimbursement_type_id") == 111) {
					 r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
				 } else if (rs.getInt("reimbursement_type_id") == 222) {
					 r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
				 } else if (rs.getInt("reimbursement_type_id") == 333) {
					 r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
				 } else {
						 r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
					 }
				 
				 reimbursementList.add(r);
			}
			return reimbursementList;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return null;
	}
	
	
	public List<Reimbursement> getReimbursementsByStatus (Integer integer) {
		String query = "select * from public.reimbursements where reimbursement_status_id="+integer;
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				if (rs.getInt("reimbursement_status_id") == 1) {
						r.setReimbursementStatus(Reimbursement.ReimbursementStatus.SUBMITTED);
						r.setReimbursementId(rs.getInt("reimbursement_id"));
						r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
						r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
						if (rs.getTimestamp("time_resolved") == null) {
							r.setTimeReimbursementResolved(null);
						} else {
							r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
						}
//						r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
						r.setReimbursementDescription(rs.getString("description"));
						r.setReimbursementAuthorId(rs.getInt("author"));
						r.setReimbursementResolverId(rs.getInt("resolver"));
						if (rs.getInt("reimbursement_type_id") == 111) {
							r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
						} else if (rs.getInt("reimbursement_type_id") == 222) {
							r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
						} else if (rs.getInt("reimbursement_type_id") == 333) {
							r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
						} else {
							r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
						}
						
						
				} else if (rs.getInt("reimbursement_status_id") == 2) {
					r.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
					r.setReimbursementId(rs.getInt("reimbursement_id"));
					r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
					r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
					if (rs.getTimestamp("time_resolved") != null) {
						 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
					 }
//					r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
					r.setReimbursementDescription(rs.getString("description"));
					r.setReimbursementAuthorId(rs.getInt("author"));
					r.setReimbursementResolverId(rs.getInt("resolver"));
					if (rs.getInt("reimbursement_type_id") == 111) {
						r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
					} else if (rs.getInt("reimbursement_type_id") == 222) {
						r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
					} else if (rs.getInt("reimbursement_type_id") == 333) {
						r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
					} else {
						r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
					}
				} else {
					r.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
					r.setReimbursementId(rs.getInt("reimbursement_id"));
					r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
					r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
					if (rs.getTimestamp("time_resolved") != null) {
						 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
					 }
//					r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
					r.setReimbursementDescription(rs.getString("description"));
					r.setReimbursementAuthorId(rs.getInt("author"));
					r.setReimbursementResolverId(rs.getInt("resolver"));
					if (rs.getInt("reimbursement_type_id") == 111) {
						r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
					} else if (rs.getInt("reimbursement_type_id") == 222) {
						r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
					} else if (rs.getInt("reimbursement_type_id") == 333) {
						r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
					} else {
						r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
					}
				}
	
				reimbursementList.add(r);
				}	 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursementList;
	}
	
	
	public List<Reimbursement> getAllResolvedRequests(Reimbursement r2) {
		String query = "select * from public.reimbursements where reimbursement_status_id="+r2.getReimbursementStatus();
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				if ((rs.getInt("reimbursement_status_id")) == 2) {
					r.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
					} else {
						r.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
					} 
					r.setReimbursementId(rs.getInt("reimbursement_id"));
					r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
					r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
//					r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
					r.setReimbursementDescription(rs.getString("description"));
					r.setReimbursementAuthorId(rs.getInt("author"));
					r.setReimbursementResolverId(rs.getInt("resolver"));
					if (rs.getInt("reimbursement_type_id") == 111) {
						r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
					} else if (rs.getInt("reimbursement_type_id") == 222) {
						r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
					} else if (rs.getInt("reimbursement_type_id") == 333) {
						r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
					} else {
						r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
					}
					
					reimbursementList.add(r);
					}
				
					 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursementList;
	}
	
	
	public List<Reimbursement> getAllReimbursements() {
		String query = "select * from public.reimbursements";
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		
		 while(rs.next()) {
			 Reimbursement r = new Reimbursement();
			 r.setReimbursementId(rs.getInt("reimbursement_id"));
			 r.setReimbursementAmount(rs.getDouble("reimbursement_amount"));
			 r.setTimeReimbursementSubmitted(rs.getTimestamp("time_submitted").toLocalDateTime());
			 if (rs.getTimestamp("time_resolved") != null) {
				 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
			 }
//			 if (rs.getTimestamp("time_resolved") == null) {
//				 r.setTimeReimbursementResolved(LocalDateTime.now());
//			 } else {
//				 r.setTimeReimbursementResolved(rs.getTimestamp("time_resolved").toLocalDateTime());
//			 }
			 r.setReimbursementDescription(rs.getString("description"));
			 r.setReimbursementAuthorId(rs.getInt("author"));
			 r.setReimbursementResolverId(rs.getInt("resolver"));
			 if (rs.getInt("reimbursement_status_id") == 1) {
				 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.SUBMITTED);
			 } else if (rs.getInt("reimbursement_status_id") == 2) {
				 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.APPROVED);
			 } else {
				 r.setReimbursementStatus(Reimbursement.ReimbursementStatus.DENIED);
			 }
			 if (rs.getInt("reimbursement_type_id") == 111) {
					r.setReimbursementType(Reimbursement.ReimbursementType.LODGING);
				} else if (rs.getInt("reimbursement_type_id") == 222) {
					r.setReimbursementType(Reimbursement.ReimbursementType.TRAVEL);
				} else if (rs.getInt("reimbursement_type_id") == 333) {
					r.setReimbursementType(Reimbursement.ReimbursementType.FOOD);
				} else {
					r.setReimbursementType(Reimbursement.ReimbursementType.OTHER);
				}		 reimbursementList.add(r);
			 
		 	}
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		return reimbursementList;
	}
	
	
	public List<Reimbursement> getReimbursementsById(Integer userId) {
		
		List<Reimbursement> reimbursementList = getAllReimbursements();
		List<Reimbursement> usersIWant = new ArrayList<Reimbursement>();
		
			 
			 for(Reimbursement r: reimbursementList ) {
				 if(r.getReimbursementAuthorId().equals(userId)) {
					 usersIWant.add(r);
				 }
			 }
	
		return usersIWant;
	}
	
	
	public Reimbursement updateReimbursementFirst(Reimbursement r) {
		String query = "UPDATE public.reimbursements SET reimbursement_amount=?, time_submitted=?, description=?, author=?, reimbursement_status_id=?, reimbursement_type_id=? WHERE reimbursement_id="+ r.getReimbursementId();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, r.getReimbursementAmount());
			pstmt.setTimestamp(2, Timestamp.valueOf(r.getTimeReimbursementSubmitted()));
			pstmt.setString(3, r.getReimbursementDescription());
			pstmt.setInt(4, r.getReimbursementAuthorId());
			if(r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.SUBMITTED)) {
				pstmt.setInt(5, 1);
			} else if(r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.APPROVED)) {
				pstmt.setInt(5, 2);
			}	else {
					pstmt.setInt(5, 3);
				}
			if (r.getReimbursementType().equals(Reimbursement.ReimbursementType.LODGING)) {
				pstmt.setInt(6, 111);
			} else if(r.getReimbursementType().equals(Reimbursement.ReimbursementType.TRAVEL)) {
				pstmt.setInt(6, 222);
			} else if(r.getReimbursementType().equals(Reimbursement.ReimbursementType.FOOD)) {
				pstmt.setInt(6, 333);
			} else {
					pstmt.setInt(6, 444);
				    }
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  } 

		return r;
		} 						
	
	public Reimbursement updateReimbursementSecond(Reimbursement r) {
		String query = "UPDATE public.reimbursements SET time_resolved=?, resolver=?, reimbursement_status_id=? WHERE reimbursement_id="+ r.getReimbursementId();
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setTimestamp(1, Timestamp.valueOf(r.getTimeReimbursementResolved()));
			
			pstmt.setInt(2, r.getReimbursementResolverId());
			
			if(r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.SUBMITTED)) {
				pstmt.setInt(3, 1);
			} else if(r.getReimbursementStatus().equals(Reimbursement.ReimbursementStatus.APPROVED)) {
				pstmt.setInt(3, 2);
			}	else {
					pstmt.setInt(3, 3);
				}
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  } 

		return r;
		} 
		
	}
	
	
	
	
	
	
	
	
	
	
	

