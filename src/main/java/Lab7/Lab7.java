package Lab7;

import java.util.Scanner;

public class Lab7 {

    public static void main(String[] args) {
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
                    int[] mul = getInputValues(scanner);
                    System.out.println("Your product is " + recursiveMultiply(mul[0], mul[1]));
                    break;
                case 2:
                    int[] div = getInputValues(scanner);
                    System.out.println("Your quotient is " + recursiveDivision(div[0], div[1]));
                    break;
                case 3:
                    int[] mod = getInputValues(scanner);
                    System.out.println("Your remainder is " + recursiveRemainder(mod[0], mod[1]));
                    break;
                case 4:
                    System.out.print("Enter your sentence: ");
                    String s = scanner.nextLine();
                    System.out.print("Repeat how any times? ");
                    int n = Integer.parseInt(scanner.nextLine());
                    System.out.println("Your sentence repeated " + n + " times is");
                    System.out.println(recursiveEcho(s, n));
                    break;
                case 5:
                    System.out.print("Enter a sentence: ");
                    String s1 = scanner.nextLine();
                    System.out.print("Enter another sentence: ");
                    String s2 = scanner.nextLine();
                    boolean result = recursiveReverse(s1, s2);
                    String not = result ? "" : "NOT ";
                    System.out.println("The sentences are " + not + "the opposite of each other.");
                    break;
                case 6:
                    running = false;
                    System.out.println("Shutting off...");
                    break;
            }

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
        if (str1.length() != str2.length())
            return false;

        if (str1.isEmpty())
            return true;

        if (str1.toLowerCase().charAt(0) == str2.toLowerCase().charAt(str2.length() - 1))
            return recursiveReverse(str1.substring(1), str2.substring(0, str2.length() - 1));
        else
            return false;
    }

    public static int[] getInputValues(Scanner scanner) {
        System.out.print("Enter the first number: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the second number: ");
        int b = Integer.parseInt(scanner.nextLine());
        return new int[] { a, b };
    }
}
