class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int col = matrix[0].length, row = matrix.length;
        int x = 0, y = col-1;
        while (x < row && y >= 0) {
            if (target == matrix[x][y]) return true;
            else if (target < matrix[x][y]) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}