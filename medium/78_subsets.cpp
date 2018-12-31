class Solution {
public:
    // Time: O(2^n)
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> solution;
        vector<vector<int>> result;
        findSubsets(result, solution, nums, 0);
        return result;
    }
    
    void findSubsets(vector<vector<int>> &res, vector<int> sol, const vector<int> &nums, int idx) {
        res.push_back(sol);
        for (int i = idx; i < nums.size(); ++i) {
            sol.push_back(nums[i]);
            findSubsets(res, sol, nums, i + 1); // attention! not idx + 1!
            sol.pop_back();
        }
    }
    
    // DFS recursive
    /*
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> solution;
        vector<vector<int>> result;
        findSubsets(result, solution, nums, 0);
        return result;
    }
    
    void findSubsets(vector<vector<int>> &res, vector<int> &sol, const vector<int> &nums, int idx) {
        if(idx == nums.size()) {
            res.push_back(sol);
            return;
        }
        
        findSubsets(res, sol, nums, idx + 1);
        sol.push_back(nums[idx]);
        findSubsets(res, sol, nums, idx + 1);
        sol.pop_back();
    }
    */
};