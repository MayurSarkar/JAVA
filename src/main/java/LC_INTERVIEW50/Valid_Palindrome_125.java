package LC_INTERVIEW50;

public class Valid_Palindrome_125 {
    // Main method to test the function
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));  // Output: true
    }

    public static boolean isPalindrome(String s) {
        int st = 0, e = s.length() - 1;

        // Iterate until the two pointers meet or cross
        while (st <= e) {
            // Ignore non-alphanumeric characters at the start
            if (!Character.isLetterOrDigit(s.charAt(st))) {
                st++;
            }
            // Ignore non-alphanumeric characters at the end
            else if (!Character.isLetterOrDigit(s.charAt(e))) {
                e--;
            }
            // Compare characters in a case-insensitive manner
            else if (Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(e))) {
                return false;
            }
            // If characters match, move both pointers
            else {
                st++;
                e--;
            }
        }
        return true;
    }
}
