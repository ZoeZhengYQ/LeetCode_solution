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
    // recursive solution
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if (!root) return res;
        findPath(root, res, to_string(root->val));
        return res;
    }
    // 和之前的recursive有点不同，因为现在是leaf才要pushback，所以判断条件是判断是否为leaf
    // 同时，不是leaf的时候，还要判断左右child是否存在！
    void findPath(TreeNode* node, vector<string> &res, string str) {
        if (!node->left && !node->right) {
            res.push_back(str);
            return;
        }
        if (node->left) findPath(node->left, res, str + "->" + to_string(node->left->val));
        if (node->right) findPath(node->right, res, str + "->" + to_string(node->right->val));
    }
    
};