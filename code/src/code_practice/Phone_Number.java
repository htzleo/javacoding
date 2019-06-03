package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone_Number {
    public static List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length()==0){
            return res;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, res);
        return res;
    }
    private static void helper(Map<Character, char[]> map, String num,
                               StringBuilder sb, List<String> res){
        if(sb.length()==num.length()){
            res.add(sb.toString());
            return;
        }

        for (char c:map.get(num.charAt(sb.length()))) {
            sb.append(c);
            helper(map, num,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public static void main(String[] args){
        String str = "23";
        List<String> res = letterCombinations(str);
        for (String s:res
             ) {
            System.out.println(s);
        }
    }

}
