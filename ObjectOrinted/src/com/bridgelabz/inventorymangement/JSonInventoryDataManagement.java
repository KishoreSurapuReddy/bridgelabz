package com.bridgelabz.inventorymangement;

public class JSonInventoryDataManagement {
	
	String name ;
	double weight ;
	double price ;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double jsonValue) {
		this.weight = jsonValue;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return getName()+" "+getWeight()+" "+getPrice()+"total price of product"+getWeight()*getPrice();
	}

}
