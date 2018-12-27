/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// Inorder: left, root, right
// Preorder: root, left, right
// Postorder: left, right, root

class Solution {
public:
    vector<int> result;
    
    // Recursive
    // Time: O(n)
    // Space: O(n)
    
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        pushValue(root, result);
        return result;
    }
    
private:
    void pushValue(TreeNode* node, vector<int> &result) {
        if (node == NULL) return;
        pushValue(node -> left, result);
        result.push_back(node -> val);
        pushValue(node -> right, result);
        return;
    }
    
    
    /////////////////////////////////////////////////////
    // iterative solution using stack
    // Time: O(n)
    // Space: O(n)
    /*
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> todo;
        TreeNode *curr = root;
        while(curr || !todo.empty()) {
            // if current node exist, find its left child
            if (curr) {
                todo.push(curr);
                curr = curr -> left;
            }
            // if current node is NULL, refer to stack and find its parent
            else {
                curr = todo.top();
                todo.pop();
                result.push_back(curr -> val);
                curr = curr -> right;
            }
        }
        return result;
    }
    */
    
    /////////////////////////////////////////////////////
    // Morris Tree Traversal
    // without recursive, without stack!
    // Time: O(n)
    // Space: O(1)
    
    // Algorithm
    // current = root   
    // while current is NOT null
    //      if not exist current.left
    //          visit(current)
    //          current = current.right
    //      else
    //          predecessor = findPredecessor(current)
    //          if not exist predecessor.right
    //              predecessor.right = current
    //              current = current.left
    //          else
    //              predecessor.right = NULL
    //              visit(current)
    //              current = current.right
    
    /*
    vector<int> inorderTraversal(TreeNode* root) {
        TreeNode* cur = root;
        vector<int> nodes;
        while (cur) {
            if (cur -> left) {
                TreeNode* pre = cur -> left;
                while (pre -> right && (pre -> right != cur)) {
                    pre = pre -> right;
                }
                if (!(pre -> right)) {
                    pre -> right = cur;
                    cur = cur -> left;
                } else {
                    pre -> right = NULL;
                    nodes.push_back(cur -> val);
                    cur = cur -> right;
                }
            } else {
                nodes.push_back(cur -> val);
                cur = cur -> right;
            }
        }
        return nodes;
    }
    */   
};