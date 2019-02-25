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
    // recursion
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        // 如果当前value小于等于p的
        // 那么只能是在右半边
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        // 如果不是的话，找左边看看，如果null就只能返回刚刚向右的那个
        else {
            TreeNode tmp = inorderSuccessor(root.left, p);
            return (tmp == null) ? root : tmp;
        }
    }
    
    /*
    // precessor
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        if (p.val <= root.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode tmp = inorderPredecessor(root.right, p);
            return (tmp == null) ? root : tmp;
        }
    }
    */
    
    // iterative solution
    /*
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        // 如果有right的话，successor肯定在右边
        if (p.right != null) {
            TreeNode tmp = p.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        }
        
        // 如果没有right，successor就是parent
        TreeNode cur = root;
        TreeNode succ = null;
        while (cur.val != p.val) {
            while (cur.val > p.val) {
                succ = cur;
                cur = cur.left;
            }
            if (cur.val < p.val && cur.right != null) 
                cur = cur.right;
        }
        return succ;
    }
    */
}