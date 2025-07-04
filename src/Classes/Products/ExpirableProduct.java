package Classes.Products;
import Interfaces.Products.IExpirableProduct;

import java.time.LocalDate;
import java.util.Date;


// for products which they can expire , but they are still products therefore -> extends BaseProduct
public class ExpirableProduct extends  BaseProduct implements IExpirableProduct {
    private LocalDate expiryDate;

    ExpirableProduct(String name , double price , int quantity , Date expiryDate) {
        super(name , price , quantity);

    }

    public boolean isExpired() {
        int compareDates = LocalDate.now().compareTo(expiryDate);
        return compareDates > 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nExpired: [" + (isExpired() ? "Yes" : "No") + "]";
    }
}
