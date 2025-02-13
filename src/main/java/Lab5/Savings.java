package Lab5;

public class Savings extends Account {

    private int numberOfDeposits = 0;

    public Savings(double initialAmount) {
        super(initialAmount);
    }

    @Override
    public double withdraw(double amount) {
        double newBal = super.withdraw(amount);
        if (newBal < 500.0) {
            System.out.println("Charging a fee of $10 because you are below $500");
            super.withdraw(10.0);
        }

        return getAccountBalance();
    }

    @Override
    public double deposit(double amount) {
        super.deposit(amount);
        numberOfDeposits++;
        System.out.println("This deposit is " + numberOfDeposits + " to this account");
        if (numberOfDeposits > 5) {
            System.out.println("Charging a fee of $10 dollars");
            super.withdraw(10.0);
        }

        return getAccountBalance();
    }

    public double addInterest() {
        // 1.5% of our balance
        double interestAmount = getAccountBalance() * 0.015;
        System.out.println("Customer has earned $" + interestAmount + " in interest");
        return super.deposit(interestAmount);
    }

    @Override
    public String toString() {
        return "Savings " + super.toString();
    }
}
