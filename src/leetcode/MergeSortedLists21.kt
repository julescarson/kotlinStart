package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ListNode2(var `val`: Int) {
    var next: ListNode2? = null
}


class Solution {
    fun mergeTwoLists(list1: ListNode2?, list2: ListNode2?): ListNode2? {
        var list1 = list1
        var list2 = list2

        val dummy : ListNode2? = ListNode2(0);
        var ptr : ListNode2? = dummy;

        while (list1 != null && list2 != null) {

            if (list1.`val` <= list2.`val`) {
                ptr!!.next = list1
                list1 = list1?.next
            } else {
                ptr?.next = list2
                list2 = list2.next
            }
            ptr = ptr?.next!!
        }
        //then the merge (one should be null at end of look through from above loop)
        if (list1 != null) {
            ptr?.next = list1
        } else if (list2 != null) {
            ptr?.next = list2
        }
        return dummy?.next
    }
}