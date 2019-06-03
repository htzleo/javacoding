package code_practice;

import org.junit.Test;

public class Maximum_Submatrix {
    int row_number,col_number;
    public int maxSubmatrix(int[][] matrix) {
        // write your code here

        /// parameter
        row_number = matrix.length;
        col_number = matrix[0].length;
        int[][] prefixColSum = getPrefixColSum(matrix);
        ///enum col as a number

        int max = Integer.MIN_VALUE;
        for (int up = 0; up < row_number; up++) {
            for (int down = up; down < row_number; down++) {
                int[] arr = compression(matrix, up, down, prefixColSum);
                max = Math.max(max, maxSubarray(arr));
            }
        }

        return max;
    }
    private int maxSubarray(int[] arry){
        int min = 0;
        int presum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arry.length; i++) {
            presum += arry[i];
            maxsum = Math.max(maxsum, presum - min);
            min = Math.min(min,presum);
        }
        return maxsum;
    }
    private int[] compression(int[][] matrix, int up, int down, int[][] prefixcolumn){
        int[] arr = new int[col_number];
        for (int i = 0;i<col_number;i++){
            arr[i] = prefixcolumn[down+1][i]-prefixcolumn[up][i];
        }
        return arr;
    }

    private int[][] getPrefixColSum(int[][] matrix){
        int[][] sum = new int[row_number+1][col_number];
        for (int i = 0; i < row_number; i++) {
            for (int j = 0; j < col_number; j++) {
                sum[i + 1][j] = sum[i][j] + matrix[i][j];
            }
        }

        return sum;
    }

    @Test
    public void test(){
        int[][] m = {{1,2},{3,4},{5,6}};
        System.out.println(m.length);
        System.out.println(m[0].length);
        System.out.println(m[0][1]);
    }
}
