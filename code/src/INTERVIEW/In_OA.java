package INTERVIEW;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class In_OA {
    public static void pattern(String str,int len){
        for (int i = 0;i<len;i++) {
            int j = len-1-i;
            for ( int k = 0;k<len;k++){
                if (k==i || k == j)
                    System.out.print(str.charAt(k));
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }


    }


    public static int maxValue(int[] arry){
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<arry.length;i++){
            if (map.containsKey(arry[i])){
                map.put(arry[i],map.get(arry[i])+1);
            }else {
                map.put(arry[i],1);
            }

        }
        max = Collections.max(map.values());
        return max;
    }
    public static void main(String[] args){
        int[] arr = {1,5,1,4,5,2,1,6,6,1};
//        System.out.println(maxValue(arr));
        String str = "geeksforgeeks";
        int len = str.length();
        pattern(str, len);
    }
}
