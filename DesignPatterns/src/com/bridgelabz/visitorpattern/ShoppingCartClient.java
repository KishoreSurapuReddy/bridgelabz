package com.bridgelabz.visitorpattern;

public class ShoppingCartClient {

	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[]{new Book(20 , "1234"),new Book(45 , "1235"),new Fruit("banana", 40, 2),new Fruit("apple", 60, 5)};
		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);

	}

	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum=0;
		for(ItemElement item : items){
			sum = sum + item.accept(visitor);
		}
		return sum;
	}

}
