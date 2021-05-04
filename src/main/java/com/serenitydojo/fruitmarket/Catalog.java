package com.serenitydojo.fruitmarket;

import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    private Map<Fruit, Double> pricePerKilo = new HashMap<>();

    public PriceSetter setPriceOf(Fruit fruit) {

        return new PriceSetter(this, fruit);
    }


    public List<String> getAvailableFruit() {
        Set<Fruit> currentAvailableFruit = new HashSet<>(pricePerKilo.keySet());
        List<String> listOfAvailableFruit = new ArrayList<>();

        for(Fruit fruit : currentAvailableFruit)
        {
            listOfAvailableFruit.add(fruit.name());
        }

        List<String> sortedList = listOfAvailableFruit.stream()
                .sorted()
                .collect(Collectors.toList());

        return sortedList;

    }

    public Double getPriceOf(Fruit fruit) throws FruitUnavailableException {
        if (pricePerKilo.containsKey(fruit)) {
            return pricePerKilo.get(fruit);

        }else {
            throw new FruitUnavailableException(fruit.name() + " currently unavailable");
        }
    }

    public static class PriceSetter {

        private final Catalog catalog;
        private final Fruit fruit ;

        public PriceSetter(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }

        public Catalog to (Double price) {
            catalog.pricePerKilo.put(fruit, price);
            return catalog;
        }

    }
}
