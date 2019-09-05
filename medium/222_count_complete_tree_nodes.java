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
    public int countNodes(TreeNode root) {
        int height = height(root);
        // Time: O(n)
        // return height == -1 ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
        return height < 0 ? 0 : 
            height(root.right) == height-1 ? 
                (1 << height) + countNodes(root.right) : 
                (1 << (height-1)) + countNodes(root.left);
    }
    // Iterative Solution
    // Time: O(height^2) -> O((log n)^2)
    // Space: O(1)
    /*
    public int countNodes(TreeNode root) {
        int res = 0;
        int heightL = height(root);
        while (root != null) {
            int heightR = height(root.right);
            if (heightR == heightL - 1) {
                res += 1 << heightL; // 2 ^ (heightL-1) - 1 + 1(the root node)
                root = root.right;
            } else {
                res += 1 << (heightL-1);
                root = root.left;
            } 
            heightL--;
        }
        return res;
    }
    */

    // one-node tree height is 0
    private int height(TreeNode node) {
        return node == null ? -1 : 1 + height(node.left);
    }
}