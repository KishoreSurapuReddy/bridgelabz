package com.bridgelabz.visitorpattern;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public int visit(Book book) {
		int cost = 0;
		if(book.getBookPrice() > 50) {
			cost = book.getBookPrice() - 5;
		}else {
			cost = book.getBookPrice();
		}
		System.out.println("ISBN Number"+book.getIsbnNumber()+"price of book"+cost);
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {
		int cost = fruit.getPricePerKg()*fruit.getWeight();
		System.out.println(fruit.getName()+"cost is :"+cost);
		return cost;
	}

}
