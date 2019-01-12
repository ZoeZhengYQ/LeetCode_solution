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
    // a solution w/o using std::reverse
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        int d = depth(root);
        vector<vector<int>> res (d, vector<int> {});
        levelOrder(res, root, d - 1);
        return res;
    }
    
    // remember how to find out depth of a binary tree!!
    int depth(TreeNode* node) {
        if (!node) return 0;
        return max(depth(node -> left), depth(node -> right)) + 1;
    }
    
    void levelOrder(vector<vector<int>> &res, TreeNode* node, int level) {
        if (!node) return;
        res[level].push_back(node -> val);
        levelOrder(res, node -> left, level - 1);
        levelOrder(res, node -> right, level - 1);
    }
    
    // a neat solution using reverse
    /*
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        levelOrder(res,root,0);
        reverse(res.begin(), res.end());
        return res;
    }
    
    void levelOrder(vector<vector<int>> &res, TreeNode *node, int level) {
        if (!node) return;
        if (level == res.size())
            res.push_back({});
        res[level].push_back(node->val);
        levelOrder(ans,node->left,level+1);
        levelOrder(ans,node->right,level+1);
    }
    */
    
    // reverse the result of binary tree level order traversal using std::reverse
    /*
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<int> curLV;
        vector<vector<int>> res;
        
        if (root == NULL) return res;
        
        queue<TreeNode*> todo;
        todo.push(root);
        
        int cnt = 1;
        
        while (!todo.empty()) {
            TreeNode *tmp = todo.front();
            todo.pop();
            curLV.push_back(tmp -> val);
            cnt--;
            
            if (tmp -> left) {
                todo.push(tmp -> left);
            }
            if (tmp -> right) {
                todo.push(tmp -> right);
            }
            
            if (cnt == 0) {
                res.push_back(curLV);
                curLV.clear();
                cnt = todo.size();
            }
        }
        
        reverse(res.begin(), res.end());
        
        return res;
    }
    */
};