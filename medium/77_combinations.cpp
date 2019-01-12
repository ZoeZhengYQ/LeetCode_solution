class Solution {
public:
    // DFS recursive
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> com;
        findCombination(com, res, n, k, 1);
        return res;
    }
    
    void findCombination(vector<int> &com, vector<vector<int>> &res,  int n, int k, int cur) {
        if (com.size() == k) {
            res.push_back(com);
            return;
        }
        if (com.size() < k) {
            for (int i = cur; i <= n; ++i) {
                com.push_back(i);
                findCombination(com, res, n, k, i + 1);
                com.pop_back();
            }
        }
    }
};