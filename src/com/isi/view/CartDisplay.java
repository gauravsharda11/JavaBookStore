package com.isi.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isi.Manager.SessionManager;
import com.isi.entity.Book;

/**
 * Servlet implementation class CartDisplay
 */
@WebServlet("/CartDisplay")
public class CartDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<Book> bookFromSessionList = SessionManager.getBookListFromSession(request);
		if(bookFromSessionList != null && !bookFromSessionList.isEmpty()) {
			out.println("<table>");
			out.println("<tr>\r\n" + 
					"    <th>Article Number</th>\r\n" + 
					"    <th>Title</th>\r\n" + 
					"    <th>Price</th>\r\n" + 
					"  </tr>");
			for(Book book : bookFromSessionList) {
				out.println("<tr>");
				out.println("<td>" + book.getId() +"</td>");
				out.println("<td>" + book.getName() +"</td>");
				out.println("<td>" + book.getPrice() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
