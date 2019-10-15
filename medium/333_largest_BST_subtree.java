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
    // Pre order traversal
    // Record both lower and upper value of subtree
    // Time: O(n)
    // Space: O(1)
    // Mind extreme value like [Integer.MIN_VALUE]
    class Result {
        long size;
        long lower;
        long upper;
        
        Result(long size, long lower, long upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    private long maxSize = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return (int)maxSize;
    }
    
    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE + 1l, Integer. MIN_VALUE - 1l);
        }
        Result left = helper(node.left);
        Result right = helper(node.right);
        
        if (left.size == -1 || right.size == -1 || left.upper >= node.val || right.lower <= node.val) {
            return new Result(-1, 0, 0);
        }
        
        long size = 1 + left.size + right.size;
        long lower = Math.min(left.lower, node.val); // Need this because we set MAX and MIN for null node
        long upper = Math.max(right.upper, node.val);
        maxSize = Math.max(maxSize, size);
        return new Result(size, lower, upper);
        
    }
}