package Classes.Products;

import Interfaces.Shipping.IShippable;

public class ShippableProduct extends NormalProduct implements IShippable {
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
