package leetcode;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
            //can return right away if find n/2 element
            if (count.get(num) >= Math.ceil(nums.length/2)+1) return num;
        }
        // for (Map.Entry<Integer, Integer> e : count.entrySet()) {
        //     if (e.getValue() > Math.ceil(nums.length/2)) {
        //         return e.getKey();
        //     }
        // }
        return -1;
    }
}
