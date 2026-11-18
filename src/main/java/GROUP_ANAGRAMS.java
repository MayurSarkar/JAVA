import java.util.*;

public class GROUP_ANAGRAMS {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        GROUP_ANAGRAMS obj = new GROUP_ANAGRAMS();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "nat"};
        List<List<String>> result = obj.groupAnagrams(input);
        System.out.println(result);
    }
}
