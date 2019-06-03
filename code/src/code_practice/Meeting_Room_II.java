package code_practice;

import org.junit.Test;

import java.util.*;

public class Meeting_Room_II {
    class Interval{
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int res = 0;
        if (intervals == null|| intervals.size()==0){
            return res;
        }
        Collections.sort(intervals, (o1,o2) ->o1.start-o2.start);
        Queue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        queue.add(intervals.get(0));
        for (int i = 1;i<intervals.size();i++){
                if (intervals.get(i).start>=queue.peek().end){
                    queue.poll();
                }
                queue.add(intervals.get(i));
        }
        res = queue.size();
        return res;
    }
    @Test
    public void test(){
        List<Interval> test = Arrays.asList(
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
        );
        System.out.println(minMeetingRooms(test));
    }
}
