/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // BFS + Stack to achieve zigzag
    // Time: O(n)
    // Space: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; 
        
        boolean reverse = true; // 当前level的下一个level是否reverse
        Queue<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        list.add(root);
        
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = list.poll();
                st.push(cur);
                level.add(cur.val);
            }
            res.add(level);
            while (!st.isEmpty()) {
                TreeNode head = st.pop();
                if (!reverse) { // left - right
                    if (head.left != null) list.add(head.left);
                    if (head.right != null) list.add(head.right);
                } else {
                    if (head.right != null) list.add(head.right);
                    if (head.left != null) list.add(head.left);
                }
            } 
            
            reverse = !reverse;
        }
        return res;
    }
}