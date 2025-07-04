package Classes.FactoryPattern;


import Classes.Products.BaseProduct;
import Classes.Products.ExpirableProduct;
import Classes.Products.NormalProduct;
import Classes.Products.ShippableProduct;
import Interfaces.Products.IProduct;

import java.time.LocalDate;


// APLLYING FACTORY DESIGN PATTERN
public class ProductFactory {
    public static IProduct createProduct(ProductType type , String name , double price ,
                                         int quantity , LocalDate expiryDate , Double weight) {
        IProduct res;
        switch(type) {
            case ProductType.Expirable -> {
                res = new ExpirableProduct(name , price , quantity , expiryDate);
                break;
            }
            case ProductType.NonExpirable -> {
                res = new NormalProduct(name , price , quantity);
                break;
            }
            default -> throw new NullPointerException("Invalid Product Type");

        }

        if(weight != null) {
            res = new ShippableProduct(res , weight);
        }

        return res;
    }
}
