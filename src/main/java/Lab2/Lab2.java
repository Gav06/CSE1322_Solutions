package Lab2;

import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        boolean running = true;
        final Scanner scanner = new Scanner(System.in);


        while (running) {
            // print choices
            System.out.println("1. Count from a number to another");
            System.out.println("2. Determine largest number");
            System.out.println("3. Type in word");
            System.out.println("4. Quit");

            // obtain user input
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    countNumber(scanner);
                    break;
                case 2:
                    largestNumber(scanner);
                    break;
                case 3:
                    typeWord(scanner);
                    break;
                case 4:
                    System.out.println("Shutting off...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }

        scanner.close();
    }

    private static void largestNumber(Scanner scanner) {
        System.out.println("This option will display the largest number entered. Enter 0 when done.");
        int largest = 0;

        int lastInput = -1;

        while (lastInput != 0) {
            System.out.print("Enter a number (current largest is " + largest + "): ");
            lastInput = scanner.nextInt();

            if (lastInput > largest) {
                largest = lastInput;
            }
        }

        System.out.println("The largest number entered was " + largest + "\n");
    }

    private static void countNumber(Scanner scanner) {
        System.out.print("Enter the start point: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end point: ");
        int end = scanner.nextInt();

        System.out.println("Counting from " + start + " to " + end + "...");
        if (start == end) {
            System.out.println("Start and end are the same!");
        } else if (end > start) {
            // count up
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
        } else {
            // count down
            for (int i = start; i >= end; i--) {
                System.out.println(i);
            }
        }

        System.out.println("Done counting.");
    }

    private static void typeWord(Scanner scanner) {
        System.out.print("Type in the word 'Computer': ");
        String word = scanner.next();

        while (!word.equals("Computer")) {
            System.out.print("Incorrect. You must type 'Computer': ");
            word = scanner.next();
        }

        System.out.println("Correct!\n");
    }
}
