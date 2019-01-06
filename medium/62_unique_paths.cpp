class Solution {
public:
    // DP solution
    // case 1: coming from up
    // case 2: coming from left
    // path[i][j] = path[i - 1][j] + path[i][j - 1]
    // Time: O(nm)
    // Sapce: O(m)
    // Memory reduce: O(nm) -> O(m)
    int uniquePaths(int m, int n) {
        if (m < n) return uniquePaths(n, m);    // make the first integer be the smaller one
        vector<int> cur(m, 1);
        for (int j = 1; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                cur[i] += cur[i - 1];
            }
        }
        return cur[m - 1];
    }
    
    
    // simple solution by calculating permutation
    // permutation: (m + n - 2)! / ((m - 1)! * (n - 1)!)
    /*
    int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 && n == 1) return 1;
        m--;
        n--;
        
        if (m < n) swap(m, n);  // making m the smaller one
        
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; ++i, ++j) {
            res *= i;
            res /= j;
        }
        return (int)res;
    } 
    */
    
    
    // recursive solution
    // takes too long time! TIME Limit Exceed
    /*
    int uniquePaths(int m, int n) {
        int cnt = 0;
        findPaths(m - 1, n - 1, cnt);
        return cnt;
    }
    
    void findPaths(int rightTimes, int downTimes, int &count) {
        if (rightTimes == 0 || downTimes == 0) { 
            count++;
            return; 
        }
        if (rightTimes > 0) {
            findPaths(rightTimes - 1, downTimes, count);
        }
        if (downTimes > 0) {
            findPaths(rightTimes, downTimes - 1, count);
        }
    }
    */
};