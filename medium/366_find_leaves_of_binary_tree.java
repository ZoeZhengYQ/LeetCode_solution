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
    // the height of leaves is 0
    // calculating height backwards
    // h(node) = 1 + MAX(h(node.left), h(node.right))
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        int h = calculateHeight(root, result);
        return result;
    }
    
    private int calculateHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int level = 1 + Math.max(calculateHeight(node.left, res), 
                                 calculateHeight(node.right, res));
        if (res.size() < level + 1) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}