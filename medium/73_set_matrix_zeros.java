class Solution {
    private int row;
    private int col;
    private boolean firstRow;
    private boolean firstCol;
    
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return;
        row = matrix.length;
        col = matrix[0].length;
        firstRow = false;
        firstCol = false;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }   
        
        // System.out.println("1stRow: " + firstRow + ", 1stCol: " + firstCol);
        // for (int i = 0; i < row; ++i) {
        //     for (int j = 0; j < col; ++j) {
        //             System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println("");
        // }   
        
        
        // Remember to avoid making changes to the first Row and Col
        // the 1st row and col are just used to store!
        // so we start from 1
        for (int i = 1; i < row; ++i) {
            // System.out.println("Set Row to 0: " + i);
            if (matrix[i][0] == 0) setRowZero(matrix, i);
        }
        
        // again, start from 1
        for (int j = 1; j < col; ++j) {
            // System.out.println("Set Col to 0: " + j);
            if (matrix[0][j] == 0) setColZero(matrix, j);
        }
        
        if (firstRow == true) setRowZero(matrix, 0);
        if (firstCol== true) setColZero(matrix, 0);
    }
    
    private void setRowZero(int[][] matrix, int rowIdx) {
        // start from 1
        for (int j = 1; j < col; ++j) {
            matrix[rowIdx][j] = 0;
        }
    }
    
    private void setColZero(int[][] matrix, int colIdx) {
        // start from 1
        for (int i = 1; i < row; ++i) {
            matrix[i][colIdx] = 0;
        }
    }
}