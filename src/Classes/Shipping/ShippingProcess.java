package Classes.Shipping;

import Classes.Cart.CartItem;
import Classes.Products.ShippableProduct;
import Interfaces.Shipping.IShippingProcess;

import java.util.ArrayList;

public class ShippingProcess implements IShippingProcess {

    //FORMULA:  Shipping Fee = Base Rate + (Weight × Rate Per Kg)

    public double calcShippingFees(ArrayList<CartItem> shippableItems) {
        final double BASE_RATE = 5.0; // $
        final double RATE_PER_KG = 2.0; // kg

        double totWeight = 0;

        for(CartItem item : shippableItems) {
            ShippableProduct prd = (ShippableProduct) item.getProduct();

            double prdWeight = prd.getWeight();
            double prdQuantity = item.getQuantity();

            totWeight += prdWeight * prdQuantity;

        }




        return BASE_RATE + (totWeight * RATE_PER_KG);
    }
}
