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
    // 用哈希表来建立所有的前缀路径之和跟其个数之间的映射，然后看子路径之和有没有等于给定值的
    // using unordered map to avoid redundant calculation!
    // 12ms, 98.25%
    int pathSum(TreeNode* root, int sum) {
        unordered_map<int, int> store;
        store[0] = 1;
        return help(root, 0, sum, store);
    }
    
    int help(TreeNode* node, int curSum, int target, unordered_map<int, int> &store) {
        if (!node) return 0;
        // update current sum
        curSum += node->val;
        
        // all we need is curSum - target = oldSum!!
        // for example, sum = 8, curSum = 18, if there is previous path that sums to 10,
        // then we have a solution!!
        int res = store[curSum - target];
        // update map
        store[curSum]++;
        
        // traverse left and right child
        res += help(node->left, curSum, target, store) + help(node->right, curSum, target, store);
        
        // 模板，因为是引用，所以需要修改回去！！
        store[curSum]--;
        return res;
    }
    
    
    // using two recursion to traverse all path!
    /*
    int pathSum(TreeNode* root, int sum) {
        if (!root) return 0;
        return findPaths(root, sum, 0) + pathSum(root->left, sum) + pathSum(root->right, sum);
    }
    
    int findPaths(TreeNode* node, int target, int prev) {
        if (!node) return 0;
        int cur = prev + node->val;
        return (cur == target) + findPaths(node->left, target, cur) + findPaths(node->right, target, cur);
    }
    */
};