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
    // Use a map to record elements' index
    // Key idea:
    // Preorder traversing implies that PRE[0] is the root node.
    // Then we can find this PRE[0] in IN, say it's IN[5].
    // Now we know that IN[5] is root, 
    // so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    // Recursively doing this on subarrays, we can build a tree out of it :)
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        int val = preorder[pStart];
        int idx = map.get(val);
        TreeNode root = new TreeNode(val);
        
        int left = idx - iStart;
        root.left = helper(preorder, pStart+1, pStart+left, inorder, iStart, idx-1);
        root.right = helper(preorder, pStart+left+1, pEnd, inorder, idx+1, iEnd);
        return root;
    }
}