package org.eCommerce.models;

public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    Product() {
        name = "";
        price = 0;
        quantity = 0;
    }

    String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    double getPrice() {
        return price;
    }

    public void reduceQuantity(int value)
    {
        try {
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
