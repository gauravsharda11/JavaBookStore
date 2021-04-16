package com.isi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionService {
		private String urlConnection ="jdbc:mysql://localhost:3306/BookStore";
		private String login = "root";
		private String password = "root";
		
		
		public Connection checkConnection() {
			Connection connection = null;
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				connection = DriverManager.getConnection(urlConnection, login, password);
				System.out.println("Connection success");
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection failed");
			}
			return connection;
		}
	}
