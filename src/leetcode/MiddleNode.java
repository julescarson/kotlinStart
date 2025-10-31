package leetcode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode t = head;
        int c = 0;
        while (t != null) {
            t = t.next;
            c++;
        }
        c = (int)Math.ceil(c/2);
        while (c !=0){
            head = head.next;
            c--;
        }
        return head;
    }
}
