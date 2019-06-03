package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class intersection_of_two_arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here

        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (Integer n:nums1){
            set.add(n);
        }


            for (Integer num:nums2){
                if (set.remove(num)) {
                    list.add(num);
                }
            }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    @Test
    public void test(){
        int[] n1 = {1,2,2,3};
        int[] n2 = {2,2,1};
        int[] res = intersection(n1,n2);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
