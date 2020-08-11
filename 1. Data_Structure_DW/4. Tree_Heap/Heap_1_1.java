import java.util.*;
public class Heap_1_1 {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqScov = new PriorityQueue<>();
         for (int s: scoville) {
             pqScov.add(s);
         }

         int cnt = 0;
         while (pqScov.size() > 1 && pqScov.peek() < K) {
             pqScov.add(pqScov.remove() + pqScov.remove() * 2);
             cnt++;
         }

         return pqScov.peek() >= K ? cnt : -1;

    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        System.out.println(solution(scoville, K));
        
    }
    
}