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
    public static int[] solution_2(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = yellow+2*a-4;
        System.out.println(b);
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2}; // 제곱근
        return answer;
    }
    
    public static void main(String[] args) {
        solution_2(8, 1);
        solution_2(10, 2);
        //solution(12, 3);
        solution_2(12, 4);
        //solution(24, 24);
        //solution(14, 4);
        //solution(20, 16);
        //solution(50, 22);
        //solution(8, 1);
        //solution(18, 6);

    }

}