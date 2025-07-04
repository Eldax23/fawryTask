import Classes.Cart.ShoppingCart;
import Classes.Customer;
import Classes.FactoryPattern.ProductFactory;
import Classes.FactoryPattern.ProductType;
import Classes.Products.ShippableProduct;
import Interfaces.Products.IProduct;
import Services.Checkout.CheckoutService;
import Services.Shipping.ShippingService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Mohamed" , 1000);

                // create products to add:

        IProduct cheese = ProductFactory.createProduct(ProductType.Expirable , "Cheese"
                , 30.0 , 20 , LocalDate.now().plusDays((30)));
        IProduct biscuits = ProductFactory.createProduct(ProductType.Expirable , "Biscuits"
                        , 36.0 , 20 , LocalDate.now().plusDays((30)));

        IProduct tvPrd = ProductFactory.createProduct(ProductType.Expirable , "TV"
                , 180.0 , 10 , LocalDate.now().plusDays((250)));

        ShippableProduct tv = new ShippableProduct(tvPrd , 12);


        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(cheese , 2);
        cart.addToCart(biscuits , 1);
        cart.addToCart(tv , 2);

        ShippingService shippingService = new ShippingService();

        CheckoutService checkoutService = new CheckoutService(shippingService);

        checkoutService.checkout(customer , cart);

    }
}