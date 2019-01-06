class Solution {
public:
    
    // this a clockwise rotation
    // Time: O(n^2)
    // Space: O(1)
    // First, reverse left to right
    // Second, swap the symmetry
    // 4ms, 79.26%
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if (n < 2) return;
        verticalFlip(matrix, n);
        diagonalFlip(matrix, n);
    }
    
    void verticalFlip(vector<vector<int>>& matrix, const int &n) {
        int mid = n / 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < mid; ++j) {
                swap(matrix[i][j], matrix[i][n - 1 - j]);
            }
        }
    }
    
    void diagonalFlip(vector<vector<int>>& matrix, const int &n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                swap(matrix[i][j], matrix[n - 1 - j][n - 1 - i]);
            }
        }
    }
};