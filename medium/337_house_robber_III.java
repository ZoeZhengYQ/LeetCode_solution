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
    // DP
    // 之前都是底层返回一个已经用max选择过的结果，但是我们其实可以分开两种情况
    // child node robbed & not robbed，两种情况结果都返回，交给上一层处理
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(TreeNode node) {
        // res[0] not robbed, res[1] robbed
        int[] res = new int[2];
        if (node == null) return res;
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        // 切记就算不rob当前，child也有可能是rob和不rob两种情况，所以要用max
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = node.val + left[0] + right[0];
        
        res[0] = notRob;
        res[1] = rob;
        return res;
    }
    
    
    // DFS w/ memo
    // Time: O(n)
    /*
    private Map<TreeNode, Integer> memo;
    public int rob(TreeNode root) {
        if (root == null) return 0;
        memo = new HashMap<>();
        return helper(root);
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        
        if (memo.containsKey(node)) return memo.get(node);
        
        int sum = 0;
        if (node.left != null) {
            sum += helper(node.left.left) + helper(node.left.right);
        }
        if (node.right != null) {
            sum += helper(node.right.left) + helper(node.right.right);
        }
        int res = Math.max(sum + node.val, helper(node.left) + helper(node.right));
        memo.put(node, res);
        return res;
    }
    */
    
}