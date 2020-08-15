
import java.util.*;

// H-Index
public class Sort_3 {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // ex) {3, 0, 6, 1, 5} -> {0, 1, 3, 5, 6}
        // 1. i : 인용횟수 -> 0부터 citations의 max값 + 1까지 LOOP -> max값까지 LOOP 해야됨 {2,2,2,2,2}
        System.out.println("citations : " + Arrays.toString(citations));
        for (int i = 0; i < citations[citations.length - 1] + 1; i++) {
            int use_count = 0; // 인용 논문 수
            // 1-1. i(인용횟수)에 따라 인용 논문 수 계산
            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) {
                    use_count += 1;
                }
            }
            // 1-2. 인용 논문 수가 i(인용횟수) 보다 크거나 같고 (그리고) 현 인용횟수가 이전 인용횟수보다 큰 경우 answer 업데이트
            if (i <= use_count && i >= answer) {
                answer = i;
            }
        }
        return answer;
    }

    // 다른 사람 풀이
    // ex) {3, 0, 6, 1, 5} -> {0, 1, 3, 5, 6} : length : 5 // i : 4
    // 정렬 후, 마지막 원소(가장 인용횟수가 높은 논문)
    // 가장 인용횟수가 큰 논문은 6번 1개 존재 -> 1
    // 그 다음 인용횟수가 큰 논문은 5번 2개 존재 -> 2
    // 그 다음 인용횟수가 큰 논문은 3번 3개 존재 -> 3
    // 그 다음 인용횟수가 큰 논문은 1번 4개 존재 -> 1
    // 그 다음 인용횟수가 큰 논문은 0번 5개 존재 -> 0
    // --> min() 값이 증가하다가 감소하는 지점이 정답
    public static int solution_2(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = citations.length - 1; i > -1; i--) {
            // System.out.println("citations[i] : " + citations[i]);
            // System.out.println("citations.length - i : " + (citations.length - i));
            int min = (int) Math.min(citations[i], citations.length - i);
            // System.out.println("min : " + min);
            if (max < min)
                max = min;
            // System.out.println("max : " + max);
            // System.out.println("----------");
        }

        return max;
    }

    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        int[] citations_1 = { 1, 0 };
        int[] citations_2 = { 12, 11, 10, 9, 8, 1 };
        int[] citations_3 = { 20, 21, 22, 23 };
        int[] citations_4 = { 4, 4, 4 };
        int[] citations_5 = { 2, 2, 2, 2, 2 };
        System.out.println(solution_2(citations_5));

    }

}