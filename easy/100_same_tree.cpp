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
    // recursive!
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // if one of current node don't exist
        if (p == NULL || q == NULL) return p == q;
        // else check values of current node and check both children
        return (p -> val == q -> val && isSameTree(p -> left, q -> left) && isSameTree(p -> right, q -> right));
    }
};