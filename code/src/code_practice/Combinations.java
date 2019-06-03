package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

            helper(1,n,k,cur,res);

        return res;
    }
    public static void helper (int startIndex, int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if ( cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = startIndex; j <= n; j++){
            cur.add(j);
            helper(j+ 1, n, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    @Test
    public static void main(String[] args){


        List<List<Integer>>res = combine(4, 2);
        for (List<Integer> str:res) {
            System.out.println(str);
        }
    }
}
