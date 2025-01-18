package LC_INTERVIEW50;
import java.util.Scanner;

public class ROTATE_ARRAY_189 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.print("Enter the value of k (number of positions to rotate): ");
            int k = scanner.nextInt();

            rotate(nums, k);

            System.out.println("Array after rotation:");
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }


        public static void rotate(int[] nums, int k) {
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                temp[(i + k) % nums.length] = nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }


}
