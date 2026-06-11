class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Check karo k nodes present hain ya nahi
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Sirf tab reverse karo jab exactly k nodes mil gaye
        if (count == k) {

            ListNode prev = reverseKGroup(curr, k);
            curr = head;

            while (count-- > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }

        // k se kam nodes bache hain
        return head;
    }
}