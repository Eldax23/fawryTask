package Services.Shipping;

import Classes.Cart.CartItem;

import java.util.ArrayList;

public interface IShippingService {
    void shipProducts(ArrayList<CartItem> shippableProducts);
    double calcShippingFees(ArrayList<CartItem> shippableProducts);
}
