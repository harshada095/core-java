package bankmanagementsystem;

public class BankAccount {

    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }

    }

    // Display Details
    public void displayAccountDetails() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    // Calculate Interest
    public void calculateInterest() {
        System.out.println("No interest for normal account.");
    }

}