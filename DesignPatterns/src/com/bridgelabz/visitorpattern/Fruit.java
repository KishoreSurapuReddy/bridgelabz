package com.bridgelabz.visitorpattern;

public class Fruit implements ItemElement {
	
	private String name;
	private int pricePerKg;
	private int weight;

	public Fruit(String name, int pricePerKg, int weight) {
		this.name = name;
		this.pricePerKg = pricePerKg;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}


	public int getPricePerKg() {
		return pricePerKg;
	}


	public int getWeight() {
		return weight;
	}


	@Override
	public int accept(ShoppingCartVisitor visitor) {
		
		return visitor.visit(this);
	}

}
