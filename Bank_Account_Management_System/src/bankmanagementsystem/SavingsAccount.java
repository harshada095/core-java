package bankmanagementsystem;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {

        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;

    }

    // Override Interest Method
    @Override
    public void calculateInterest() {

        double interest = balance * interestRate / 100;
        balance = balance + interest;

        System.out.println("Interest Added: " + interest);
        System.out.println("Balance After Interest: " + balance);
    }

}