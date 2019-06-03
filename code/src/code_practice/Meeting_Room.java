package code_practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Meeting_Room {
    class Interval{
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null||intervals.size()==0){
            return true;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        int end = intervals.get(0).end;
        for (int i = 1;i<intervals.size();i++){
            if (intervals.get(i).start<intervals.get(i-1).end){
                return false;
            }
            end = Math.max(end, intervals.get(i).end);
        }
        return true;
    }
    @Test
    public void test(){
        List<Interval> test = Arrays.asList(
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
                );
        System.out.println(canAttendMeetings(test));
    }
}


