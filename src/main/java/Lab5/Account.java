package Lab5;

public class Account {

    private static int nextNumber = 10001;
    private double accountBalance;
    private final int accountNumber;

    public Account(double initialAmount) {
        this.accountBalance = initialAmount;
        this.accountNumber = nextNumber;
        nextNumber++;
    }

    public Account() {
        this(0.0);
    }

    public double withdraw(double amount) {
        this.accountBalance -= amount;
        return accountBalance;
    }

    public double deposit(double amount) {
        this.accountBalance += amount;
        return accountBalance;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public double getAccountNumber() {
        return this.accountNumber;
    }

    public String toString() {
        return "Account #" + getAccountNumber() + ", balance $" + getAccountBalance();
    }
}
