package Lab7;

import java.util.Scanner;

public class Lab7 {

    public static void main(String[] args) {
        System.out.println("gavin ? nivag");
        System.out.println(recursiveReverse("gavin", "nivag"));

        final Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. Multiply 2 numbers");
            System.out.println("2. Divide 2 numbers");
            System.out.println("3. Mod 2 numbers");
            System.out.println("4. Echo sentence");
            System.out.println("5. Determine if reverse");
            System.out.println("6. Quit");
            System.out.print("Enter option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    running = false;
                    break;
            }

            System.out.println("Shutting off...");
        }

        scanner.close();
    }

    public static int recursiveMultiply(int a, int b) {
        if (b <= 1)
            return a;

        return a + recursiveMultiply(a, --b);
    }

    public static int recursiveDivision(int a, int b) {
        // dividing by zero
        if (b == 0)
            return -1;

        // result is less than 1 (decimal)
        if (a < b)
            return 0;

        return 1 + recursiveDivision(a - b, b);
    }

    public static int recursiveRemainder(int a, int b) {
        if (b <= 0) // divide by zero
            return -1;

        if (a < b)
            return a;
        else
            return recursiveRemainder(a - b, b);
    }

    public static String recursiveEcho(String str, int n) {
        if (n <= 1)
            return str;

        return str + recursiveEcho(str, --n);
    }

    public static boolean recursiveReverse(String str1, String str2) {
        if (str1.charAt(0) == str2.charAt(str2.length() - 1))
            return recursiveReverse(str1.substring(1, str1.length() - 1), str2.substring());
        else
            return false;
    }
}
