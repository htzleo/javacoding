package code_practice;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {
    public static boolean wordPattern(String pattern, String str) {
        // write your code here

        Map<String, Integer> m1 = new HashMap<>(); // pattern map
        Map<String, Integer> m2 = new HashMap<>(); // str map
        String tmp = "";
        int cnt = 0; //pattern index
        int now = 0; // str index
        str +=' ';
        for (int i = 0;i<str.length();++i){
            if (str.charAt(i)== ' '){
                if (m1.get(String.valueOf(pattern.charAt(cnt)))== null&&m2.get(tmp) == null){
                    ///when m1 map and m2 map 都遇见一个新的key
                    m1.put(String.valueOf(pattern.charAt(cnt)),now);
                    m2.put(tmp, now);
                    now++;
                }else if (m1.get(String.valueOf(pattern.charAt(cnt)))!= null&&m2.get(tmp) != null){
                    //when m1 map and m2 map 都遇见一个重复的key
                    if(m1.get(String.valueOf(pattern.charAt(cnt)))!= m2.get(tmp)){
                        return false;
                    }
                }else {
                    return false;
                }
                cnt++;
                tmp = "";
            }else {
                tmp += str.charAt(i);
            }
        }
        return true;
    }
    @Test
    public static void main(String[] args){
        String p = "abab";
        String s = "xyz abc xyz abc";
        System.out.println(wordPattern(p,s));
    }
}
