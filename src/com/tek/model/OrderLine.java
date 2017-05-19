package com.tek.model;

public class OrderLine {

	private int quantity;
	private Item item;
	
	public OrderLine(Item item, int quantity) throws Exception {
		
		if (quantity > 0 && item != null){
			this.item = item;
			this.quantity = quantity;
		}
		
	}

	public int getQuantity() {
		return quantity;
	}

	public Item getItem() {
		return item;
	}


}
