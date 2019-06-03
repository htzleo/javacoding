package code_practice;

import org.junit.Test;

public class Wilecard_Matching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     * 使用深度优先搜索 + 记忆化的版本。
     *
     * 用一个二维的 boolean 数组来当记忆化数组，记录 s 从 sIndex 开始的后缀 能够匹配上 p 从 pIndex 开始的后缀
     */
    public static boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }

        //传入两个数组记录方案
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(s,0,p,0,memo,visited);
    }
    private static boolean isMatchHelper(String s, int sIndex, //判断cur字符的时候index
                                  String p, int pIndex, //
                                  boolean[][] memo,
                                  boolean[][] visited){
        //出口1.字符串为空
        if (sIndex == s.length()){
            return allStar(p, pIndex); //p:******匹配空串
        }
        //出口2 p为空
        if (pIndex == p.length()){
            return sIndex == s.length(); //s里也应该为空
        }

        //记忆化搜索
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        //取第一个字符
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        //O(2n) 拆解
        //option *
        if(pChar == '*'){ //*匹配0 (去掉*, pindex+1);>=1 去掉s中的匹配字符 sindex+1
            match = isMatchHelper(s,sIndex,p,pIndex+1,memo,visited)
                    || isMatchHelper(s,sIndex+1,p,pIndex,memo,visited);
        }else {
            //非* 字符就必须相等：
            match = charMatch(sChar,pChar)&&
                    isMatchHelper(s, sIndex+1,p,pIndex+1,memo,visited);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    private static boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }
    private static boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    @Test
    public static void main(String[] args){
        String s1 = "aa";
        String s2 = "a?";
        System.out.println(isMatch(s1,s2));
    }
}
