package com.learn;

public class Book { // what data we need to show in project
	private int bookId;
	private String title;
	private String author;
	private boolean isIssued;
	
	/// create constructor of this data....
	public Book (int bookId, String title, String author, boolean isIssued) {
		this.bookId = bookId; // apply this method of constructor..
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}
	// getter and setter defines....
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}	
}