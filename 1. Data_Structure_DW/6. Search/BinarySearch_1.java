// 이진탐색 : 입국심사 -> 풀지 못하고 https://minnnne.tistory.com/32 참고함
import java.util.*;

public class BinarySearch_1 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        // 1. 탐색 범위 산정
        long left_idx = 1;
        long right_idx = times[times.length - 1] * (long) n;

        // 2. 탐색 범위 산정 후 이분 탐색 count와 n 비교 후 left_idx / right_idx 설정
        while (left_idx <= right_idx) {
            long center = (left_idx + right_idx) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += center / times[i];
            }
            if (count >= n) {
                if (answer == 0) {
                    answer = center;
                } else {
                    answer = answer >= center ? center : answer;
                }
                right_idx = center - 1;
            } else {
                left_idx = center + 1;
            }
        }
        return answer;

    }

    // 다른 사람 풀이
    public int solution_2(int n, int[] times) {
        Arrays.sort(times);
        return (int) find((long) n, times, (long) times.length, times[0], (long) ((long) times[0] * (long) n));
    }
    // 이분탐색 -> 오른쪽 왼쪽 범위를 줄여라!
    public long find(long n, int[] times, long nExamination, long from, long to) { // 7 ~ 42 -> 최소값 구하기 때문
        long minTime;
        long tmp = n; // 6
        if (from == to) { // 21 == 21
            return from; //  21
        }
        else {
            // + ((from + to) % 2 == 1? 1 : 0);
            minTime = (from + to) / 2; // 24 // 15 // 20 // 22 
            
            for (int i = 0; i < nExamination; i++) {
                tmp -=  minTime / (long) times[i];
            }
            // tmp가 0보다 크다는 의미는 입국처리한 인원이 원래 인원보다 작은 경우 -> left_idx = center +1;
            if (tmp > 0) { 
                return find(n, times, nExamination, minTime + 1, to); // 16 ~ 24 // 21 ~ 24
            }
            // tmp가 0보다 작다는 의미는 입국처리한 인원이 원래 인원보다 큰 경우 -> right_idx = center -1;
            else {
                return find(n, times, nExamination, from, minTime); // 7 ~ 24 // 21 ~ 22 // 21 ~ 21
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] times = { 1, 5 };
        System.out.println(solution(n, times));
        int n_2 = 2;
        int[] times_2 = { 1, 1 };
        // System.out.println(solution(n_2, times_2));
        ;
    }

}