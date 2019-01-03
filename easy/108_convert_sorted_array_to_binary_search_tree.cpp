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
    // reduce the number of times to "new" by using l and r!
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return subarrayToBST(nums, 0, nums.size() - 1);
    }
    
    TreeNode* subarrayToBST(const vector<int> &nums, int l, int r) {
        if (l > r) return NULL;
        int m = (l + r) / 2;
        TreeNode *root = new TreeNode(nums[m]);
        root -> left = subarrayToBST(nums, l, m - 1);
        root -> right = subarrayToBST(nums, m + 1, r);
        return root;
    }
};