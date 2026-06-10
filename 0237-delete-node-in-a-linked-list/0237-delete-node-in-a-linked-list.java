/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        /*1.Next node ki value current node me copy karo.
          2. Next node ko skip kar do. */
        node.val = node.next.val;
        node.next = node.next.next;  
    }
}