package com.tek.model;

import java.text.DecimalFormat;
import java.util.Map;

public class Calculator {

	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;
		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			String key = entry.getKey();
			Order value = entry.getValue();
			double totalTax = 0;
			double total = 0;
			// Iterate through the items in the order
			for (int i = 0; i < value.size(); i++) {
				// Calculate the taxes
				double tax = 0;
				if (value.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = rounding(value.get(i).getItem().getPrice() * 0.15); // Extra 5% 0n imported items
				} else {
					tax = rounding(value.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = rounding((value.get(i).getItem().getPrice() * value
						.get(i).getQuantity()) + tax);

				// Print out the item's total price
				System.out.println(value.get(i).getItem().getDescription()
						+ ": " + totalprice);

				// Keep a running total
				totalTax += tax;
				total += value.get(i).getItem().getPrice();

			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;

		}

		System.out.println("Sum of orders: " + rounding(grandtotal));
	}

	public static double rounding(double value) {
		return Double.parseDouble(new DecimalFormat("##.##").format(value));
	}
}
