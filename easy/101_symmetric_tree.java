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
    // recursive solution
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
        
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    
    
    // non-recursive solution
    /*
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> todo = new Stack<TreeNode> ();
        todo.push(root.left);
        todo.push(root.right);
        
        while (!todo.empty()) {
            TreeNode right = todo.pop();
            TreeNode left = todo.pop();
            // if both are null, continue because we got nothing to push
            if (left == null && right == null) continue;
            
            if (left == null || right == null || left.val != right.val) 
                return false;
            
            // push only when both are not null
            todo.push(left.left);
            todo.push(right.right);
            todo.push(left.right);
            todo.push(right.left);
        }
        return true;
    }
    */
}