package Services.Checkout;

import Classes.Cart.CartItem;
import Classes.Cart.ShoppingCart;
import Classes.Customer;

import java.util.ArrayList;

public interface ICheckoutService {
    void checkout(Customer customer , ShoppingCart cart);
}
