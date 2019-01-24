/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int cnt = 0;
        // 找到第k+1个元素
        while (curr != null && cnt != k) {
            curr = curr.next;
            cnt++;
        }
            
        // 如果第k+1个元素存在
        if (cnt == k) {
            // 先reverse后面的k个，即curr开始的k个
            curr = reverseKGroup(curr, k);
            // 再reverse前面k个
            while (cnt-- > 0) {
                ListNode last = head.next;
                head.next = curr;
                curr = head;
                head = last;
            }
            head = curr;
        }
        // 注意这里返回的是head
        // 因为即使后面不足k个，head依然保留了后面几位的头指针，需要连接上
        return head;
    }
}