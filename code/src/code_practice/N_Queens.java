package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);
        return results;
    }
    private static void search(List<List<String>> results,
                               List<Integer> cols,
                               int n) {
        if (cols.size() == n) {
            results.add(draw(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    private static boolean isValid(List<Integer> cols, int column){
        int row = cols.size();
        for (int rIndex = 0;rIndex<cols.size();rIndex++){
            if (cols.get(rIndex) == column){
                return false;
            }
            if (rIndex + cols.get(rIndex) == row+column) {
                return false;
            }
            if (rIndex - cols.get(rIndex) == row-column) {
                return false;
            }
        }
        return true;
    }

    private static List<String> draw(List<Integer> cols){
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    @Test
    public static void main(String[] args){
        List<List<String>> res = solveNQueens(5);
        System.out.println(res.size());
        for (List<String> s:res
             ) {
            System.out.println(s);
        }
    }

}
