package LC_INTERVIEW50;
import java.util.*;

public class Find_the_Index_of_the_First_Occurrence_in_a_String_28 {
   // Find the Index of the First Occurrence in a String
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter the haystack: ");
       String haystack = scanner.nextLine();

       System.out.print("Enter the needle: ");
       String needle = scanner.nextLine();

       int result = strStr(haystack, needle);

       if (result != -1) {
           System.out.println("The needle is found at index: " + result);
       } else {
           System.out.println("Needle not found.");
       }
   }

    public static int strStr(String haystack, String needle) {
        int m = needle.length();
        if (m == 0) return 0;

        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        // Building the LPS array
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        int n = haystack.length();
        i = 0;  // Pointer for the needle
        int j = 0;  // Pointer for the haystack

        // Searching the needle in the haystack
        while (j < n) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
                if (i == m) {
                    return j - m;
                }
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }

        return -1;
    }
}
