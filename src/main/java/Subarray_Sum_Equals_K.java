import java.util.*;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Subarray_Sum_Equals_K obj = new Subarray_Sum_Equals_K();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("TC1: " + obj.subarraySum(nums1, k1));

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("TC2: " + obj.subarraySum(nums2, k2));
    }
}
