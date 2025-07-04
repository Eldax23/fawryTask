package Classes.Cart;

import Classes.Products.ExpirableProduct;
import Classes.Products.ShippableProduct;
import Interfaces.Cart.IShoppingCart;
import Interfaces.Products.IProduct;

import java.util.ArrayList;

public class ShoppingCart implements IShoppingCart {

    private ArrayList<CartItem> cart = new ArrayList<CartItem>();

    @Override
    public void addToCart(IProduct prd, int quantity) {
        //check if the product is in stock:
        if(prd.getQuantity() < 0) throw new NullPointerException("this product isn't currently available.");

        //check if there is enough stock for the required quantity.
        if(prd.getQuantity() < quantity) throw new IllegalArgumentException("requested amount exceeds our current stock.");

        if(prd instanceof ExpirableProduct && ((ExpirableProduct) prd).isExpired())
            throw new IllegalArgumentException("this product's expiry date is due.");

        cart.add(new CartItem(prd , quantity));
    }


    @Override
    public double calcPrice() {
        double sum = 0;
        for(int i = 0; i < cart.size(); i++) {
            //extract the product from the cart:
            IProduct prd = cart.get(i).getProduct();

            //add product (price * quantity) to sum:
            sum += prd.getPrice() * cart.get(i).getQuantity();
        }
        return sum;
    }


    @Override
    public ArrayList<CartItem> getCartItems() {
        return new ArrayList<CartItem>(cart);
    }

    @Override
    public ArrayList<CartItem> getShippableProducts() {
        ArrayList<CartItem> res = new ArrayList<CartItem>();

        for(CartItem item : cart) {
            if(item.getProduct() instanceof ShippableProduct) {
                res.add(item);
            }
        }

        return res;
    }
}
