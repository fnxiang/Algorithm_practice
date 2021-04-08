package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans_list = new ArrayList<>();
        int m = matrix.length;
        if(m<1) return ans_list;
        int n = matrix[0].length;
        int o_n=n, o_m=m;
        int direction = 0, i=0, j=0, count=0, total = n*m;
        while (count != total){
            switch (direction%4){
                case 0:
                    for (int col=j;col<n;col++){
                        ans_list.add(matrix[i][col]);
                        j=col;
                        count++;
                    }
                    n--;
                    i++;
                    direction++;
                    break;
                case 1:
                    for (int row=i;row<m;row++){
                        ans_list.add(matrix[row][j]);
                        i=row;
                        count++;
                    }
                    m--;
                    j--;
                    direction++;
                    break;
                case 2:
                    for(int col=j;col>=o_m-m-1;col--){
                        ans_list.add(matrix[i][col]);
                        j=col;
                        count++;
                    }
                    i--;
                    direction++;
                    break;

                case 3:
                    for(int row=i;row>=o_n-n;row--){
                        ans_list.add(matrix[row][j]);
                        i=row;
                        count++;
                    }
                    j++;
                    direction++;
                    break;
            }
        }
        return ans_list;
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
