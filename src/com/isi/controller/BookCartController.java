package com.isi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.isi.Manager.BookManager;
import com.isi.Manager.SessionManager;
import com.isi.entity.Book;

/**
 * Servlet implementation class BookCartController
 */
@WebServlet("/BookCartController")
public class BookCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Map<String,Book> cart = new HashMap<String,Book>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		//SessionManager session = (SessionManager) request.getSession();

	//	 Hashtable<String, Book> cart = new Hashtable<String, Book>(); 
	//	 cart = new HashMap<String,Book>();
		 switch(action) {
			 case "add" :
				 Book bookToCart = BookManager.getBookById(id);
				 //session.add(request, bookToCart);
				 //String idString = Integer.toString(id);
				 cart.put(request.getParameter("id"),bookToCart);
				 request.setAttribute("cart", cart);
				 session.setAttribute("cart",cart);
				 request.getRequestDispatcher("success.jsp").forward(request, response);
				 //request.getRequestDispatcher("product.jsp");
				 //return;
				 break;
			 case "cart":
				 request.getRequestDispatcher("success.jsp").forward(request, response);
//				 RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/success.jsp");
//				reqDispatcher.forward(request,response);
				 break;
		}
		 System.out.println(session.getAttribute("cart"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
