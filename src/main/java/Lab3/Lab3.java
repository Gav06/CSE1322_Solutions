package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {
        final List<String[]> contacts = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);

        boolean running = true;
        System.out.println("[Phonebook]");
        while (running) {
            System.out.println();
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. List contacts");
            System.out.println("4. Search contacts");
            System.out.println("5. Quit");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = scanner.next();

                    System.out.print("Enter the contact's phone number: ");
                    String num = scanner.next();

                    contacts.add(new String[] {name, num});
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter contact to remove: ");
                    String contact = scanner.next();

                    int removeIndex = -1;
                    for (int i = 0; i < contacts.size(); i++) {
                        if (contacts.get(i)[0].equals(contact)) {
                            removeIndex = i;
                        }
                    }

                    if (removeIndex == -1) {
                        System.out.println("No contact with that name.");
                    } else {
                        contacts.remove(removeIndex);
                        System.out.println("Contact deleted.");
                    }
                    break;
                case 3:
                    if (contacts.isEmpty()) {
                        System.out.println("The phonebook is empty.");
                        break;
                    }

                    System.out.println("Listing all contacts...");
                    for (String[] arr : contacts) {
                        System.out.println("Name: " + arr[0] + " | Phone: " + arr[1]);
                    }
                    System.out.println("Done listing contacts.");
                    break;
                case 4:
                    System.out.print("Enter the keyword to search: ");
                    String search = scanner.next();
                    System.out.println("Searching all contacts for keyword...");


                    final List<String[]> results = new ArrayList<>();
                    for (String[] arr : contacts) {
                        if (arr[0].contains(search)) {
                            results.add(arr);
                        }
                    }

                    if (results.isEmpty()) {
                        System.out.println("No contacts contained the keyword.");
                    } else {
                        for (String[] arr : results) {
                            System.out.println("Name: " + arr[0] + " | Phone: " + arr[1]);
                        }
                        System.out.println("Done searching keyword.");
                    }

                    break;
                case 5:
                    System.out.println("Shutting off...");
                    running = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Shutting off...");
        scanner.close();
    }
}
