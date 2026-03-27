package bankmanagementsystem;

public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    // Constructor
    public CurrentAccount(int accountNumber, String accountHolderName, double balance, double overdraftLimit) {

        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;

    }

    // Override Withdraw Method
    @Override
    public void withdraw(double amount) {

        if (balance + overdraftLimit >= amount) {

            balance = balance - amount;

            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);

        } else {

            System.out.println("Overdraft limit exceeded. Withdrawal denied.");

        }

    }

}