import java.util.*;

public class R_Sort_3 {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int h_idx = 0;
        for (int c = 0; c < citations[citations.length - 1]; c++) {
            int count = 0;
            for (int c2 : citations) {
                // System.out.println("c : " + c + " c2 : " + c2);
                if (c <= c2) {
                    count++;
                }
            }
            // System.out.println("count : " + count);
            if (c <= count && c >= citations.length - count) {
                h_idx = c;
            }
            // System.out.println("h_idx : " + h_idx);
            // System.out.println("==================");
        }

        return h_idx;
    }

// 테스트 1 〉	통과 (16.29ms, 52.3MB)
// 테스트 2 〉	통과 (22.22ms, 52.1MB)
// 테스트 3 〉	통과 (20.27ms, 54.6MB)
// 테스트 4 〉	통과 (17.47ms, 52.3MB)
// 테스트 5 〉	통과 (20.00ms, 52.2MB)
// 테스트 6 〉	통과 (21.79ms, 52.1MB)
// 테스트 7 〉	통과 (14.23ms, 52.4MB)
// 테스트 8 〉	통과 (6.10ms, 53MB)
// 테스트 9 〉	통과 (6.87ms, 53.3MB)
// 테스트 10 〉	통과 (15.29ms, 53.2MB)
// 테스트 11 〉	통과 (25.70ms, 53.3MB)
// 테스트 12 〉	통과 (6.95ms, 52.1MB)
// 테스트 13 〉	통과 (21.57ms, 52.4MB)
// 테스트 14 〉	통과 (31.61ms, 52.3MB)
// 테스트 15 〉	통과 (23.30ms, 52.5MB)
// 테스트 16 〉	통과 (0.49ms, 51.9MB)


    public static int solution_2(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        // 원소들이 감소하면서 각 원소들의 인용 횟수는 증가한다.
        // (중요) 어떤 수 a는 감소하고 어떤 수 b는 증가하는 관계에서 (a, b) 쌍의 최소값의 최대값은 a와 b의 차이값이 가장 작을 경우이다. 
        // 아래는 (a,b) 쌍의 최소값이 커지다가 작아지는 지점을 찾는다.
                
        for(int i = citations.length-1 ; i > -1 ; i--){
            System.out.println("citations[i] : " + citations[i] + " citations.length - i : " + (citations.length - i));
            int min = Math.min(citations[i], citations.length - i);
            if(max < min) max = min;

        }

        return max;
    };

    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        // 참고
        // 아래 케이스는 예외 처리
        // 혼동 했던 점
        // 기존 : citations 내 원소들을 기준으로 이중배열
        // 문제점 : 정확한 최댓값을 찾지 못함, 아래 케이스를 기존 방식으로 하면 h_idx : 3
        // 변경 : 0 ~ 인용된 최대 횟수 기준으로 이중 배열, 아래 케이스를 변경 방식으로 하면 h_idx : 4
        // (중요) 문제를 잘 읽고, 원소 내 기준으로 하지 말고 0부터 순차적으로 증가시켜, 최대값을 찾아봐라.
        int[] citations_2 = { 0, 1, 4, 7, 8, 11, 13, 14, 17 };
        //int[] citations_3 = { 8 };

        System.out.println(solution_2(citations_2));

    }

}
