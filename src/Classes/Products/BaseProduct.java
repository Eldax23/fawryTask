package Classes.Products;


import Interfaces.Products.IProduct;

// this is the base product class which we will only inherit from therefore -> abstract
abstract class BaseProduct implements IProduct {
    private String name;
    private double price;
    private int quantity;

    BaseProduct(String name , double price , int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    BaseProduct() {
        this.name = "";
        this.price = -1;
        this.quantity = -1;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }



    @Override
    public String toString() {
        return "Product: [" + getName() + "]\n" +
                "Price: ["+getPrice()+"]\n" +
                "Quantity: [" + getQuantity() + "]";
    }
}
