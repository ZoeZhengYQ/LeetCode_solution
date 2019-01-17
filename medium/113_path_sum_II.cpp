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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> res;
        if (!root) return res;
        vector<int> path;
        findPathWithSum(root, sum, res, path);
        return res;
    }
    
    void findPathWithSum(TreeNode* node, int sum, vector<vector<int>> &res, vector<int> &path) {
        path.push_back(node -> val);
        if (!node->left && !node->right && node->val == sum) {
            res.push_back(path);
        }
        // the key is to deduct node->val from sum!!
        if (node->left) 
            findPathWithSum(node->left, sum - node->val, res, path);
        if (node->right)
            findPathWithSum(node->right, sum - node->val, res, path);
        path.pop_back();
    }
};