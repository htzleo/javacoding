package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    public static List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        helper(s, 0,new ArrayList<>(),res);
        return res;
    }
    public static void helper(String s,int index, List<String> current, List<List<String>> res){
        if (index == s.length()){
            res.add(new ArrayList<>(current));
            return;
        }

        // option 1
        current.add(String.valueOf(s.charAt(index)));
        helper(s, index+1, current,res);
        current.remove(current.size()-1);

        //option 2
        if (index < s.length()-1){
            for (int j = 2;j <= s.length()-index;j++){
                if(isValid(s.substring(index,index+j))){
                    current.add(s.substring(index,index+j));
                    helper(s,index+j,current,res);
                    current.remove(current.size()-1);
                }
            }
        }
    }
    public static boolean isValid(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    @Test
    public static void main(String[] args){
        String s1 = "aaabbb";
        List<List<String>>  res = new ArrayList<>();
        res = partition(s1);
        for (List<String> str:res) {
            System.out.println(str);
        }
    }
}
