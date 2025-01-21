package LC_INTERVIEW50;
import java.util.Scanner;


public class JUMP_GAME_55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int last_pos = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + i >= last_pos) {
                last_pos = i;
            }
        }

        return last_pos == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean result = canJump(nums);

        System.out.println("Can jump to the last index: " + result);
    }
}
