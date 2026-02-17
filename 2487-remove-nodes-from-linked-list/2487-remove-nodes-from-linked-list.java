class Solution {
    public ListNode removeNodes(ListNode head) {

        head = reverse(head);

        int maxVal = head.val;
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.next.val < maxVal) {
                curr.next = curr.next.next; // remove node
            } else {
                curr = curr.next;
                maxVal = curr.val;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
