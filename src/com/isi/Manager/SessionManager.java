package com.isi.Manager;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.isi.entity.Book;

public class SessionManager {

	public static void add(HttpServletRequest req, Book bookToAdd) {
		HttpSession session = req.getSession();
		session.setAttribute("" + bookToAdd.getId(), bookToAdd);

	}

	public static ArrayList<Book> getBookListFromSession(HttpServletRequest request) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();

		HttpSession session = request.getSession();

		Enumeration<String> listOfAttributeSession = session.getAttributeNames();

		if (listOfAttributeSession != null) {

			while (listOfAttributeSession.hasMoreElements()) {
				String key = listOfAttributeSession.nextElement();
				Book book = (Book) session.getAttribute(key);
				listToReturn.add(book);
			}
		}
		return null;
	}

}
