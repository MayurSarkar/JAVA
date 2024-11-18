package Test;

import java.util.*;
public class test1 {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 1;  // Start count as 1 for the first character
        char ch = s.charAt(0);  // First character to compare

        for (int k = 1; k < s.length(); k++) {
            if (ch == s.charAt(k)) {
                count++;  // Increment count if the character is the same
            } else {
                System.out.print(ch + "" + count);  // Print the character and its count
                ch = s.charAt(k);  // Move to the next character
                count = 1;  // Reset count for the new character
            }
        }
        // Print the last character count
        System.out.print(ch + "" + count);

    }
}