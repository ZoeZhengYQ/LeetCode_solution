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
    // Same idea for preorder & inorder
    // Only difference is that in postorder, the last element is the root
    // Use map to map value and idx in inorder to keep track of how many element needed for left subtree
    private Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
    }
    
    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return null;
        
        int val = postorder[pEnd];
        int idx = map.get(val);
        int left = idx-iStart;
        
        TreeNode root = new TreeNode(val);
        root.left = helper(inorder, iStart, iStart+left-1, postorder, pStart, pStart+left-1);
        root.right = helper(inorder, iStart+left+1, iEnd, postorder, pStart+left, pEnd-1);
        return root;
    }
}