package LC_INTERVIEW50;
import java.util.Scanner;

public class Power_of_x_to_n {

    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;  // convert to long to handle Integer.MIN_VALUE case

        if (nn < 0) nn = -nn;

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn--;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        if (n < 0) ans = 1.0 / ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base (x): ");
        double x = scanner.nextDouble();

        System.out.print("Enter exponent (n): ");
        int n = scanner.nextInt();
        Power_of_x_to_n power = new Power_of_x_to_n();
        double result = power.myPow(x, n);


        System.out.println("Result: " + result);
    }
}
