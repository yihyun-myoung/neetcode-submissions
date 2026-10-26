/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode answer = new ListNode(0);
        ListNode tail = answer;

        while (currentL1 != null || currentL2 != null) {
            int l1Val = currentL1 == null ? 0 : currentL1.val;
            int l2Val = currentL2 == null ? 0 : currentL2.val;
            int sum = l1Val + l2Val + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum -= 10;
            } else {
                carry = 0;
            }
            
            tail.next = new ListNode(sum);
            tail = tail.next;
            currentL1 = currentL1 == null ? null : currentL1.next;
            currentL2 = currentL2 == null ? null : currentL2.next;
        }

        if (carry > 0) tail.next = new ListNode(carry, null);

        return answer.next;
    }
}
