package org.eCommerce.models;

public class ShippableProduct extends Product implements Shippable{

    private double weight;

    public ShippableProduct(String name , double price , int quantity , double weight)
    {
        super(name , price , quantity);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }


}
