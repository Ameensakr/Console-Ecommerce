package org.eCommerce.services;

import org.eCommerce.models.Product;
import org.eCommerce.models.Shippable;

import java.util.Map;

public class ShippingService {
    public double calculateShippingFees(Map<Shippable , Integer> shippedItems)
    {
        double cost = 0;
        for (Map.Entry<Shippable, Integer> entry: shippedItems.entrySet())
        {
            // assume 1g with 0.1$
            cost = cost + entry.getKey().getWeight() * 0.1;
        }
        return cost;
    }
}
