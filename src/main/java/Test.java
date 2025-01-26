import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        System.out.print("Enter number to factorial: ");
        int num = s.nextInt();
        s.close();
        System.out.println(factorial(num));
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;

        for (int i = n - 1; i > 0; i--) {
            n *= i;
        }

        return n;
    }
}
