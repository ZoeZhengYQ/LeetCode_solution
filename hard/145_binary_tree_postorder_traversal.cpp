/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// PostOrder: left, right, root
class Solution {
public:
    // recursive
    
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        postOrder(root, res);
        return res;
    }
    
    void postOrder(TreeNode* node, vector<int> &res) {
        if (node == NULL) return;
        
        postOrder(node -> left, res);
        postOrder(node -> right, res);
        res.push_back(node -> val);
    }
    
    
    // iterative 1
    // very concise and easy to change to preorder and inorder
    // using insert to traverse tree starting from the root node
    // like making the order be root->right->left and reverse the result
    /*
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == NULL) return res;
        
        TreeNode *tmp;
        stack<TreeNode*> todo;
        todo.push(root);
        
        while (!todo.empty()) {
            tmp = todo.top();
            todo.pop();
            
            res.insert(res.begin(), tmp -> val);
            // notice that left comes before right!
            if (tmp -> left) todo.push(tmp -> left);
            if (tmp -> right) todo.push(tmp -> right);
        }
        
        return res;
    }
    */
    
    // iterative 2
    // traverse directly using stack
    // Time: O(n)
    // Space: O(n)
    /*
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> todo;
        TreeNode *cur = root;
        TreeNode *prev = NULL;
        TreeNode *top = NULL;
        
        while (cur || !todo.empty()) {
            if (cur != NULL) {
                todo.push(cur);
                cur = cur -> left;
            }
            else {
                top = todo.top();
                if (top -> right != NULL && prev != top -> right) {
                    cur = top -> right;
                } 
                else {
                    res.push_back(top -> val);
                    todo.pop();
                    prev = top;
                }
            }
        }
        return res;
    }
    */
    
    // Morris traversal
    // Time: O(n)
    // Space: O(1)
    /*
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        TreeNode *dump = new TreeNode(0);
        dump -> left = root;
        TreeNode *cur = dump;
        
        while (cur != NULL) {
            if (cur -> left == NULL) {
                cur = cur -> right;
            }
            else {
                TreeNode *pre = cur -> left;
                while (pre -> right && pre -> right != cur) {
                    pre = pre -> right;
                }
                if (pre -> right == NULL) {
                    pre -> right = cur;
                    cur = cur -> left;
                } 
                else {
                    reverseAddNodes(cur -> left, pre, res);
                    pre -> right = NULL;
                    cur = cur -> right;
                }
            }
        }
        return res;
    }
    
private:
    void reverseAddNodes(TreeNode* start, TreeNode* end, vector<int>& nodes) {
        vector<int> tmp;
        TreeNode* node = start;
        while (true) {
            tmp.push_back(node -> val);
            if (node == end) {
                break;
            }
            node = node -> right;
        }
        reverse(tmp.begin(), tmp.end());
        nodes.insert(nodes.end(), tmp.begin(), tmp.end());
    }
    */
};