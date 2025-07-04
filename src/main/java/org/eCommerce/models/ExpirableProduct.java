package org.eCommerce.models;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {


    LocalDate expiryDate;

    public ExpirableProduct(String name , double price , int quantity , LocalDate expiryDate)
    {
        super(name , price , quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
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
