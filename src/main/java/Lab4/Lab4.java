package Lab4;

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        System.out.println("[Theme Park Wallet Manager]");

        boolean running = true;
        final ParkWallet wallet = new ParkWallet(100);
        final Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println();
            System.out.println("1. Add tickets");
            System.out.println("2. Set tickets");
            System.out.println("3. Buy prize"  + (ParkWallet.isHoliday() ? " at holiday prices!" : ""));
            System.out.println("4. Set holiday");
            System.out.println("5. Quit");

            System.out.println("Your wallet has " + wallet.getTickets() + " tickets.");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Add how many tickets? ");
                    int amountToAdd = scanner.nextInt();
                    wallet.addTickets(amountToAdd);
                    break;
                case 2:
                    System.out.print("Set ticket balance to: ");
                    int amountToSet = scanner.nextInt();
                    wallet.setTickets(amountToSet);
                    break;
                case 3:

                    int[] prices = new int[] {
                            150,
                            350,
                            600
                    };

                    String[] prizes = new String[] {
                            "T-shirt",
                            "Sun hat",
                            "Sneakers"
                    };

                    if (ParkWallet.isHoliday()) {
                        System.out.println("Holiday prices!");
                        for (int i = 0; i < 3; i++) {
                            prices[i] = prices[i] / 2;
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + ". " + prizes[i] + " (" + prices[i] + " tickets)");
                    }
                    System.out.print("Buy which prize? ");
                    int choice = scanner.nextInt() - 1;
                    int price = prices[choice];
                    if (wallet.removeTickets(price)) {
                        System.out.println("Bought a " + prizes[choice] + " for " + prices[choice]);
                    } else {
                        System.out.println("Not enough tickets to buy a " + prizes[choice]);
                    }

                    break;
                case 4:
                    ParkWallet.toggleHoliday();

                    if (ParkWallet.isHoliday())
                        System.out.println("It is now a holiday.");
                    else
                        System.out.println("It is no longer a holiday.");
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        System.out.println("Shutting off...");
        scanner.close();
    }
}
