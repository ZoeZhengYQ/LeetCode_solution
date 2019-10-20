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
    // DFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);
    }
    
    private boolean helper(TreeNode node, int curSum, int target) {
        if (node == null) { return false; }
        int sum = curSum + node.val;
        // Only return when the node have no child
        if (node.left == null && node.right == null) {
            return sum == target ? true : false;
        }
        return helper(node.left, sum, target) || helper(node.right, sum, target);
    }
}