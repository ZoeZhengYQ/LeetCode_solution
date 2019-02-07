/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // When there are chances that the head node would be change
        // we need to create a dummy node that points to orginal head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // if current value only appear once
            if (prev.next == cur) {
                prev = cur;
            } else {    // we skip current value;
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        
        return dummy.next;
        
    }
}