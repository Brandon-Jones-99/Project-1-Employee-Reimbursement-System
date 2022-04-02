package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.beans.User.UserType;
import com.revature.util.ConnectionUtil;

public class UserDaoDB implements UserDao {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public UserDaoDB () {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
		
	}
	
	public User getUser(Integer userId) {
		
		String query = "select * from public.user where user_id="+userId.intValue();
		User user = new User();
			
			try	{
			
			stmt=conn.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("user_email"));
				if (rs.getInt("user_role_id") == 7) {
					user.setUserType(UserType.EMPLOYEE);
				} else { user.setUserType(UserType.FINANCEMANAGER);
					
				};
				return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
			
			return null;
		}
	
		public User getUser(String username, String pass) {
			String query = "SELECT * from public.user where username='" + username + "'" + " AND password='" + pass + "'";
			User user = new User();
				try {
				
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				if (rs.next()) {
					
					user.setUserId(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setFirstName(rs.getString("user_first_name"));
					user.setLastName(rs.getString("user_last_name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("user_email"));
					if (rs.getInt("user_role_id") == 7) {
						user.setUserType(UserType.EMPLOYEE);
					} else { 
						user.setUserType(UserType.FINANCEMANAGER);

					};
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;

		}
	
	public User getUser(String firstname, String lastname, Integer userId) {
	
		
		return null;
	}
	
	public List<User> getAllUsers() {
		String query = "select * from public.user";
		List<User> userList = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("user_email"));
				if (rs.getInt("user_role_id") == 7) {
					u.setUserType(UserType.EMPLOYEE);
				} else { 
					u.setUserType(UserType.FINANCEMANAGER);
					
				}
				userList.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userList;
	}
	
	
	
	public User updateUser(User u) {
		String query = "UPDATE public.user SET username=?, password=?, user_email=? WHERE user_id="+u.getUserId();                      
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
		 e.printStackTrace();
		
		}
		return u;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
