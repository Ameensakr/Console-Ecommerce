package org.eCommerce.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private double balance;

    public ShoppingCart cart;

    public Customer(String name , double balance)
    {
        this.name = name;
        this.balance = balance;
        cart = new ShoppingCart();
    }

    public double getBalance()
    {
        return balance;
    }

    public void reduceBalance(int amount)
    {
        try{
            if(amount > balance) throw new Exception("you do not have enough balance. ");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public String getName()
    {
        return name;
    }


    public boolean checkOut()
    {
        if(cart.cartItems.isEmpty())
        {
            System.out.println("The cart is empty. ");
            return false;
        }
        Map<Shippable , Integer> shippedItems = new HashMap<>();
        for(Map.Entry<Product, Integer> entry: cart.cartItems.entrySet())
        {

            if(entry.getKey().quantity < entry.getValue())
            {
                System.out.println("This product " + entry.getKey().getName() + " has no enough quantity. ");
                return false;
            }
            if(entry.getKey() instanceof Expirable)
            {
                if(((Expirable) entry.getKey()).isExpired())
                {
                    System.out.println("This product " + entry.getKey().getName() + " has expired. ");
                    return false;
                }
            }

            if(entry.getKey() instanceof Shippable)
            {
                shippedItems.put((Shippable) entry.getKey() , entry.getValue());
            }
        }

        double shippingFees = cart.shippingService.calculateShippingFees(shippedItems);
        double subtotal = cart.calculateSubtotal();
        double amount = shippingFees + subtotal;

        if(amount > balance)
        {
            System.out.println("your balance is insufficient. ");
            return false;
        }

        balance -= amount;
        if(!shippedItems.isEmpty()) {
            System.out.println("- * Shipment notice **");
            double totalWeight = 0;
            for (Map.Entry<Shippable, Integer> entry : shippedItems.entrySet()) {
                totalWeight += entry.getKey().getWeight();
                System.out.println(entry.getValue() + "x" + entry.getKey().getName() + "           " + entry.getKey().getWeight() + 'g');
            }
            System.out.println("Total package weight " + totalWeight / 1000 + "kg");
        }
        System.out.println("- * Checkout receipt **");

        for (Map.Entry<Product, Integer> entry: cart.cartItems.entrySet())
        {
            System.out.println(entry.getValue() + "x" + entry.getKey().getName() + "           " + entry.getValue() * entry.getKey().getPrice());
        }

        System.out.println("- ---------------------");
        System.out.println("Subtotal           " + subtotal);
        System.out.println("Shipping           " + shippingFees);
        System.out.println("Amount             " + amount);


        System.out.println("Customer current balance:      " + balance);
        
        cart.clearCart();
        return true;
    }


}
