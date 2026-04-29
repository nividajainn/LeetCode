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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;          // 1st node
        ListNode even = head.next;    // 2nd node
        ListNode evenHead = even;     // store even start

        while (even != null && even.next != null) {
            odd.next = even.next;     // link odd
            odd = odd.next;

            even.next = odd.next;     // link even
            even = even.next;
        }

        odd.next = evenHead;          // connect odd + even
        return head;
    }
}