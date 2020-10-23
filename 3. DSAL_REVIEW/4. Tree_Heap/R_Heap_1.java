import java.util.Iterator;
import java.util.PriorityQueue;

public class R_Heap_1 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        // 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        // 참고
        // PriorityQueue 이므로 기본 오름차순
        // peek() 하여 K 이상인지 체크만 하면 된다.
        while (pq.size() >= 2 && !isAllK(pq, K)) {
            answer++;
            int s1 = pq.poll();
            int s2 = pq.poll();
            int s1s2 = s1 + (s2 * 2);
            pq.add(s1s2);
        }

        if(!isAllK(pq, K)){
            answer = -1;
        }

        return answer;
    }

    public static boolean isAllK(PriorityQueue<Integer> pq, int k) {
        Iterator it = pq.iterator();

        while (it.hasNext()) {
            int s = (int) it.next();
            if (s < k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        System.out.println(solution(scoville, K));
    }

}
