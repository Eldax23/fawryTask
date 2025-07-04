package Classes.Products;

import Interfaces.Products.IShippableProduct;

public class ShippableProduct extends NormalProduct implements IShippableProduct {
    private int weight;
    public ShippableProduct(String name, double price, int quantity , int weight) {
        super(name, price, quantity);
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }


}
