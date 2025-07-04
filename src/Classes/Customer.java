package Classes;

public class Customer {
    private String name;
    private double balance;

    public Customer() {

    }

    public Customer(String name , double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void pay(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nBalance: " + this.getBalance() + "\n";
    }
}
