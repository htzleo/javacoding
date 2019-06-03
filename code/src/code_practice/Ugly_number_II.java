package code_practice;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ugly_number_II {
    public int nthUglyNumber(int n) {
        //
        Queue<Long> que = new PriorityQueue<Long>();
        //记录已存在的ugly number
        HashSet<Long> inQ = new HashSet<>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0;i<3;i++){
            que.add(primes[i]);
            inQ.add(primes[i]);
        }
        //第一个Ugly number
        Long num = Long.valueOf(1);

        for (int i =1;i<n;i++){
            //第i个ugly number poll(为当前queue中最小的值)
            num = que.poll();
            //加入新的ugly number
            for(int j = 0;j<3;j++){
                //判断是否有重复 e.g 2*3 3*2
                if(!inQ.contains(primes[j]*num)){
                    que.add(primes[j]*num);
                    inQ.add(primes[j]*num);
                }
            }
        }
        return num.intValue();
    }
    @Test
    public void test(){
        int n = 9;
        int res = nthUglyNumber(9);
        Assert.assertEquals(res,10);
    }
}
