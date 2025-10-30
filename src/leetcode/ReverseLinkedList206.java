package leetcode;

import java.util.Stack;
import leetcode.ListNode;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> st = new Stack<>();
        while (head != null) {
            st.push(head);
            head = head.next;
        }
        ListNode h2 = st.pop();
        ListNode curr = h2;
        while (!st.isEmpty()) {
            curr.next = st.pop();
            curr = curr.next;
        }
        curr.next = null;
        return h2;

    }
}
