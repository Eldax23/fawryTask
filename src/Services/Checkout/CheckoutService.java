package Services.Checkout;

import Classes.Cart.CartItem;
import Classes.Cart.ShoppingCart;
import Classes.Customer;
import Classes.Products.ShippableProduct;
import Interfaces.Products.IProduct;
import Services.Shipping.IShippingService;

import java.util.ArrayList;

public class CheckoutService implements ICheckoutService {
    private IShippingService shippingService;

    public CheckoutService(IShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public void checkout(Customer customer, ShoppingCart cart) {

        if(cart.getCartItems().size() <= 0) throw  new IllegalArgumentException("there is no products in cart");
        ArrayList<CartItem> cartItems = cart.getCartItems();

        double priceOfCart = cart.calcPrice();
        double shippingFee = 0;
        ArrayList<CartItem> shippableProducts = cart.getShippableProducts();
        if(!shippableProducts.isEmpty()) {
            shippingFee = shippingService.calcShippingFees(cart.getShippableProducts());
        }
        double totalPrice = priceOfCart + shippingFee;


        if(customer.getBalance() < totalPrice) {
            throw new IllegalArgumentException("Customer's balance is insufficent");
        }

        // payment done
        customer.pay(totalPrice);


        //shipping...



        if(shippableProducts.size() > 0) shippingService.shipProducts(shippableProducts);

        printReceipt(cart , priceOfCart , shippingFee);


    }

    public void printReceipt(ShoppingCart cart , double subtotal , double shippingFee) {
        System.out.println("** Checkout receipt **");
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        for(CartItem item : cartItems) {
            IProduct prd = item.getProduct();
            System.out.println(item.getQuantity() + "x   " + item.getProduct().getName() + "    " + item.getProduct().getPrice());
        }

        System.out.println("--------------------------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Amount: " + subtotal + shippingFee);
    }

}
