package Services;

import Classes.Cart.CartItem;
import Classes.Products.ShippableProduct;
import Interfaces.Products.IShippableProduct;

import java.util.ArrayList;

public class ShippingService implements IShippingService {
    public void shipProducts(ArrayList<CartItem> shippableProducts) {
        int n = shippableProducts.size();
        System.out.println("** Shipment notice **");
        double totWeight = 0;
        for(CartItem item : shippableProducts) {
            // this is safe because we are certain that the given products are ShippableProducts
            ShippableProduct prd = (ShippableProduct) item.getProduct();
            System.out.println(item.getQuantity() + "x  " + prd.getName() + "    " + prd.getWeight() * 1000 + "g");

            double weight = prd.getWeight();
            int quantity = prd.getQuantity();
            totWeight += weight * quantity;
        }

        System.out.println("Total package weight " + totWeight + "kg");
    }
}
