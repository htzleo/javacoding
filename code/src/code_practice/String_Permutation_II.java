package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Permutation_II {

    public static List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        char[] s = str.toCharArray();
        Arrays.sort(s);
        boolean[] visited = new boolean[str.length()];
        String prefix = "";
        getList(s, prefix, visited, res);
        return res;
    }
    private static void getList(char[] s, String prefix,
                                boolean[] visited,
                                List<String> res){
        if (prefix.length()== s.length){
            res.add(prefix);
            return;
        }

        for (int i = 0;i<s.length; i++){
            if (visited[i] || (i>0 && s[i] == s[i-1] && !visited[i-1])){
                continue;
            }

            prefix += s[i];
            visited[i] = true;

            getList(s, prefix,visited,res);
            prefix = prefix.substring(0, prefix.length()-1);
            visited[i] = false;
        }
    }
    @Test
    public static void main(String[] args){
        String str = "aabb";
        List<String> res = stringPermutation2(str);
        for (String s:res
             ) {
            System.out.println(s);
        }

    }
}
