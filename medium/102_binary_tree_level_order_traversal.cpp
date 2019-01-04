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
    // 4ms, 99%
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        vector<int> curLv;
        if (root == NULL) return res;
        
        // using the integer to indicate the end of each level
        int cnt = 1;
        TreeNode* tmp;
        queue<TreeNode*> todo;
        todo.push(root);
        while (!todo.empty()) {
            tmp = todo.front();
            todo.pop();
            curLv.push_back(tmp -> val);
            cnt--;
            
            // check left and right children
            if (tmp -> left != NULL) {
                todo.push(tmp -> left);
            }
            if (tmp -> right != NULL) {
                todo.push(tmp -> right);
            }
            
            // if comes to the end of a level
            // push_back and update cnt
            if (cnt == 0) {
                res.push_back(curLv);
                curLv.clear();
                cnt = todo.size();
            }
        }
        return res;
    }
};