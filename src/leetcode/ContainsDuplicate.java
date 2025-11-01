package leetcode;
import java.util.HashMap;


public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            if (numCounts.get(num) >= 2) {
                return true;
            }
        }
        return false;
    }
}
