class Solution {
public:
    // DFS recursive
    // transverse all possible combination to find solution
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> result;
        vector<int> solution;
        
        combination(result, solution, k, n, 1);
        return result;
    }
    
    void combination(vector<vector<int>> &result, vector<int> &solution, int k, int n, int start) {
        if(solution.size() == k && n == 0) { 
            result.push_back(solution); 
            return;
        }
        if (solution.size() < k) {
            for (int i = start; i <= 9; ++i) {
                solution.push_back(i);
                combination(result, solution, k, n - i, i + 1);
                solution.pop_back();
            }
        }
    }
};