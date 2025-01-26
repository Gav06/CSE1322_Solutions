package Assignment1;

import java.util.Scanner;

public class Assignment1 {

    private static int appleCount;
    private static int orangeCount;
    private static double appleSellPrice;
    private static double orangeSellPrice;
    private static double balance;

    public static void main(String[] args) {
        appleCount = 0;
        orangeCount = 0;
        appleSellPrice = 0.0;
        orangeSellPrice = 0.0;
        balance = 0.0;

        System.out.println("[Fruit Management System]");

        boolean running = true;

        final Scanner scanner = new Scanner(System.in);

        while (running) {
            // print list
            System.out.println("1. Buy apples");
            System.out.println("2. Buy oranges");
            System.out.println("3. Sell apples");
            System.out.println("4. Sell oranges");
            System.out.println("5. Change price of apples");
            System.out.println("6. Change price of oranges");
            System.out.println("7. List inventory");
            System.out.println("8. Show balance");
            System.out.println("0. Quit");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyApples(scanner);
                    break;
                case 2:
                    buyOranges(scanner);
                    break;
                case 3:
                    sellApples(scanner);
                    break;
                case 4:
                    sellOranges(scanner);
                    break;
                case 5:
                    changeApplePrice(scanner);
                    break;
                case 6:
                    changeOrangePrice(scanner);
                    break;
                case 7:
                    System.out.println("Current inventory is:");
                    System.out.println(appleCount + " apples currently selling @ $" + appleSellPrice);
                    System.out.println(orangeCount + " oranges currently selling @ $" + orangeSellPrice);
                    break;
                case 8:
                    System.out.println("Current balance is $" + balance);
                    break;
                case 0:
                    System.out.println("Shutting off...");
                    running = false;
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void buyApples(Scanner scanner) {
        System.out.print("Buy how many apples? ");
        int amount = scanner.nextInt();


        while (amount < 0) {
            System.out.print("Invalid quantity. Enter a non-negative number: ");
            amount = scanner.nextInt();
        }

        if (amount == 0) {
            System.out.println("Buying no apples.");
            return;
        }

        System.out.print("Buy apples at what price? $");
        double buyPrice = scanner.nextDouble();

        double total = amount * buyPrice;
        appleCount += amount;
        balance -= total;
        System.out.print("Bought " + amount + " apples @ $" + buyPrice + " for a total of $" + total);
    }

    private static void buyOranges(Scanner scanner) {
        System.out.print("Buy how many oranges? ");
        int amount = scanner.nextInt();

        while (amount < 0) {
            System.out.print("Invalid quantity. Enter a non-negative number: ");
            amount = scanner.nextInt();
        }

        if (amount == 0) {
            System.out.println("Buying no oranges.");
            return;
        }

        System.out.print("Buy oranges at what price? $");
        double buyPrice = scanner.nextDouble();

        double total = amount * buyPrice;
        orangeCount += amount;
        balance -= total;
        System.out.print("Bought " + amount + " oranges @ $" + buyPrice + " for a total of $" + total);
    }

    private static void sellApples(Scanner scanner) {
        System.out.print("Sell how many apples @ $" + appleSellPrice + "? ");
        int sellAmount = scanner.nextInt();

        while (sellAmount < 0) {
            System.out.print("Enter a non-negative number of apples to sell: ");
            sellAmount = scanner.nextInt();
        }

        double total;

        if (sellAmount > appleCount) {
            sellAmount = appleCount;
            total = sellAmount * appleSellPrice;
            System.out.println("Not enough apples. Selling instead " + appleCount
                    + " apples @ $" + appleSellPrice + " for a total of $" + total);
            appleCount = 0;
        } else {
            total = sellAmount * appleSellPrice;

            if (appleCount == sellAmount) {
                System.out.println("Sold all apples @ $" + appleSellPrice + " for a total of $" + total);
            } else {
                System.out.println("Sold " + sellAmount + " apples @ $" + appleSellPrice + " for a total of $" + total);
            }

            appleCount -= sellAmount;
        }

        balance += total;
    }

    private static void sellOranges(Scanner scanner) {
        System.out.print("Sell how many oranges @ $" + orangeSellPrice + "? ");
        int sellAmount = scanner.nextInt();

        while (sellAmount < 0) {
            System.out.print("Enter a non-negative number of oranges to sell: ");
            sellAmount = scanner.nextInt();
        }

        double total;

        if (sellAmount > orangeCount) {
            sellAmount = orangeCount;
            total = sellAmount * orangeSellPrice;
            System.out.println("Not enough oranges. Selling instead " + orangeCount
                    + " oranges @ $" + orangeSellPrice + " for a total of $" + total);
            orangeCount = 0;
        } else {
            total = sellAmount * orangeSellPrice;

            if (orangeCount == sellAmount) {
                System.out.println("Sold all oranges @ $" + orangeSellPrice + " for a total of $" + total);
            } else {
                System.out.println("Sold " + sellAmount + " oranges @ $" + orangeSellPrice + " for a total of $" + total);
            }

            orangeCount -= sellAmount;
        }

        balance += total;
    }

    private static void changeApplePrice(Scanner scanner) {
        System.out.print("What should be the new price of selling apples? $");
        double newPrice = scanner.nextDouble();

        while (newPrice < 0.0) {
            System.out.print("Invalid price. Enter a non-negative price: $");
            newPrice = scanner.nextDouble();
        }

        appleSellPrice = newPrice;
        System.out.println("Selling price of apples set @ $" + newPrice);
    }

    private static void changeOrangePrice(Scanner scanner) {
        System.out.print("What should be the new price of selling oranges? $");
        double newPrice = scanner.nextDouble();

        while (newPrice < 0.0) {
            System.out.print("Invalid price. Enter a non-negative price: $");
            newPrice = scanner.nextDouble();
        }

        orangeSellPrice = newPrice;
        System.out.println("Selling price of oranges set @ $" + newPrice);
    }
}
