import test.Tests;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {




        try {
//            Tests.checkCartIsEmpty();
//            Tests.checkIfCustomerHasBalance();
//            Tests.checkIfProductInStock();
            Tests.givenSample();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}