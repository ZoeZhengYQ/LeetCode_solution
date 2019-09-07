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
    // Iterative solution using stack
    // Time: O(n)
    // Space: O(n)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode curNode = new TreeNode(nums[i]);
            // Move all the smaller node to the current left tree
            while (!st.isEmpty() && st.peek().val < curNode.val) {
                curNode.left = st.pop();
            }
            // If there's a larger node
            if (!st.isEmpty()) {
                st.peek().right = curNode;
            }
            st.push(curNode);
        }
        // TreeNode res = null;
        // while (!st.isEmpty()) {
        //     res = st.pop();
        // }
        // return res;
        return st.firstElement();
    }
}