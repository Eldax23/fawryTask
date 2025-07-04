package Classes.Products;

import Interfaces.Products.IProduct;


// this denotes a product with no expiry date.
public class NormalProduct extends  BaseProduct implements IProduct {
    public NormalProduct(String name , double price , int quantity) {
        super(name , price , quantity);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
