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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Dummy node banaya taaki head delete karna bhi easy ho jaye
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
        
        // Fast aur Slow dono dummy se start karenge
        ListNode fast = dummy; 
        ListNode slow = dummy; 
        
        // Fast ko n steps aage le jao
        // Isse fast aur slow ke beech n nodes ka gap ban jayega
        for(int i=0; i<n; i++){ 
            fast = fast.next;
        }
        
        // Ab dono pointers ko saath move karo
        // Jab fast last node par pahunch jayega,
        // tab slow delete hone wali node ke just pehle hoga
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // Nth node from end ko skip karke delete kar do
        slow.next = slow.next.next;

        // Dummy ke baad wali list return karo
        return dummy.next;
    }
}