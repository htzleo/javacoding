package INTERVIEW.INA;

import org.junit.Test;

public class INAO1 {
    /**
     *
     * @param A
     * @return
     * eg 1: [1,-2,-3,5] retuen 1
     * eg 2: [1,2,3,-4] return -1
     * eg 3: [1.2.0.-5] return 0
     */
    public int solution(int[] A){
        int res = 1;
        for (int i = 0;i<A.length;i++){
            if(A[i]<0){
                res *= -1;
            }
            if(A[i]>0){
                res *= 1;
            }
            if (A[i] == 0)
                res = 0;
        }
        return res;
    }
    @Test
    public void test(){
        int[] A = {1,-2,3,5};
        System.out.println(solution(A));
    }
}
