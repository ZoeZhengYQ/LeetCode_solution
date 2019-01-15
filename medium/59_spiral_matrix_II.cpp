class Solution {
public:
    // another solution easier to understand
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res (n, vector<int> (n));
        int rStart = 0, rEnd = n - 1;
        int cStart = 0, cEnd = n - 1;
        int curVal = 1;
        
        while (curVal <= n * n) {
            for (int i = cStart; i <= cEnd; ++i) {
                res[rStart][i] = curVal++;
            }
            rStart++;
            for (int i = rStart; i <= rEnd; ++i) {
                res[i][cEnd] = curVal++;
            }
            cEnd--;
            for (int i = cEnd; i >= cStart; --i) {
                res[rEnd][i] = curVal++;
            }
            rEnd--;
            for (int i = rEnd; i >= rStart; --i) {
                res[i][cStart] = curVal++;
            }
            cStart++;
        }
        return res;
        
    }
    // using a curVal as a termination condition
    // i indicates current cycle being filled
    // using j as iterator
    /*
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int> (n));
        int curVal = 1;
        int i = 0, j = 0;
        while (curVal <= n * n) {
            j = i;
            // top left -> top right
            while (j < n - i) {
                res[i][j++] = curVal++;
            }
            j = i + 1;
            // top right -> bottom right
            while (j < n - i) {
                res[j++][n - i - 1] = curVal++;
            }
            j = n - i - 2;
            // bottom right -> bottom left
            while (j >= i) {
                res[n - i - 1][j--] = curVal++;
            }
            j = n - i - 2;
            // bottom left -> top left
            while (j > i) {
                res[j--][i] = curVal++;
            }
            i++;
        }
        return res;
    }
    */
};