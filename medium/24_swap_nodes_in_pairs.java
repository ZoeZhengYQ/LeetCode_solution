/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    // Iterative solution
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode prev = cur.next;
            ListNode last = cur.next.next;
            
            cur.next = last;
            prev.next = last.next;
            last.next = prev;
            
            cur = cur.next.next;
        }
        return dummy.next;
    }
    
    
    // recursive solution
    /*
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ptr = head.next;
        head.next = swapPairs(ptr.next);
        ptr.next = head;
        
        return ptr;
    }
    */
}
