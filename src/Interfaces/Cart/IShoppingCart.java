package Interfaces.Cart;

import Classes.Cart.CartItem;
import Interfaces.Products.IProduct;

import java.util.ArrayList;

public interface IShoppingCart {
    void addToCart(IProduct prd , int quantity);
    double calcPrice();
    ArrayList<CartItem> getCartItems();
}
