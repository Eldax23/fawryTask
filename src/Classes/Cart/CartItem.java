package Classes.Cart;

import Interfaces.Products.IProduct;

public class CartItem {
    // here we can just use the same instance without creating a new one by implementing
    // Dependency Injection.
    private IProduct product;
    private int quantity; // this denotes the required amount , not the available stock.

    public CartItem(IProduct prd , int qnt) {
        this.product = prd;
        this.quantity = qnt;
    }


    // we are gonna need this when calculating cart price.
    public IProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
