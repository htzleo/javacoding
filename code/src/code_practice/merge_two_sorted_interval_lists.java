package code_practice;

import org.junit.Test;

import java.util.*;

public class merge_two_sorted_interval_lists {
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        List<Interval> res = new ArrayList<>();
        if (list1 == null|| list2==null){
            return res;
        }
        Interval lastInterval  = null;
        Interval cur = null;
        int i = 0;
        int j = 0;

        //两边都有时
        while (i<list1.size() && j<list2.size()){
            //decide current Interval
            if(list1.get(i)._start<=list2.get(j)._start){
                cur = list1.get(i);
                i++;
            }else{
                cur = list2.get(j);
                j++;
            }
            //merge cur and last Interval
            lastInterval = merge(res, lastInterval, cur);
        }
        while (i<list1.size()){
            lastInterval = merge(res,lastInterval,list1.get(i));
            i++;
        }
        while (j<list2.size()){
            lastInterval = merge(res,lastInterval,list2.get(j));
            j++;
        }

        if (lastInterval != null) {
            res.add(lastInterval);
        }
        return res;
    }
    public Interval merge(List<Interval> res, Interval last, Interval cur ){
        if (last == null){
            return cur;
        }
        if(last._end<cur._start){
            res.add(last);
            return cur;
        }
        last._end = Math.max(last._end,cur._end);
        return  last;
    }
    @Test
    public void test(){
        List<Interval> l1 = Arrays.asList(
                new Interval(1,2),
                new Interval(3,4)
        );
        List<Interval> l2 = Arrays.asList(
                new Interval(2,3),
                new Interval(5,6)
        );
        List<Interval> res = mergeTwoInterval(l1,l2);
        for (Interval in:res){
            System.out.println(Integer.toString(in._start) + " "+Integer.toString(in._end));
        }
    }

}
class Interval{
    int _start, _end;
    Interval(int start, int end){
        this._start = start;
        this._end = end;
    }

}
