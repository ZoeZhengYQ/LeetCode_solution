/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// Inorder Traversal!
class BSTIterator {
private:
    stack<TreeNode*> st;
    
    void visitLeft(TreeNode* node) {
        TreeNode *tmp = node;
        while (node != NULL) {
            st.push(node);
            node = node -> left;
        }
    }
public: 
    BSTIterator(TreeNode* root) {
        visitLeft(root);
    }
    
    /** @return the next smallest number */
    int next() {
        TreeNode* top = st.top();
        st.pop();
        if (top -> right != NULL) {
            visitLeft(top -> right);
        }
        return top -> val;
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        if (st.empty()) return false;
        return true;
    }
    
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */