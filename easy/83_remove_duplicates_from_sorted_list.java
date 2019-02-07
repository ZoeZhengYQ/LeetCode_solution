class Solution {
    // Iterative
    /*
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head;
        
        while (prev != null) {
            while (cur != null && cur.val == prev.val) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
    */

    // recursive solution
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val? head.next : head;
    }

}