/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 2019-11-2
    // Recursion
    // Use merge two sorted list
    // And the idea of merge sort
    // Time: O(nlogk)
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }
    
    // Time: O(logk)
    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = start + (end-start)/2;
        ListNode l1 = partition(lists, start, mid);
        ListNode l2 = partition(lists, mid+1, end);
        return mergeTwoSortedList(l1, l2);
    }
    
    // Time: O(n)
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedList(l1.next, l2);
            return l1;
        } 
        l2.next = mergeTwoSortedList(l1, l2.next);
        return l2;
    }

    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // Min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null) {
                pq.offer(top.next);
            }
            cur.next = top;
            cur = cur.next;
        }
        return dummy.next;
    }
    */

    /*
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
    */
}