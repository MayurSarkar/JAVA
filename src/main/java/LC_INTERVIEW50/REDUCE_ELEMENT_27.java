package LC_INTERVIEW50;
import java.util.*;

public class REDUCE_ELEMENT_27 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.print("Enter the value to remove: ");
            int val = scanner.nextInt();

            int newLength = removeElement(nums, val);

            System.out.println("Array after removal (new length " + newLength + "):");
            for (int i = 0; i < newLength; i++) {
                System.out.print(nums[i] + " ");
            }
        }


        public static int removeElement(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;
        }


}
