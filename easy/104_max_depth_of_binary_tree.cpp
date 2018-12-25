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
    // sol1
    // Time Complexity: O(n)
    // 8ms, 32.18%
    // Recursive
    // the findCurDepth function in sol2 could be replaced by maxDepth itself!!
    int maxDepth(TreeNode* root) {
        if (root == nullptr) { return 0; }
        else return 1 + max(maxDepth(root -> left), maxDepth(root -> right));
    }
    
    
    // sol2
    // Time Complexity: O(n)
    // 4ms, 98.89%
    /*
    int maxDepth(TreeNode* root) {
        if (root == nullptr) { return 0; }
        int maxDepth = 0, curDepth = 0;
        findCurDepth(root, maxDepth, curDepth);
        return maxDepth;
    }
    
    void findCurDepth(TreeNode *node, int &maxDepth, int curDepth) {
        if (node == nullptr) { return; }
        curDepth++;
        maxDepth = max(maxDepth, curDepth);
        findCurDepth(node -> left, maxDepth, curDepth);
        findCurDepth(node -> right, maxDepth, curDepth);
    }
    */
};