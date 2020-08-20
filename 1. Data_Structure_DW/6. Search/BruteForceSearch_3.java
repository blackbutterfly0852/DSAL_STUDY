
// 완전탐색 - 카펫
import java.util.*;

public class BruteForceSearch_3 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 1; i <= total; i++) {
                int num = total / i;
                int compare = (i - 2) * (num - 2);
                if (compare == yellow) {
                    answer[0] = i;
                    answer[1] = num;
                }
            
        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }

    // 다른 사람 풀이_1(미친놈)
    public static int[] solution_2(int brown, int red) {
        int a = (brown+4)/2;
        int b = red+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
    
    public static void main(String[] args) {
        solution(8, 1);
        solution(10, 2);
        solution(12, 3);
        solution(12, 4);
        solution(24, 24);
        solution(14, 4);
        solution(20, 16);
        solution(50, 22);
        solution(8, 1);
        solution(18, 6);

    }

}