package leetcode;
import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //use hashmap, store count for each element
        //only 1 or 0 elements may have uneven quantity?
        HashMap<Character, Integer> charCounts = new HashMap<>();
        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            if (c == ' ') continue;
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }


        int maxLength = 0; //add highest even count for each charCount
        boolean hasUneven = false; //add 1 at the end if any uneven charcounts were found
        for (Integer count : charCounts.values()) {
            if (count % 2 == 0) {
                maxLength += count;
            } else {
                maxLength += count-1;
                hasUneven = true;
            }
        }

        if (hasUneven) maxLength += 1;
        return maxLength;
    }
}
