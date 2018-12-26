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
    // remember to check if root exist!
    TreeNode* invertTree(TreeNode* root) {
        if (!root) { return nullptr; }
        std::swap(root -> left, root -> right);
        invertTree(root -> left);
        invertTree(root -> right);
        return root;
    }
    
    // Recursive solution
    // Time Complexity: O(n)
    // 4ms
    // could be neater using std::swap
    /*
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) { return root; }
        if (root -> left == nullptr && root -> right == nullptr) {
            return root;
        }
        TreeNode *tmp = nullptr;
        tmp = root -> left;
        root -> left = root -> right;
        root -> right = tmp;
        invertTree(root -> left);
        invertTree(root -> right);
        return root;
    }
    */
};