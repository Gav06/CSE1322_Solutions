package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * I noticed that the example output provided in the assignment sheet
 * does not make logical sense.
 * It is written as if building #1 has 7 apartments. However, it is
 * only initialized with 5. Building #2 is what gets initialized with 7 apartments.
 * This means that adding Bob to Building #1, apartment 6 is not possible.
 * Just something worth noting, if this is being compared to the example output.
 */

public class Assignment2 {

    private static final List<Building> buildings = new ArrayList<Building>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("[Apartment Complex Management System]");
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Add building");
            System.out.println("2. Remove building");
            System.out.println("3. List all buildings");
            System.out.println("4. List all tenants");
            System.out.println("5. Add tenant");
            System.out.println("6. Remove tenant");
            System.out.println("7. Update tenant");
            System.out.println("8. Charge rent");
            System.out.println("9. Pay for service");

            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBuilding();
                    break;
                case 2:
                    removeBuilding();
                    break;
                case 3:
                    listBuildings();
                    break;
                case 4:
                    listTenants();
                    break;
                case 5:
                    addTenant();
                    break;
                case 6:
                    removeTenant();
                    break;
                case 7:
                    updateTenant();
                    break;
                case 8:
                    chargeRent();
                    break;
                case 9:
                    payForService();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Shutting off...");
        scanner.close();
    }

    private static void addBuilding() {
        System.out.print("How many tenants can this building have? ");
        int amount = scanner.nextInt();
        Building building = new Building(amount);
        buildings.add(building);
        System.out.println("Building " + building.getId() + " created");
    }

    private static void removeBuilding() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        buildings.remove(building);
        System.out.println("Building removed");
    }

    private static void listBuildings() {
        for (Building building : buildings) {
            System.out.println("Building " + building.getId() + " : "
                    + building.countTenants() + " tenants");
        }
    }

    private static void listTenants() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        System.out.println(building.listTenants());
    }

    private static void addTenant() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        System.out.println(building.listTenants());

        System.out.print("Enter the tenant's name: ");
        final String name = scanner.next();
        System.out.print("Enter the tenant's age: ");
        final int age = scanner.nextInt();
        System.out.print("Enter the tenant's rent: ");
        final double rent = scanner.nextDouble();

        final Tenant tenant = new Tenant(name, age, rent);

        System.out.print("What apartment should this tenant live in? ");
        final int apt = scanner.nextInt();

        if (!building.addTenant(tenant, apt)) {
            System.out.println("Apartment is already occupied or invalid.");
        } else {
            System.out.println("Tenant added.");
        }
    }

    private static void removeTenant() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        System.out.println(building.listTenants());


        System.out.print("Enter the apartment of the tenant to be removed: ");
        final int apt = scanner.nextInt();
        if (!building.removeTenant(apt)) {
            System.out.println("Apartment is empty or invalid.");
        } else {
            System.out.println("Tenant removed.");
        }
    }

    private static void updateTenant() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        System.out.println(building.listTenants());


        System.out.print("Enter the apartment number of the tenant to be updated: ");
        final int apt = scanner.nextInt();

        final Tenant tenant = building.getTenant(apt);

        if (tenant == null) {
            System.out.println("Apartment is empty or invalid.");
            return;
        }

        System.out.println("Current tenant information: ");
        System.out.println(tenant);

        System.out.print("Enter new name: ");
        final String name = scanner.next();

        System.out.print("Enter new age: ");
        final int age = scanner.nextInt();

        System.out.print("Enter new rent: $");
        final double rent = scanner.nextDouble();
        final Tenant newTenant = new Tenant(name, age, rent);
        building.removeTenant(apt);
        building.addTenant(newTenant, apt);
        System.out.println("Tenant updated.");
    }

    private static void chargeRent() {
        final Building building = promptForBuilding();

        if (building == null)
            return;

        System.out.println(building.listTenants());


        System.out.print("Enter apartment number to charge rent: ");
        final int apt = scanner.nextInt();

        final Tenant tenant = building.getTenant(apt);

        if (tenant == null) {
            System.out.println("Apartment is empty or invalid.");
            return;
        }

        Building.collectRent(tenant);
        System.out.println("Tenant charged. New balance is  $" + Building.getBalance());
    }

    private static void payForService() {
        System.out.println("Current balance is $" + Building.getBalance());
        System.out.print("Enter service amount: $");
        final double serviceAmount = scanner.nextDouble();
        Building.payForService(serviceAmount);
        System.out.println("New balance is $" + Building.getBalance());
    }

    private static Building getBuildingById(int id) {
        Building target = null;
        for (Building building : buildings) {
            if (building.getId() == id) {
                target = building;
                break;
            }
        }

        return target;
    }

    private static Building promptForBuilding() {
        System.out.print("Enter id of building: ");
        final int id = scanner.nextInt();

        final Building building = getBuildingById(id);

        if (building == null) {
            System.out.println("No building with that id");
            return null;
        }

        return building;
    }
}
