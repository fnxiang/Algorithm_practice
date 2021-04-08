package leetcode;

import java.util.HashSet;

public class No73 {

    /**
     * 思路：1、先找出矩阵中0的位置（一定要先全找到，再考虑置零）考虑用两个set分别记录含0的行和列
    * */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> row_set = new HashSet<>();
        HashSet<Integer> col_set = new HashSet<>();
        for (int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row_set.add(i);
                    col_set.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row_set.contains(i)||col_set.contains(j)){
                    matrix[i][j]=0;
                }
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j]=1;
            }
        }

        No73 obj = new No73();
        obj.setZeroes(matrix);
    }
}
