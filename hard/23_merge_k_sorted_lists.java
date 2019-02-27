/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // PriorityQueue
    // k is the number of list
    // n is the average length of lists
    // Time: 
    // PriorityQueue find min: O(logk)
    // for every node we perform a find min
    // Time should be O(n k logk)
    // if use merge sort, is also O(nk logk)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        int len = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            // min-heap
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        for (ListNode node : lists) {
            if (node != null) 
                pq.offer(node);
        }
        
        while (!pq.isEmpty()) {
            ListNode todo = pq.poll();
            cur.next = todo;
            cur = cur.next;
            if (cur.next != null) 
                pq.offer(cur.next);
        }
        
        return dummy.next;
    }
}