/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    
    // might have a better solution to deal with next and random at the same time
    // Time: O(2n)
    private Map<Integer, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        // 1st round, copy the linked list
        Node dummy = new Node (0, null, null);
        Node cur = head;
        Node ptr = dummy;
        while (cur != null) {
            ptr.next = new Node(cur.val, null, null);
            map.put(cur.val, ptr.next);
            ptr = ptr.next;
            cur = cur.next;
        }
        
        // 2nd round, point random
        cur = head;
        ptr = dummy.next;
        
        while (cur != null) {
            // remember to check if cur.random is null!!
            if (cur.random != null) {
                ptr.random = map.get(cur.random.val);
            }
            cur = cur.next;
            ptr = ptr.next;
        }
        
        return dummy.next;
    }
}