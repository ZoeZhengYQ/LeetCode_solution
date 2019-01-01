/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    // use ? : to make statement simplifier
    int kthSmallest(TreeNode* root, int k) {
        return find(root, k);
    }
    
    int find(TreeNode* root, int& k) {
        if (root) {
            int x = find(root->left, k);
            return !k ? x : !--k ? root->val : find(root->right, k);
        }
        return 0;
    }   
    
    
    // inorder tree traversal
    /*
    int kthSmallest(TreeNode* root, int k) {
        int result;
        inOrder(root, k, result);
        return result;
    }
    
    void inOrder(TreeNode* node, int &k, int &element) {
        if (k == 0 || node == nullptr) return;
        inOrder(node -> left, k, element);
        k--;
        if (k == 0) {
            element = node -> val;
        }
        inOrder(node -> right, k, element);
    }
    */
};