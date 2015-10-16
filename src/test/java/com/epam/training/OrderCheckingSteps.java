package com.epam.training;


import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import static com.epam.training.ProductCategory.*;
import static org.junit.Assert.assertTrue;


public class OrderCheckingSteps extends Steps {
    private OrderService orderService;

    @When("payment is for a physical product")
    public void whenOrderWithPhysicalProduct() {
        orderService = new DefaultOrderService();
        orderService.addProduct(new Product(PHYSICAL, "Some product 1"));
        orderService.addProduct(new Product(OTHER, "Some product 2"));
        orderService.addProduct(new Product(MEMBERSHIP, "Some product 4"));
        orderService.addProduct(new Product(PHYSICAL, "Some product 3"));
        orderService.addProduct(new Product(PHYSICAL, "Some product 5"));
    }

    @Then("generate a packing slip for shipping")
    public void thenPackingSleepShouldExist() {
        assertTrue(orderService.getCategories().contains(PACKING_SLIP));
    }

    @When("payment is for a book")
    public void whenOrderWithBook() {
        orderService = new DefaultOrderService();
        orderService.addProduct(new Product(PHYSICAL, "Some product 1"));
        orderService.addProduct(new Product(OTHER, "Some product 2"));
        orderService.addProduct(new Product(MEMBERSHIP, "Some product 4"));
        orderService.addProduct(new Product(BOOK, "Some product 3"));
        orderService.addProduct(new Product(PHYSICAL, "Some product 5"));
    }

    @Then("duplicate packing slip for the royalty department")
    public void thenPackingSleepShouldDuplicated() {
        assertTrue(orderService.getCategories().contains(PACKING_SLIP));
    }
}
