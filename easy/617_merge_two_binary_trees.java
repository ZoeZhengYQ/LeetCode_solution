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
    // Another Iterative Preorder
    // Time: O(min(n1, n2))
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        Stack<TreeNode[]> todo = new Stack<>();
        todo.push(new TreeNode[]{t1, t2});
        while (!todo.isEmpty()) {
            TreeNode[] pair = todo.pop();
            if (pair[1] == null) {
                continue;
            }
            pair[0].val += pair[1].val;
            // 因为是空的所以指过去之后就不用管后面的了
            // Traversal以t1为中心
            if (pair[0].right == null) {
                pair[0].right = pair[1].right;
            } else {
                todo.push(new TreeNode[]{pair[0].right, pair[1].right});
            }
            if (pair[0].left == null) {
                pair[0].left = pair[1].left;
            } else {
                todo.push(new TreeNode[]{pair[0].left, pair[1].left});
            }
        }
        return t1;
    }
    
    // Recursive
    /*
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        
        return newNode;
    }
    */
    
    // Iterative Preorder Tree Traversal w/ stack
    // Time: O(max(n1, n2))
    // 6ms, 5.69%
    // Space: O(1)
    // 40.6MB, 100%
    /*
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        Stack<TreeNode[]> todo = new Stack<>();
        todo.push(new TreeNode[]{t1, t2});
        while (!todo.isEmpty()) {
            TreeNode[] pair = todo.pop();
            // merge value
            pair[0].val += (pair[1] == null) ? 0 : pair[1].val;
            
            if (pair[1] != null) {
                if (pair[0].right == null && pair[1].right != null) {
                    pair[0].right = new TreeNode(0);
                    todo.push(new TreeNode[]{pair[0].right, pair[1].right});
                } else if (pair[0].right != null) {
                    todo.push(new TreeNode[]{pair[0].right, pair[1].right});
                }   
                
                if (pair[0].left == null && pair[1].left != null) {
                    pair[0].left = new TreeNode(0);
                    todo.push(new TreeNode[]{pair[0].left, pair[1].left});
                } else if (pair[0].left != null) {
                    todo.push(new TreeNode[]{pair[0].left, pair[1].left});
                }
            } else {
                if (pair[0].right != null) {
                    todo.push(new TreeNode[]{pair[0].right, null});
                }
                
                if (pair[0].left != null) {
                    todo.push(new TreeNode[]{pair[0].left, null});
                }
            }
        }
        return t1;
    }
    */
}