class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        if (numRows == 0) return vector<vector<int>> ();
        vector<vector<int>> res(numRows);
        
        for (int i = 0; i < numRows; ++i) {
            res[i].resize(i + 1);
            
            // notice that every row is symmetric
            res[i][0] = res[i][i] = 1;
            for (int j = 1; j <= i/2; ++j) {
                res[i][j] = res[i][i - j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        } 
        return res;
    }
};