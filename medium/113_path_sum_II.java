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
    // Time: O(n)
    private List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, 0, sum, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode node, int curSum, int target, List<Integer> list) {
        if (node == null) return;
        int sum = curSum + node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                // Remember to use a deep clone!
                res.add(new ArrayList<>(list));  
            }
            list.remove(list.size()-1);
            return;
        }
        helper(node.left, sum, target, list);
        helper(node.right, sum, target, list);
        // Remember to reset!
        list.remove(list.size()-1);
    }
}