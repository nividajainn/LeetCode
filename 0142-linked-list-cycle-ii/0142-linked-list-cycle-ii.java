/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
 // Now that we know there’s a cycle (slow == fast)we start a new pointer from head called start.
                ListNode start = head;
                while(start != slow){
//Move both start and slow one step at a time until they meet.
//They’ll meet at the starting node of the cycle.
                    start = start.next;
                    slow = slow.next;
                }
                 return start;
            }
        }
        return null;
    }
}