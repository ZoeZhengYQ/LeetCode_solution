/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        
        while (fast != null && fast.next != null) {
            // using fast and slow to find the middle of the list
            fast = fast.next.next;
            // reverse the first half of linked list
            ListNode slowNext = slow.next;
            slow.next = pre;
            pre = slow;
            slow = slowNext;
        }
        // so now pre is the head of reversed first half
        // while slow is the head of second half
        
        // linked list length is odd
        if (fast != null) {
            slow = slow.next;   
        }
        
        while (pre != null && slow != null) {
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}