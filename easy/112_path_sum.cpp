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
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root) { return false; }
        bool flg = false;
        findPath(root, sum, flg);
        return flg;
    }
    
    void findPath(TreeNode* node, int sum, bool &flg) {
        if (!node->left && !node->right && sum == node-> val) {
            flg = true;
        } 
        if (node->left) { findPath(node->left, sum - node->val, flg); }
        if (node->right) { findPath(node->right, sum - node->val, flg); }
        
    }
};