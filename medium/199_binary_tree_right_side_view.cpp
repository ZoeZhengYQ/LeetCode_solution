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
    // using an integer level to keep check if the rightmost element of this level is already found
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        findRightmost(root, 1, res);
        return res;
    }
    
    void findRightmost (TreeNode* node, int level, vector<int> &res) {
        if (node == NULL) return;
        if (level - res.size() == 1) {
            res.push_back(node -> val);
        }
        findRightmost(node -> right, level + 1, res);
        findRightmost(node -> left, level + 1, res);    
    }
};