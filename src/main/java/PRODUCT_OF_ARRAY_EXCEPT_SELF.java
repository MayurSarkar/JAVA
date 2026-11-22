import java.util.*;

public class PRODUCT_OF_ARRAY_EXCEPT_SELF {
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            int prod = 1;
//            for (int j = 0; j < n; j++) {
//                if (i != j)
//                    prod *= nums[j];
//            }
//            res[i] = prod;
//        }
//        return res;
//    }

    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zeroCount = 0;

        for (int num : nums) {
            if (num != 0)
                prod *= num;
            else
                zeroCount++;
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0)
                res[i] = (nums[i] == 0) ? prod : 0;
            else
                res[i] = prod / nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        PRODUCT_OF_ARRAY_EXCEPT_SELF obj = new PRODUCT_OF_ARRAY_EXCEPT_SELF();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
    }
}
