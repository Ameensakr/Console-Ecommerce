package org.eCommerce;

import org.eCommerce.models.Customer;
import org.eCommerce.models.Product;
import org.eCommerce.models.ShippedAndExpiredProducts;
import org.eCommerce.models.ShippableProduct;
import org.eCommerce.models.ExpirableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Scenario 1: Successful Checkout ===");
        Customer ameen = new Customer("Ameen", 2000);
        Product laptop = new Product("Laptop", 500, 5);
        Product cheese = new ShippedAndExpiredProducts("Cheese", 10, 2, LocalDate.now().plusDays(5), 100);
        Product tv = new ShippableProduct("TV", 800, 3, 100);
        ameen.cart.addToCart(laptop, 1);
        ameen.cart.addToCart(cheese, 1);
        ameen.cart.addToCart(tv, 1);
        ameen.checkOut();

        System.out.println("\n=== Scenario 2: Insufficient Balance ===");
        Customer reem = new Customer("Reem", 100);
        Product phone = new Product("Phone", 300, 2);
        reem.cart.addToCart(phone, 1);
        reem.checkOut();

        System.out.println("\n=== Scenario 3: Expired Product ===");
        Customer osama = new Customer("Osama", 1000);
        Product expiredMilk = new ExpirableProduct("Milk", 5, 10, LocalDate.now().minusDays(1));
        osama.cart.addToCart(expiredMilk, 1);
        osama.checkOut();
    }
}