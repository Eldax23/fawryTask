package Classes.Products;

import Interfaces.Products.IProduct;
import Interfaces.Products.IShippableProduct;

public class ShippableProduct implements IProduct , IShippableProduct {
    private IProduct product;
    private double weight;
    public ShippableProduct(IProduct product , double weight) {
        this.product = product;
        this.weight = weight;
    }



    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public int getQuantity() {
        return product.getQuantity();
    }

    @Override
    public void buyProduct(int quantity) {
        product.buyProduct(quantity);
    }
}
