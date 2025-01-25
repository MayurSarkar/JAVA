package LC_INTERVIEW50;
import java.util.*;

public class Product_of_Array_Except_Self_238 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println("Product of array except self:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int productWithoutZero = 1;
        int totalProduct = 1;
        int zeroCount = 0;

        // First pass: calculate the total product and product without zero
        for (int num : nums) {
            if (num != 0) {
                productWithoutZero *= num;
            }
            totalProduct *= num;
            if (num == 0) {
                zeroCount++;
            }
        }

        // Second pass: calculate the result
        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                answer[i] = 0;  // More than one zero in the array, all products will be zero
            } else if (nums[i] == 0) {
                answer[i] = productWithoutZero;  // If current element is zero, return the product without the zero
            } else {
                answer[i] = totalProduct / nums[i];  // Otherwise, divide the total product by the current element
            }
        }

        return answer;
    }
}
