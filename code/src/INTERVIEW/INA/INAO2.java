package INTERVIEW.INA;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

public class INAO2 {
    /**
     *
     * @param
     * @return
     * eg 1: s = "wed" k = 2,return “fri”
     * eg 2: S = "Sat" k = 23, return "MON"
     */
    public String solution(String S,int K){
        String sb = new String();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mon",1);
        map.put("Tue",2);
        map.put("Wed",3);
        map.put("Thu",4);
        map.put("Fri",5);
        map.put("Sat",6);
        map.put("Sun",7);
        if(map.containsKey(S)){
            int temp = (map.get(S)+K)%7;
            for (String key:map.keySet()){
                if(map.get(key) == temp)
                    sb =  key;
            }
        }
        return sb;
    }
    @Test
    public void test(){
        String s = "Wed";
        System.out.println(solution(s,2));
    }
}
