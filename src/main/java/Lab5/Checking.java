package Lab5;

public class Checking extends Account {

    public Checking(double amount) {
        super(amount);
    }

    @Override
    public double withdraw(double amount) {
        double newBal = getAccountBalance() - amount;
        if (newBal < 0.0) {
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            super.withdraw(20.0);
        }

        return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "Checking " + super.toString();
    }
}
