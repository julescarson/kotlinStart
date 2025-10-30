package leetcode;
import java.util.HashMap;

public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mg = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            mg.put(c, mg.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);

            if (mg.get(r) == null || mg.get(r) == 0) {
                return false;
            } else {
                mg.put(r, mg.get(r) - 1);
            }
        }
        return true;
    }
}
