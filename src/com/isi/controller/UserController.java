package com.isi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.entity.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Login
		if (request.getParameter("login_submit") != null) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession sessionObj = request.getSession(true);
			boolean isAuthenticated = new User().isUserValid(name, password);
			if (isAuthenticated) {
				//sessionObj.setAttribute("username", name);
				request.getRequestDispatcher("Category.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Username and Pasword doesnt exist");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		}
		//register
		if (request.getParameter("signup_submit") != null) {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			request.setAttribute("username", name);
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			request.getRequestDispatcher("NewUserManager").forward(request, response);
		}
	}

}
