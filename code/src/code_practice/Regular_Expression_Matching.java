package code_practice;

import org.junit.Test;

public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        // write your code here
        if (s == null||p == null){
            return false;
        }
        //传入两个数组记录方案
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];

        return isMatchHelper(s,0,p,0,memo,visited);
    }
    private static boolean isMatchHelper(String s, int sIndex,
                                  String p, int pIndex,
                                  boolean[][] memo,
                                  boolean[][] visited){
        boolean match;
        ///recursion chukou
        if (p.length()==pIndex){
            return sIndex == s.length();
        }
        if (s.length() == sIndex){
            return isEmpty(p,pIndex);
        }

        if (visited[sIndex][pIndex]){
            return memo[sIndex][pIndex];
        }

        char pChar = p.charAt(pIndex);
        char sChar = s.charAt(sIndex);

        ///option 1: consider a* as a bundle
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
            match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited) ||
                    charMatch(sChar, pChar) &&
                            isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        }else {
            match = charMatch(sChar,pChar) && isMatchHelper(s,sIndex+1,p,pIndex+1,memo,visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;

    }
    private static boolean charMatch(char sChar,char pChar){
            return sChar == pChar || pChar=='.';
    }
    private static boolean isEmpty(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }

    @Test
    public static void main(String[] args){
        String s1 = "aa";
        String s2 = "a";
        System.out.println(isMatch(s1,s2));
    }
}
