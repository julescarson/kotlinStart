package leetcode;

public class BinarySearch704
{
    public int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;

        while (start <= end){
            int mid = start + ((end - start)/2);

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;


    }
}
