package Lab6;

import java.util.Scanner;

public class Lab6 {

    public static void main(String[] args) {
        final FibFormula fib = new FibFormula();
        final Fiberation it = new Fiberation();
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Find which position in the Fibonacci Sequence? ");
        int n = scanner.nextInt();

        System.out.println("Fib of " + n + " using iteration is " + it.calculateFib(n));
        System.out.println("Fib of " + n + " using Binet's formula is " + fib.calculateFib(n));
        System.out.println("Program complete.");

        scanner.close();
    }
}
