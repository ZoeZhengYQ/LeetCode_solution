/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        
        // 如果有right
        if (x.right != null) {
            Node cur = x;
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        
        // 如果没有right
        else {
            if (x.parent != null) {
                Node cur = x.parent;
                Node pre = x;
                // 注意验证cur == null！
                while (cur != null && cur.left != pre) {
                    pre = cur;
                    cur = cur.parent;
                }
                return cur;
            }
            return null;
        }
    }
    
}