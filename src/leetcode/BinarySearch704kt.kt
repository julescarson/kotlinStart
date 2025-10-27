package leetcode

class BinarySearch704kt {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size

        while (start <= end){
            val mid = start + (end-start) /2
            if (nums[mid] == target) return mid
            if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}