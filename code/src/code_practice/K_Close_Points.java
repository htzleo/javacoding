package code_practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class K_Close_Points {
    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    /**
     *
     *
     * @param points
     * @param origin
     * @param k
     * @return
     * 基于 PriorityQueue 的方法
     * PriorityQueue 里从远到近排序。当 PQ 里超过 k 个的时候，就 pop 掉一个。
     * 时间复杂度 O(nlogk)O(nlogk)
     */
    private Point global_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        global_origin = origin;
        Queue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = distance(o2, global_origin)- distance(o1,global_origin);
                if (diff == 0){
                    diff = o2.x-o1.x;
                }
                if (diff == 0)
                    diff = o2.y - o1.y;

                return diff;
            }
        });
        for (int i = 0;i<points.length;i++){
            pq.offer(points[i]);
            if (pq.size()>k)
                pq.poll();
        }

        Point[] res = new Point[k];
        while (!pq.isEmpty()){
            res[--k] = pq.poll();
        }
        return res;
    }
    private int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

}
