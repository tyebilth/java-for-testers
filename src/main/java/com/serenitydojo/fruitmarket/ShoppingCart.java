package com.serenitydojo.fruitmarket;

import org.assertj.core.api.AbstractBigDecimalAssert;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Catalog {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }


    public void addItem(double quantityPerKilo, Fruit fruit) {
        double totalPrice = 0;
        if (quantityPerKilo >= 5) {
            totalPrice = quantityPerKilo * catalog.getPriceOf(fruit);
            totalPrice = totalPrice * 0.9;
        }
        else{

            totalPrice = quantityPerKilo * catalog.getPriceOf(fruit);

        }
        items.add(new ShoppingCartItem(fruit,quantityPerKilo,totalPrice));
    }

    public double getTotalCost() {
        double sum = 0.0;
        for (ShoppingCartItem item : items) {
            double totalCost = item.getTotalCost();
            sum += totalCost;
        }
        return sum;

        /*return items.stream()
                .mapToDouble(items -> items.getTotalCost())
                .sum();*/
    }
}
