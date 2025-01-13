package LC_INTERVIEW50;
import java.util.*;

public class MERGE_SORTED_ARRAY_88 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Reading the size of the nums1 array
            System.out.print("Enter the number of initialized elements in nums1: ");
            int m = scanner.nextInt();

            // Reading the size of the nums2 array
            System.out.print("Enter the size of nums2 array: ");
            int n = scanner.nextInt();

            // nums1 must have enough space for m + n elements
            int[] nums1 = new int[m + n];

            System.out.println("Enter elements for nums1 (first " + m + " elements):");
            for (int i = 0; i < m; i++) {
                nums1[i] = scanner.nextInt();
            }

            int[] nums2 = new int[n];
            System.out.println("Enter elements for nums2:");
            for (int i = 0; i < n; i++) {
                nums2[i] = scanner.nextInt();
            }

            merge(nums1, m, nums2, n);

            System.out.println("Merged and sorted array:");
            for (int num : nums1) {
                System.out.print(num + " ");
            }
        }


        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int j = 0, i = m; j < n; j++) {
                nums1[i] = nums2[j];
                i++;
            }
            Arrays.sort(nums1);
        }

}
