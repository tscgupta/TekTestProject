package com.tek.model;

import java.util.LinkedList;
import java.util.List;

public class Order {

	private List<OrderLine> orderLines = new LinkedList<OrderLine>();

	public void add(OrderLine orderLine) throws Exception {
		if (orderLine != null) {
			orderLines.add(orderLine);
		} else {
			System.err.println("ERROR - Order is NULL");
		}
		
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}


