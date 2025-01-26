package LC_INTERVIEW50;
import java.util.*;

public class Trapping_Rain_Water_42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the height array: ");
        int n = scanner.nextInt();

        int[] height = new int[n];
        System.out.println("Enter the elements of the height array:");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        int result = trap(height);
        System.out.println("Amount of trapped rainwater: " + result);
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] ltr = new int[n];  // left-to-right max
        int curMax = -1;

        // Fill ltr array with the maximum heights from left to right
        for (int i = 0; i < n; i++) {
            curMax = Math.max(curMax, height[i]);
            ltr[i] = curMax;
        }

        int[] rtl = new int[n];  // right-to-left max
        curMax = -1;

        // Fill rtl array with the maximum heights from right to left
        for (int i = n - 1; i >= 0; i--) {
            curMax = Math.max(curMax, height[i]);
            rtl[i] = curMax;
        }

        int res = 0;

        // Calculate the trapped water
        for (int i = 0; i < n; i++) {
            int bounds = Math.min(ltr[i], rtl[i]);
            res += Math.max(bounds - height[i], 0);
        }

        return res;
    }
}
