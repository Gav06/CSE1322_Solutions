package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
    private static final ArrayList<Item> items = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("[VaporStore Item System]");
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addVideoGame();
                    break;
                case 2:
                    addDevelopmentKit();
                    break;
                case 3:
                    addTradable();
                    break;
                case 4:
                    addCollectable();
                    break;
                case 5:
                    listAllItems();
                    break;
                case 6:
                    updatePrice();
                    break;
                case 7:
                    System.out.println("Shutting off...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add video game");
        System.out.println("2. Add development kit");
        System.out.println("3. Add tradable");
        System.out.println("4. Add collectable");
        System.out.println("5. List all items");
        System.out.println("6. Update price");
        System.out.println("7. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void addVideoGame() {
        System.out.print("Enter game name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Does it support multiplayer? (true/false): ");
        boolean multiplayer = scanner.nextBoolean();
        scanner.nextLine();

        items.add(new VideoGame(name, price, publisher, multiplayer));
        System.out.println("Video game added successfully!");
    }

    private static void addDevelopmentKit() {
        System.out.print("Enter kit name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter target platforms (comma-separated): ");
        String[] platforms = scanner.nextLine().split(",");
        ArrayList<String> targetPlatforms = new ArrayList<>();
        for (String platform : platforms) {
            targetPlatforms.add(platform.trim());
        }

        items.add(new DevelopmentKit(name, price, publisher, targetPlatforms));
        System.out.println("Development kit added successfully!");
    }

    private static void addTradable() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter sale delay (in days): ");
        int saleDelay = scanner.nextInt();
        scanner.nextLine();

        items.add(new Tradable(name, price, description, saleDelay));
        System.out.println("Tradable item added successfully!");
    }

    private static void addCollectable() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter type (emoticon/avatar/background/nothing): ");
        String type = scanner.nextLine();

        items.add(new Collectable(name, price, description, type));
        System.out.println("Collectable item added successfully!");
    }

    private static void listAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the database.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private static void updatePrice() {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Item item = findItemById(id);
        if (item == null) {
            System.out.println("Item not found.");
        } else {
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();
            item.setPrice(newPrice);
            System.out.println("Price updated successfully!");
        }
    }

    private static Item findItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}