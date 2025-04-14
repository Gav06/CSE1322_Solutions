package Lab11;

import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlueRayCollection collection = new BlueRayCollection();
        int option = 0;

        while (option != 3) {
            System.out.println("[BlueRay Disk Collection]");
            System.out.println("1. Add to collection");
            System.out.println("2. See collection");
            System.out.println("3. Quit");
            System.out.print("Enter option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        addDiskToCollection(scanner, collection);
                        break;
                    case 2:
                        showCollection(collection);
                        break;
                    case 3:
                        System.out.println("Shutting off...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    private static void addDiskToCollection(Scanner scanner, BlueRayCollection collection) {
        System.out.print("Enter disk title: ");
        String title = scanner.nextLine();

        System.out.print("Enter director name: ");
        String director = scanner.nextLine();

        int yearOfRelease;
        double cost;

        try {
            System.out.print("Enter year of release: ");
            yearOfRelease = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Year of release must be a whole number!");
            return;
        }

        try {
            System.out.print("Enter price of disk: ");
            String priceInput = scanner.nextLine();

            if (priceInput.startsWith("$")) {
                priceInput = priceInput.substring(1);
            }
            cost = Double.parseDouble(priceInput);
        } catch (NumberFormatException e) {
            System.out.println("Error: Price must be a number!");
            return;
        }

        collection.addDisk(title, director, yearOfRelease, cost);
        System.out.println("BlueRay Disk added to collection.");
    }

    private static void showCollection(BlueRayCollection collection) {
        String allDisks = collection.showAll();
        if (allDisks.isEmpty()) {
            System.out.println("BlueRay collection is empty");
        } else {
            System.out.println("Here's your current collection:");
            System.out.println(allDisks);
        }
    }
}