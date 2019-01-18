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
    // using two recursion to traverse all path!
    int pathSum(TreeNode* root, int sum) {
        if (!root) return 0;
        return findPaths(root, sum, 0) + pathSum(root->left, sum) + pathSum(root->right, sum);
    }
    
    int findPaths(TreeNode* node, int target, int prev) {
        if (!node) return 0;
        int cur = prev + node->val;
        return (cur == target) + findPaths(node->left, target, cur) + findPaths(node->right, target, cur);
    }
};