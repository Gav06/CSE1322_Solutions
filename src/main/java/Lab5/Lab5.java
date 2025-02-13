package Lab5;

import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Checking checking = new Checking(0.0);
        final Savings savings = new Savings(500.0);
        boolean running = true;
        System.out.println("[Banking System]");

        while (running) {
            System.out.println(
                    """
                            1. Withdraw from Checking
                            2. Withdraw from Savings
                            3. Deposit to Checking
                            4. Deposit to Savings
                            5. Balance of Checking
                            6. Balance of Savings
                            7. Award Interest to Savings
                            8. Quit
                            """
            );

            System.out.print("Select option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the amount to withdraw from checking: ");
                    double checkingWithdraw = scanner.nextDouble();
                    System.out.println("Current checking balance is $" + checking.withdraw(checkingWithdraw));
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw from savings: ");
                    double savingWithdraw = scanner.nextDouble();
                    System.out.println("Current savings balance is $" + savings.withdraw(savingWithdraw));
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit to checking: ");
                    double checkingDeposit = scanner.nextDouble();
                    System.out.println("Current checking balance is $" + checking.deposit(checkingDeposit));
                    break;
                case 4:
                    System.out.print("Enter the amount to deposit to savings: ");
                    double savingsDeposit = scanner.nextDouble();
                    System.out.println("Current savings balance is $" + savings.deposit(savingsDeposit));
                    break;
                case 5:
                    System.out.println("Current checking balance is $" + checking.getAccountBalance());
                    break;
                case 6:
                    System.out.println(savings);
                    break;
                case 7:
                    System.out.println(checking);
                    break;
                case 8:
                    running = false;
                    System.out.println("Shutting off...");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}
