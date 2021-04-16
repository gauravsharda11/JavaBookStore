package com.isi.Manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.entity.Book;
import com.isi.entity.User;
import com.isi.service.DbConnectionService;

/**
 * Servlet implementation class BookManager
 */
@WebServlet("/BookManager")
public class BookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<Book> bookList;// = new ArrayList<Book>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = (String) request.getAttribute("category");
		DbConnectionService db = new DbConnectionService();
		Connection connect = db.checkConnection();
		Statement statement;
		String sqlQueryGetAllBooks = null;
		bookList = new ArrayList<Book>();
		
		
		if(category.equals("Comic"))
			 sqlQueryGetAllBooks = "select * from product where category = 'Comic'";
		else if (category.equals("Super Heroes"))
			 sqlQueryGetAllBooks = "select * from product where category = 'Super Heroes'";
		else if (category.equals("Horror"))
			 sqlQueryGetAllBooks = "select * from product where category = 'Horror'";
		else if (category.equals("Biography"))
			 sqlQueryGetAllBooks = "select * from product where category = 'Biography'";
		
		try {
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQueryGetAllBooks);
			
			while (resultSet.next()) {
				Book book = new Book(resultSet.getInt("id"), resultSet.getString("category"),
									resultSet.getFloat("price"),resultSet.getString("description"),
									resultSet.getString("author"),resultSet.getString("name"),
									resultSet.getString("url"));
				bookList.add(book);
			}
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("product.jsp").forward(request, response);
			//bookList.clear();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Book getBookById(int id)
	{
		Book bookAddedToCart = null;
		for(Book book : bookList)
		{
			if(book.getId() == id)
				bookAddedToCart = book;
		}
		return bookAddedToCart;
		
	}
	

}
