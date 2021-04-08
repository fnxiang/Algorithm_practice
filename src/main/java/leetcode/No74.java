package leetcode;

import java.util.LinkedList;
import java.util.List;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row_index = -1;
        if(target<matrix[0][0]||target>matrix[m][n]) return false;
        for (int i = 0; i < m; i++) {
            if(target<matrix[i][n-1]){
                row_index=i;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if(matrix[row_index][n]==target) return true;
        }
        return false;
    }
}
