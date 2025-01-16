package LC_INTERVIEW50;
import java.util.Scanner;

public class Remove_Duplicates_from_Sorted_Array_II_80 {
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
            int position = 0;
            for (int element : nums) {
                if (position == 0 || position == 1 || nums[position - 2] != element) {
                    nums[position] = element;
                    position++;
                }
            }
            return position;
        }


}
