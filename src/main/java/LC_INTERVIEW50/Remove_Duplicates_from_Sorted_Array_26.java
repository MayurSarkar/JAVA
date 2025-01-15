package LC_INTERVIEW50;
import java.util.*;

public class Remove_Duplicates_from_Sorted_Array_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the sorted elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int newLength = removeDuplicates(nums);

        System.out.println("Array after removing duplicates (new length " + newLength + "):");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = nums[0];
        int c = 1;

        for (int i = 1; i < nums.length; i++) {
            if (k != nums[i]) {
                nums[c] = nums[i];
                k = nums[i];
                c++;
            }
        }
        return c;
    }
}
