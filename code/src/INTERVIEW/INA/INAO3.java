package INTERVIEW.INA;

import org.junit.Test;

import java.util.*;

public class INAO3 {
    public List<Integer> solution(int[] T){
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        int root = 0;
        for (int i = 0;i<T.length;i++){
            map.put(i,T[i]);
            if(i==T[i]){
                root = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            //ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0;i<size;i++){
                int temp = queue.poll();
                for (Integer key:map.keySet()){
                    if(map.get(key)==temp && key!=temp){
                        queue.offer(key);
                    }
                }
            }
            level.add(queue.size());
        }
        return level;
    }
    @Test
    public void test(){
        int[] a = {9,1,4,9,0,4,8,9,0,1};
        List<Integer> res = solution(a);
        for (Integer i:res){
            System.out.println(i);
        }
    }
}
