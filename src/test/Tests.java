package test;

import Classes.Cart.ShoppingCart;
import Classes.Customer;
import Classes.FactoryPattern.ProductFactory;
import Classes.FactoryPattern.ProductType;
import Interfaces.Products.IProduct;
import Services.Checkout.CheckoutService;
import Services.Shipping.ShippingService;

import java.time.LocalDate;

public class Tests {
    static ShippingService shippingService = new ShippingService();
    static CheckoutService checkoutService = new CheckoutService(shippingService);
    public static void checkCartIsEmpty() {
        Customer customer = new Customer("Mohamed" , 5000);
        ShoppingCart cart = new ShoppingCart();
        checkoutService.checkout(customer , cart);
    }

    public static void checkIfCustomerHasBalance() {
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
        checkoutService.checkout(customer , cart);
    }
    public static void checkIfProductInStock() {
        Customer customer = new Customer("Mohamed" , 200);
        IProduct cheese = ProductFactory.createProduct(ProductType.Expirable , "Cheese"
                , 30.0 , 1 , LocalDate.now().plusDays((30)) , 0.4);
        IProduct biscuits = ProductFactory.createProduct(ProductType.Expirable , "Biscuits"
                , 36.0 , 20 , LocalDate.now().plusDays((30)) , 0.7);





        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(cheese , 2); // the customer requested 2 , but there is only 1 in stock
        cart.addToCart(biscuits , 1);
        checkoutService.checkout(customer , cart);
    }

    public static void givenSample() {
            Customer customer = new Customer("Mohamed" , 5000);
            IProduct cheese = ProductFactory.createProduct(ProductType.Expirable , "Cheese"
                    , 30.0 , 20 , LocalDate.now().plusDays((30)) , 0.4);
            IProduct biscuits = ProductFactory.createProduct(ProductType.Expirable , "Biscuits"
                    , 36.0 , 20 , LocalDate.now().plusDays((30)) , 0.7);

            IProduct tvPrd = ProductFactory.createProduct(ProductType.Expirable , "TV"
                    , 180.0 , 10 , LocalDate.now().plusDays((250)) , 12.0);



            ShoppingCart cart = new ShoppingCart();
            cart.addToCart(cheese , 2);
            cart.addToCart(biscuits , 1);
            cart.addToCart(tvPrd , 2);
            checkoutService.checkout(customer , cart);
    }
}
