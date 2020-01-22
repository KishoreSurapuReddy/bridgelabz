package com.bridgelabz.visitorpattern;

public interface ShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);

}
