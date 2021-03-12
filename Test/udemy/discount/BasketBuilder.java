package udemy.discount;

import java.util.ArrayList;
import java.util.List;

public class BasketBuilder {
	private List<Item> items;
	
	public BasketBuilder() {
		this.items = new ArrayList<Item>();
	}
	
	public BasketBuilder w(String name, double price){
		Item item = new Item(name, 1, price);
		items.add(item);
		return this;
	}
	
	public Basket build() {
		Basket basket = new Basket(items);
		return basket;
	}
}
