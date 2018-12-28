class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        
        permutationRecursive(nums, result, 0);
        return result;
    }
    
private:
    void permutationRecursive(vector<int>& nums, vector<vector<int>> &result, int start) {
        if (start >= nums.size()) {
            // reach one possible instance
            result.push_back(nums);
            return;
        }
        
        for (int i = start; i < nums.size(); ++i) {
            swap(nums[start], nums[i]);
            // recursive
            // fix the elements from 0 to start+1
            permutationRecursive(nums, result, start + 1);
            swap(nums[start], nums[i]);     // backtrack
        }
    }
};