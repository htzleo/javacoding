package code_practice;

import org.junit.Test;

import java.util.*;

public class Word_Break_II {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return wordBreakHelper(s,wordDict,memo);
    }

    public static ArrayList<String> wordBreakHelper(String s,
                                                    Set<String> wordDict,
                                                    Map<String, ArrayList<String>> memo){
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        ArrayList<String> res = new ArrayList<>();
        if (s.length()==0)
            return res;

        if (wordDict.contains(s))
            res.add(s);

        for (int i = 1;i<s.length();++i){
            String word = s.substring(0,i);
            if(!wordDict.contains(word))
                continue;

            String suffix = s.substring(i);
            ArrayList<String> seg = wordBreakHelper(suffix,wordDict,memo);

            for (String st:seg){
                res.add(word+" " + st);
            }
        }
        memo.put(s,res);
        return res;
    }
    @Test
    public static void main(String[] args){
        String s1 = "lintcode";
        System.out.println(s1.substring(1));
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList(new String[]{"de", "ding", "co", "code", "lint"}));
        List<String> res = wordBreak(s1,dict);
        for (String str:res) {
            System.out.println(str);
        }


    }
}
