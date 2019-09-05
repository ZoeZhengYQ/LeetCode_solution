/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Inorder tree traversal
// Using stack
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        goLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curNode = st.pop();
        goLeft(curNode.right);
        return curNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void goLeft(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */