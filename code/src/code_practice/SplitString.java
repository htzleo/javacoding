package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitString {
    public static List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);

        return res;
    }
    public static void helper(String s,int index, List<String> current, List<List<String>> res){
        if (index == s.length()){
            System.out.println("add");
            res.add(new ArrayList<String>(current));
            return;
        }
        // 隔一个字符
        current.add(String.valueOf(s.charAt(index)));
        System.out.println("index + "+ index);
        System.out.println("s "+s.charAt(index));
        helper(s,index+1,current,res);
        current.remove(current.size()-1);
        System.out.println("size" + current.size());

        //隔两个字符
        if (index<s.length()-1){
            current.add(s.substring(index,index+2));
            System.out.println("index2 + "+ index);
            System.out.println("s = "+s);
            System.out.println("s2 "+s.substring(index,index+2));
            helper(s,index+2,current,res);
            current.remove(current.size()-1);
        }

    }

    @Test
    public static void main(String[] args){
        String s1 = "12345";
        List<List<String>>  res = new ArrayList<>();
        res = splitString(s1);
        for (List<String> str:res) {
            System.out.println(str);
        }
    }
}
