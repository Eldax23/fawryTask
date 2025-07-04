package test;

import Classes.Cart.ShoppingCart;
import Classes.Customer;
import Classes.FactoryPattern.ProductFactory;
import Classes.FactoryPattern.ProductType;
import Interfaces.Products.IProduct;
import Services.Checkout.CheckoutService;
import Services.Shipping.ShippingService;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class GeneralTests {

    static ShippingService shippingService = new ShippingService();
    static CheckoutService checkoutService = new CheckoutService(shippingService);
    @Test
    public void checkEmptyCart() {
        try {
            Customer customer = new Customer("Mohamed" , 5000);
            ShoppingCart cart = new ShoppingCart();
            checkoutService.checkout(customer , cart);
        } catch (Exception e) {
            assertEquals(e.toString() , "java.lang.IllegalArgumentException: there is no products in cart");
        }

    };

    @Test
    public void customerInsufficientBalance(){
        try {
            Customer customer = new Customer("Mohamed" , 10);
            IProduct cheese = ProductFactory.createProduct(ProductType.Expirable , "Cheese"
                    , 30.0 , 20 , LocalDate.now().plusDays((30)) , 0.4);
            IProduct biscuits = ProductFactory.createProduct(ProductType.Expirable , "Biscuits"
                    , 36.0 , 20 , LocalDate.now().plusDays((30)) , 0.7);

            IProduct tvPrd = ProductFactory.createProduct(ProductType.Expirable , "TV"
                    , 180.0 , 10 , LocalDate.now().plusDays((250)) , 12.0);



            ShoppingCart cart = new ShoppingCart();
            cart.addToCart(cheese , 2);
            cart.addToCart(biscuits , 1);
        } catch (Exception e) {
            assertEquals(e.toString() , "java.lang.IllegalArgumentException: there is no products in cart");
        };

    };

}
