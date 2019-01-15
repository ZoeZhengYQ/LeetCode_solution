class Solution {
public:
    // for every point, there are 2 cases:
    // 1 move from upper point
    // 2 move from left point
    // for any point: OPT(i, j) = min(OPT(i - 1, j), OPT(i, j - 1)) + weight(i, j)
    
    // solution with O(1) space, modifying the original grid only
    int minPathSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        for (int i = 1; i < col; ++i) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < row; ++j) {
            grid[j][0] += grid[j - 1][0];
        }
        for (int j = 1; j < row; ++j) {
            for (int i = 1; i < col; ++i) {
                grid[j][i] += min(grid[j - 1][i], grid[j][i - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
    // solution with space O(mn)
    /*
    int minPathSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<int>> dp(row, vector<int> (col, grid[0][0]));
        
        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < row; ++j) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int j = 1; j < row; ++j) {
            for (int i = 1; i < col; ++i) {
                dp[j][i] = min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        // for (auto a : dp) {
        //     for (auto b : a) {
        //         cout << b << " ";
        //     }
        //     cout << endl;
        // }
        return dp[row - 1][col - 1];
    } 
    */
};