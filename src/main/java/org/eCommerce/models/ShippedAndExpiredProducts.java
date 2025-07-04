package org.eCommerce.models;

import java.time.LocalDate;

public class ShippedAndExpiredProducts extends Product implements Shippable , Expirable {
    private LocalDate expiryDate;
    private double weight;

    public ShippedAndExpiredProducts(String name , double price , int quantity , LocalDate expiryDate , double weight)
    {
        super(name , price , quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void reduceQuantity(int value)
    {
        try {
            if(isExpired())
            {
                throw new Exception("product Expire: " + name);
            }
            if(quantity == 0)
            {
                throw new IllegalArgumentException("this product is out of stock. ");
            }
            if (value > quantity) throw new IllegalArgumentException("The only available for this product is: " + quantity);
            quantity -=  value;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
