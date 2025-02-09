package LC_INTERVIEW50;

public class Is_Subsequence_392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));  // Output: true
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), o = t.length(), j = 0;

        // Traverse through the string 't'
        for (int i = 0; i < o && j < n; i++) {
            // If characters match, move pointer j for 's'
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }

        // If j reaches the length of 's', it is a subsequence
        return (j == n);
    }
}
