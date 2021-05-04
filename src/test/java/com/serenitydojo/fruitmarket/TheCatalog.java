package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TheCatalog {

    Catalog catalog;

    @Before
    public void createANewCatalog() {
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
    }


    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() throws FruitUnavailableException {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Apple).to(4.00);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
    }

    @Test
    public void shouldSortTheNamesOfAvailableFruitInAlphabeticalOrder(){

        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50);
        assertThat(catalog.getAvailableFruit()).containsExactly("Apple", "Banana", "Orange");

    }
    @Test
    public void shouldReportCorrectPriceOfAnyTypeOfFruit() throws FruitUnavailableException {
        Catalog catalog = new Catalog();

        catalog.setPriceOf(Banana).to(2.70);
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(2.70);
    }



    @Test (expected = FruitUnavailableException.class)
    public void shouldThrowExceptionIfFruitDoesNotExist() throws FruitUnavailableException {
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
        assertThat(catalog.getPriceOf(Mulberries)).isEqualTo(2.00);

    }


}
