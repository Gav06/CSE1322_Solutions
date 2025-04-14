package Assignment7;

import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) {
        // Create inventory
        Inventory inventory = new Inventory();

        // Create items
        Item tshirt = new Item("t-shirt", 6.50);
        Item sweater = new Item("sweater", 8.50);
        Item sweatpants = new Item("sweatpants", 10.00);
        Item skirt = new Item("skirt", 25.50);
        Item dress = new Item("dress", 15.50);

        Scanner scanner = new Scanner(System.in);

        System.out.println("[Order Queue Simulator]");

        // Create and start 5 purchaser threads
        Purchaser[] purchasers = new Purchaser[5];
        Item[] items = {tshirt, sweater, sweatpants, skirt, dress};

        for (int i = 0; i < 5; i++) {
            System.out.print("Purchase how many '" + items[i].description + "' at $" + String.format("%.2f", items[i].cost) + "? ");
            int quantity = scanner.nextInt();
            purchasers[i] = new Purchaser(inventory, items[i], quantity);
        }

        // Clear the scanner buffer
        scanner.nextLine();

        System.out.println("Purchasers created. Press 'enter' to start purchases...");
        scanner.nextLine();

        System.out.println("Purchasers have started working...");

        // Start all purchaser threads
        for (Purchaser p : purchasers) {
            p.start();
        }

        // Wait for all purchaser threads to complete
        try {
            for (Purchaser p : purchasers) {
                p.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Purchasers are done working. A total of " + inventory.getQueueSize() + " items are awaiting processing.");

        // Get number of processors
        System.out.print("Create how many processors? ");
        int numProcessors = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Processor[] processors = new Processor[numProcessors];

        // Create processor threads
        for (int i = 0; i < numProcessors; i++) {
            processors[i] = new Processor(inventory);
        }

        System.out.println("OrderProcessors created. Press 'enter' to start processing orders...");
        scanner.nextLine();

        System.out.println("Processors are now working...");

        // Start all processor threads
        for (Processor p : processors) {
            p.start();
        }

        // Wait for all processor threads to complete
        try {
            for (Processor p : processors) {
                p.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final stats
        System.out.println("All OrderProcessors are done processing orders.");
        System.out.println(inventory.getItemsProcessed() + " items were processed for a total of $" + String.format("%.2f", inventory.retrieveBalance()) + ".");
        System.out.println("Simulation complete.");

        scanner.close();
    }
}

class Item {
    public String description;
    public double cost;

    public Item(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }
}