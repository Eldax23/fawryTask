import Classes.Cart.ShoppingCart;
import Classes.Customer;
import Classes.FactoryPattern.ProductFactory;
import Classes.FactoryPattern.ProductType;
import Interfaces.Products.IProduct;
import Services.Checkout.CheckoutService;
import Services.Shipping.ShippingService;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Mohamed" , 100);

                // create products to add:

        IProduct cheese = ProductFactory.createProduct(ProductType.Expirable , "Cheese"
                , 30.0 , 20 , LocalDate.now().plusDays((30)) , 0.4);
        IProduct biscuits = ProductFactory.createProduct(ProductType.Expirable , "Biscuits"
                        , 30.0 , 20 , LocalDate.now().plusDays((30)) , 0.7);


        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(cheese , 2);
        cart.addToCart(biscuits , 1);

        ShippingService shippingService = new ShippingService();

        CheckoutService checkoutService = new CheckoutService(shippingService);

        checkoutService.checkout(customer , cart);

    }
}