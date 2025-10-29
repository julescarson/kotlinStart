package leetcode;






public class HasCylce141 {

    class ListNode {
       ListNode next;
        ListNode(int x) {
            int val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode dummy = head.next.next;
        ListNode behind = head.next;

        int i = 0;
        while (dummy != null) {
            if (dummy == behind) return true;
            i++;
            dummy = dummy.next;
            if (i % 2 == 0) {
                behind = behind.next;
            }
        }
        return false;
    }
}
