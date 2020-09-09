import java.util.*;

// 징검다리
// 무엇을 이분탐색으로 찾는가? '바위사이의 최소거리' -> 역으로 생각한다.
// https://webfirewood.tistory.com/108
public class BinarySearch_2 {
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        //int rocks[] = { 2,  11, 14, 17,  21 };
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        
        while (start <= end) {
            int mid = (start + end) / 2; 
            int cnt = 0;
            int standard = 0;
            for (int i = 0; i < rocks.length + 1; i++) {
                int diff = i != rocks.length ? rocks[i] - standard : distance - standard;
              
                if (diff < mid) {
                    cnt++;
                } else if(i!=rocks.length){
                    standard = rocks[i];
                }

                
            }
            if (cnt > n) {
                end = mid-1;
            } else {
                start = mid+1;
                answer = mid;
            }


        }

        return answer;

    }

    public static void main(String[] args) {
        int distance = 25;
        int rocks[] = { 2, 14, 11, 21, 17 };
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }

}