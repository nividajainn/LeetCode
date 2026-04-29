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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

         ListNode prev = null;
 //prev ko null se start karte hain, yeh reverse list ka pehla node banega.
         ListNode temp = head;
 //temp ek temporary pointer hai jo abhi head pe set hai.
         while (temp != null){
            temp = head.next; 
    // Pehle next node ko store kar lo temp mein
            head.next = prev;
    // Ab current node (head) ka next pointer ko prev pe point karwa do — yaani link ko reverse kar do. 
            prev = head; 
    // prev ko ab current node bana do.
            head = temp;
    // head ko aage le jao — next node pe       
         }
           return prev;
    }
}