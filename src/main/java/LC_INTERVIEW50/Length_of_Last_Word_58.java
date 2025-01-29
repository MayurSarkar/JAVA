package LC_INTERVIEW50;
import java.util.*;

public class Length_of_Last_Word_58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        int length = lengthOfLastWord(s);

        System.out.println("Length of the last word: " + length);
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count > 0) {
                break;
            }
            if (s.charAt(i) != ' ') {
                count++;
            }
        }

        return count;
    }
}
