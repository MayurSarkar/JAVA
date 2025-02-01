package LC_INTERVIEW50;
import java.util.*;

public class Reverse_Words_in_a_String_151 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = scanner.nextLine();

        String reversedWords = reverseWords(s);

        System.out.println("Reversed words: " + reversedWords);
    }
    public static String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                if ((i > 0 && s.charAt(i - 1) == ' ') || i == 0) {
                    result.append(word.reverse().toString()).append(" ");
                    word.setLength(0);
                }
            }
        }

        // Remove the trailing space
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

}
