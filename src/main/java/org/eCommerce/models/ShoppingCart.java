package org.eCommerce.models;

import org.eCommerce.services.ShippingService;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public Map<Product,Integer> cartItems;
    final ShippingService shippingService;
    public ShoppingCart()
    {
        shippingService = new ShippingService();
        this.cartItems = new HashMap<>();
    }

    public boolean addToCart(Product product , int quantity)
    {
        if(product.quantity < quantity)
        {
            System.out.println("The only available for " + product.name + " is: " + product.quantity);
            return false;
        }
        if(product instanceof Expirable)
        {
            if(((Expirable) product).isExpired())
            {
                System.out.println("Sorry, this product is expired. ");
                return false;
            }
        }

        cartItems.put(product , cartItems.getOrDefault(product , 0) + quantity);
        return true;
    }
    public boolean removeFromCart(Product product , int quantity)
    {
        if(cartItems.getOrDefault(product , 0) < quantity)
        {
            System.out.println("you don't have this quantity of the product in your cart. ");
            return false;
        }

        assert (cartItems.getOrDefault(product , 0) >= quantity);
        cartItems.put(product , cartItems.getOrDefault(product , 0) - quantity);
        if(cartItems.get(product) == 0)cartItems.remove(product);
        return true;
    }
    // this function will clear cart after payment successful
    public void clearCart()
    {
        for(Map.Entry<Product, Integer> entry: cartItems.entrySet())
        {
            entry.getKey().setQuantity( entry.getKey().getQuantity() - entry.getValue());
        }
        cartItems.clear();
    }


    public double calculateSubtotal()
    {
        double cost = 0;
        for(Map.Entry<Product, Integer> entry: cartItems.entrySet())
        {
            cost += entry.getKey().price * entry.getValue();
        }
        return cost;
    }


}
