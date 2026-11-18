import java.util.*;

public class VALID_ANAGRAMS {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        char[] sSort = s.toCharArray();
//        char[] tSort = t.toCharArray();
//
//        Arrays.sort(sSort);
//        Arrays.sort(tSort);
//
//        return Arrays.equals(sSort, tSort);

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }

    public static void main(String[] args) {
        VALID_ANAGRAMS obj = new VALID_ANAGRAMS();

        String s1 = "anagram";
        String s2 = "nagaram";

        System.out.println(obj.isAnagram(s1, s2));
    }
}
