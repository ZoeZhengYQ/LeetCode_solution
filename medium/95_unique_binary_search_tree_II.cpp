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
    // DP solution w/ O(1) space
    // 1) The nth node is the new root, so newroot->left = oldroot;
    // 2) the nth node is not root, we traverse the old tree,
    //    every time the node in the old tree has a right child, we can perform: 
    //    old node->right = nth node, nth node ->left = right child; 
    //    and when we reach the end of the tree, don't forget we can also add the nth node here.
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return vector<TreeNode*> ();
        vector<TreeNode*> res(1, NULL);
        // traverse 1 to n
        for (int i = 1; i <= n; ++i) {
            vector<TreeNode*> tmp;
            // traverse every solution in previous case
            for (int j = 0; j < res.size(); ++j) {
                TreeNode* oldRoot = res[j];
                // case 1: node i be new root
                TreeNode* newRoot = new TreeNode(i);
                TreeNode* copy = cloneTree(oldRoot);
                newRoot->left = copy;
                tmp.push_back(newRoot);
                
                // case 2: node i be at the right subtree
                if (oldRoot) {
                    TreeNode* tmpOldRoot = oldRoot;
                    // traverse all right child
                    while (tmpOldRoot->right) {
                        TreeNode* notRoot = new TreeNode(i);
                        TreeNode* tmpOldRight = tmpOldRoot->right;
                        // make node i be the right child of current node
                        // and currentnode->right be left
                        tmpOldRoot->right = notRoot;
                        notRoot->left = tmpOldRight;
                        notRoot->right = NULL;
                        TreeNode* copy = cloneTree(oldRoot);
                        tmp.push_back(copy);
                        tmpOldRoot->right = tmpOldRight;
                        tmpOldRoot = tmpOldRoot->right;
                    }
                    // when current node be empty, node i could still be added
                    tmpOldRoot->right = new TreeNode(i);
                    TreeNode* copy = cloneTree(oldRoot);
                    tmp.push_back(copy);
                    tmpOldRoot->right = NULL;
                }
            }
            res = tmp;
        }
        return res;
    }
    
    TreeNode* cloneTree(TreeNode* root) {
        if (!root) return NULL;
        TreeNode *newRoot = new TreeNode(root->val);
        newRoot->left = cloneTree(root->left);
        newRoot->right = cloneTree(root->right);
        return newRoot;
    }
    
    // Divide & Conquer, recursion
    // 12ms, 98.97%
    // Time: nGn -> O(4^n / sqrt(n))
    // Space: same as Time
    /*
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return vector<TreeNode*> ();
        return mergeLeftRightTree(1, n);
    }
    
    vector<TreeNode*> mergeLeftRightTree(int start, int end) {
        vector<TreeNode*> res;
        // Empty subtree!
        if (start > end) 
            res.push_back(NULL);
        // Only one node in subtree
        if (start == end) 
            res.push_back(new TreeNode(start));
        // traverse all possible trees, and merge left and right subtree
        if (start < end) {
            for (int i = start; i <= end; ++i) {
                vector<TreeNode*> leftSubtree = mergeLeftRightTree(start, i - 1);
                vector<TreeNode*> rightSubtree = mergeLeftRightTree(i + 1, end);
                
                for (int j = 0; j < leftSubtree.size(); ++j) {
                    for (int k = 0; k < rightSubtree.size(); ++k) {
                        TreeNode* cur = new TreeNode(i);
                        cur->left = leftSubtree[j];
                        cur->right = rightSubtree[k];
                        res.push_back(cur);
                    }
                }
            }
        }
        return res;
    }
    */
};