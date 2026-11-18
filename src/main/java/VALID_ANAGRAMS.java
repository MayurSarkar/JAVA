import java.util.*;

public class VALID_ANAGRAMS {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);
    }

    public static void main(String[] args) {
        VALID_ANAGRAMS obj = new VALID_ANAGRAMS();

        String s1 = "anagram";
        String s2 = "nagaram";

        System.out.println(obj.isAnagram(s1, s2));
    }
}
