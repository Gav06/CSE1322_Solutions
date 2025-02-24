package Lab6;

public class Fiberation implements FindFib {

    @Override
    public int calculateFib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }

        return second;
    }
}
