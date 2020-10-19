import java.util.*;

public class R_StackQueue_1 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 참고
                // 주어준 배열의 원소당 조건에 맞는 개수를 구하는 경우
                // 주어진 배열길이로 새로운 배열을 생성 후, 새로운 배열에서 count 할 수 있다.
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
        // Arrays.toString(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };
        int[] prices_2 = { 3,2,3,1,4 };
        solution(prices_2);
    }

}
