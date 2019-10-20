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
    // Prefix sum!
    // Time: O(n)
    private Map<Integer, Integer> preCnt;
    public int pathSum(TreeNode root, int sum) {
        preCnt = new HashMap<>();
        preCnt.put(0, 1);
        return helper(root, 0, sum);
    }
    
    private int helper(TreeNode node, int curSum, int target) {
        if (node == null) return 0;
        curSum += node.val;
        
        int res = preCnt.getOrDefault(curSum-target, 0);
        preCnt.put(curSum, preCnt.getOrDefault(curSum, 0) + 1);
        res += helper(node.left, curSum, target) + helper(node.right, curSum, target);
        // 恢复原状，为了保证进行到node时，preCnt中的结果一定是只有node的prefix sum count
        preCnt.put(curSum, preCnt.get(curSum)-1);
        return res;
    }
    
    // Path sum 是里面所有的path都算，对于任意一个点来说，
    //  有从他出发的path，也有途径他的path，这些都要算上去
    // Time: O(n^2) (worse, no branching)
    //      O(nlogn) (balanced tree)
    /*
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 对于root只要算从他出发的点就好
        return startPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    // 从当前点算path的起点
    private int startPathSum(TreeNode node, int target) {
        if (node == null) return 0;
        int res = (node.val == target) ? 1 : 0;
        res += startPathSum(node.left, target-node.val) + startPathSum(node.right, target-node.val);
        return res;
    }
    */
}