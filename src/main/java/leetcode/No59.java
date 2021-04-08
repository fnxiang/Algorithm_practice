package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int direction = 0, i=0, j=0, count=0, total = n*n;
        while (count != total){
            switch (direction%4){
                case 0:
                    for (int col=j;col<n;col++){
                        count++;
                        matrix[i][col] = count;
                        j=col;
                    }
                    n--;
                    i++;
                    direction++;
                    break;
                case 1:
                    for (int row=i;row<n;row++){
                        count++;
                        matrix[row][j] = count;
                        i=row;
                        count++;
                    }
                    n--;
                    j--;
                    direction++;
                    break;
                case 2:
                    for(int col=j;col>=i-n;col--){
                        count++;
                        matrix[i][col] = count;
                        j=col;

                    }
                    i--;
                    direction++;
                    break;

                case 3:
                    for(int row=i;row>=j+1;row--){
                        count++;
                        matrix[row][j] = count;
                        i=row;
                        count++;
                    }
                    j++;
                    direction++;
                    break;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        No54 obj = new No54();
        int[][] matrix = new int[3][3];
        int count = 1;
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                matrix[i][j]=count;
                count++;
            }
        }
        obj.spiralOrder(matrix);
    }
}
