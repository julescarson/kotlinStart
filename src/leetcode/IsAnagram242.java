package leetcode;

import java.util.HashMap;

//used hashmaps, compared equality
//count each char instance in each
public class IsAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (t.compareTo(s) == 0) return true;
        if (t.length() != s.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap();
        HashMap<Character, Integer> tMap = new HashMap();
        for (int i = 0; i<s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return tMap.equals(sMap);


    }
}
