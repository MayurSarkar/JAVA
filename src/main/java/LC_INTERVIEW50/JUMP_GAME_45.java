package LC_INTERVIEW50;
import java.util.*;

public class JUMP_GAME_45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int jumps = jump(nums);

        System.out.println("The minimum number of jumps to reach the last index: " + jumps);
    }
    public static int jump(int[] nums) {
        int last = 0;
        int left = 0, right = 0;
        int jumps = 0;

        while (last < nums.length - 1) {
            jumps++;
            for (int i = left; i <= right; i++) {
                last = Math.max(last, i + nums[i]);
            }
            left = right + 1;
            right = last;
        }

        return jumps;
    }
}
