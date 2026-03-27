package bankmanagementsystem;

public class BankApplication {

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[4];

        accounts[0] = new SavingsAccount(101, "Rahul", 10000, 4);
        accounts[1] = new CurrentAccount(201, "Amit", 5000, 5000);
        accounts[2] = new SavingsAccount(102, "Neha", 8000, 3);
        accounts[3] = new CurrentAccount(202, "Rohit", 6000, 4000);

        for (BankAccount acc : accounts) {

            System.out.println("\n----------------------------");

            acc.displayAccountDetails();
            acc.deposit(1000);
            acc.withdraw(2000);
            acc.calculateInterest();

        }

    }

}