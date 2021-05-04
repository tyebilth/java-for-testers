package com.serenitydojo.fruitmarket;

import org.junit.Test;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TheShoppingCart {

    Catalog catalog;

    @Test
    public void checkThatCartIsEmpty(){
        catalog = new Catalog();
        catalog.setPriceOf(Fruit.Apple).to(3.00);
        catalog.setPriceOf(Fruit.Banana).to(4.00);

        ShoppingCart cart = new ShoppingCart(catalog);

        assertThat(cart.getItems().isEmpty());
    }

    @Test
    public void shouldBeAbleToAddItemsToCart(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(3.00);
        catalog.setPriceOf(Banana).to(4.00);


     ShoppingCart cart = new ShoppingCart(catalog);
     cart.addItem(2,Apple);
     cart.addItem(3,Banana);

     assertThat(cart.getItems()).hasSize(2);

    }

    @Test
    public void shouldKeepRunningTotal(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(3.00);
        catalog.setPriceOf(Banana).to(4.00);

        ShoppingCart cart = new ShoppingCart(catalog);
        cart.addItem(2,Apple);
        cart.addItem(3,Banana);
        
       assertThat(cart.getTotalCost()).isEqualTo(18.00);
    }

    @Test
    public void shouldApplyDiscountForQuantityFiveKgs(){

        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(3.00);
        catalog.setPriceOf(Banana).to(4.00);

        ShoppingCart cart = new ShoppingCart(catalog);
        cart.addItem(6,Apple);
        cart.addItem(3,Banana);

        assertThat(cart.getTotalCost()).isEqualTo(28.20);



    }
}
