package com.isi.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.isi.service.DbConnectionService;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String role;
	public ArrayList<User> userList = new ArrayList<User>();
	
	public User() {}
	
	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public boolean isUserValid(String username, String password)
	{
		boolean isAvailable = false;
		DbConnectionService db = new DbConnectionService();
		Connection connect = db.checkConnection();
		
		String sqlQueryGetAllUsers = "select * from users";
		
	
		
		Statement statement;
		try {
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQueryGetAllUsers);
			
			while(resultSet.next())
			{
				User user = new User(resultSet.getInt("user_id"),
									 resultSet.getString("username"),
									resultSet.getString("password"),
									resultSet.getString("role")
				);
				
				userList.add(user);
			}
			String inputName = username;
			String inputPassword = password;
			
			for(User user : userList)
			{
				
				String name = user.getUsername();
				String pass = user.getPassword();
				if(name.equals(inputName))
				{
					if(pass.equals(inputPassword))
						isAvailable = true;
						break;
				}
				else
					isAvailable = false;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isAvailable;
		
	}
}
