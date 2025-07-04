package Interfaces.Shipping;

import Classes.Cart.CartItem;

import java.util.ArrayList;

public interface IShippingProcess {
    double calcShippingFees(ArrayList<CartItem> shippableItems);
}
