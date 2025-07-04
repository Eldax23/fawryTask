package Services.Shipping;

import Classes.Cart.CartItem;
import Classes.Products.ShippableProduct;

import java.util.ArrayList;

public class ShippingService implements IShippingService {
    @Override
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

    @Override
    public double calcShippingFees(ArrayList<CartItem> shippableProducts) {

        if(shippableProducts.isEmpty()) throw new IllegalArgumentException("the cart is empty with nothing to calc");
        final double BASE_RATE = 5.0; // $
        final double RATE_PER_KG = 2.0; // kg

        double totWeight = 0;

        for(CartItem item : shippableProducts) {

            ShippableProduct prd = (ShippableProduct) item.getProduct();

            double prdWeight = prd.getWeight();
            double prdQuantity = item.getQuantity();

            totWeight += prdWeight * prdQuantity;

        }




        return BASE_RATE + (totWeight * RATE_PER_KG);
    }
}
