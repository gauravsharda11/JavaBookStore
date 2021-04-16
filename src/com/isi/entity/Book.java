package com.isi.entity;

import java.util.Collection;

import com.isi.Manager.BookManager;

public class Book {
	
	private int id;
	private String category;
	private float price;
	private String description;
	private String author;
	private String name;
	private String url;
	
	
	public Book() {
	}


	public Book(int id, String category, float price, String description, String author, String name, String url) {
		this.id = id;
		this.category = category;
		this.price = price;
		this.description = description;
		this.author = author;
		this.name = name;
		this.url = url;
	}


	public int getId() {
		return id;
	}


	public String getCategory() {
		return category;
	}


	public float getPrice() {
		return price;
	}


	public String getDescription() {
		return description;
	}


	public String getAuthor() {
		return author;
	}


	public String getName() {
		return name;
	}


	public String getUrl() {
		return url;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Book> getBook (int id)
	{
		Collection<Book> bookList = null;
		bookList = (Collection<Book>) BookManager.getBookById(id);
		return bookList;
		
	}

}
