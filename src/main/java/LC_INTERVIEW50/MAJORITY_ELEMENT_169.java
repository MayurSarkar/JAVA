package LC_INTERVIEW50;
import java.util.HashMap;
import java.util.Scanner;


public class MAJORITY_ELEMENT_169 {

     public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int majorityElement = majorityElement(nums);

            System.out.println("The majority element is: " + majorityElement);
        }


        public static int majorityElement(int[] nums) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            int res = 0;
            int majority = 0;

            for (int n : nums) {
                hash.put(n, 1 + hash.getOrDefault(n, 0));
                if (hash.get(n) > majority) {
                    res = n;
                    majority = hash.get(n);
                }
            }

            return res;
        }


}
