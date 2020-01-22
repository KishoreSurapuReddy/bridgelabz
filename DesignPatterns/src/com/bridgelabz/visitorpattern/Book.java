package com.bridgelabz.visitorpattern;

public class Book implements ItemElement {
	
	private int bookPrice;
	private String isbnNumber;
	
	public Book(int bookPrice, String isbnNumber) {
		this.bookPrice = bookPrice;
		this.isbnNumber = isbnNumber;
	}
	
	public int getBookPrice() {
		return bookPrice;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		
		return visitor.visit(this);
	}

}
