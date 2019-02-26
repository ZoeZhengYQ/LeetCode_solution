/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursion
class Solution {
    // path could go up, but once go down
    // it would never go up
    private int maxValue = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        
        maxValue = Math.max(maxValue, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}