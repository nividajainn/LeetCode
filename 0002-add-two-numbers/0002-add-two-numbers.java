class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node answer list banane ke liye
        ListNode dummy = new ListNode(0);

        // Current pointer answer list me move karega
        ListNode curr = dummy;

        int carry = 0;

        // Jab tak koi list bachi ho ya carry ho
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Agar l1 me node hai to uski value add karo
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Agar l2 me node hai to uski value add karo
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Naya carry nikalo
            carry = sum / 10;

            // Current digit answer list me add karo
            curr.next = new ListNode(sum % 10);

            // Aage badho
            curr = curr.next;
        }

        // Dummy ke baad wali list return karo
        return dummy.next;
    }
}