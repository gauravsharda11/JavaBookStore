package com.isi.Manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.entity.User;
import com.isi.service.DbConnectionService;

/**
 * Servlet implementation class NewUserManager
 */
@WebServlet("/NewUserManager")
public class NewUserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUserManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		String email = (String) request.getAttribute("email");
		ArrayList<User> userList = new ArrayList<User>();
		boolean isUnique = false;
		DbConnectionService db = new DbConnectionService();
		Connection connect = db.checkConnection();
		String sqlQueryGetAllUsers = "select * from users";
		Statement statement;
		try {
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQueryGetAllUsers);

			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("role"));

				userList.add(user);
			}
			String inputName = username;
			
				for (User user : userList) {
					String name = user.getUsername();
					if (name.equals(inputName)) {
						isUnique = false;
						break;
					} else
						isUnique = true;
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isUnique)
		{
			String sqlQueryToAddUser = "INSERT into users (username,password,role,email) values(?,?,?,?)";
			try {
				PreparedStatement preparedStmt = connect.prepareStatement(sqlQueryToAddUser);
				preparedStmt.setString (1, username);
			    preparedStmt.setString (2, password);
			    preparedStmt.setString (3, "user");
			    preparedStmt.setString(4, email);
			    
			    preparedStmt.execute();
			    request.setAttribute("message", "User creation Success. Please login to continue");
			    request.getRequestDispatcher("register.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("message", "Username Already exsist.");
		    request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
