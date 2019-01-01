/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// preorder: root, left, right

class Solution {
public:
    // iterative using stack!
    // Time: O(n)
    // Space: O(n)
    /*
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> pre;
        stack<TreeNode*> todo;
        TreeNode* curr = root;
        while(curr || !todo.empty()) {
            if(curr) {
                // push the root value first (different from Inorder Traversal)
                pre.push_back(curr -> val);
                todo.push(curr);
                curr = curr -> left;
            }
            else {
                curr = todo.top();
                todo.pop();
                curr = curr -> right;
            }
        }
        return pre;
    }
    */
    
    // recursive
    // Time: O(n)
    // Space: O(n)
    /*
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> pre;
        preOrder(root, pre);
        return pre;
        
    }
    
    void preOrder(TreeNode* node, vector<int> &result) {
        if (node == nullptr) return;
        result.push_back(node -> val);
        preOrder(node -> left, result);
        preOrder(node -> right, result);
    }
    */
    
    // Morris Traversal
    // Space: O(1)
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == NULL) return res;
        TreeNode* curr = root, *prev = NULL;
        while(curr) {
            if(curr -> left) {
                prev = curr -> left;
                // find Preorder predecessor
                while (prev -> right && prev -> right != curr) {
                    prev = prev -> right;
                }
                if (prev -> right) {
                    prev -> right = NULL;
                    curr = curr -> right;
                }
                else {
                    res.push_back(curr -> val);
                    prev -> right = curr;
                    curr = curr -> left;
                }
            }
            else {
                res.push_back(curr -> val);
                curr = curr -> right;
            }
        }
        return res;
    }
};