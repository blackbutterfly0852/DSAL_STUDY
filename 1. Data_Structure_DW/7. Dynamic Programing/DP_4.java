import java.util.*;

public class DP_4 {

    public static int solution(int[] money) {
        int answer = 0;
        // dp[i] = i번째까지 왔을 때 최대값, 두 번째까지 왔을 때의 최대값이 세 번째까지 왔을 때 최대값 보다 클 수 있다.
        int[] dp1 = new int[money.length - 1];
        int[] dp2 = new int[money.length];
        // 첫 번째 시작 == 세 번째 시작
        dp1[0] = money[0];
        dp1[1] = money[0];
        // 두 번째 시작 == 네 번째 시작
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            if (i < money.length - 1) {
                dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
            }
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }
        answer = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
        return answer;
    }

    public static void main(String[] args) {
        // int[] money = {1,2,3,1};
        int[] money = { 5, 4, 1, 8, 9 };
        System.out.println(solution(money));
        System.out.println("6");
        System.out.println('6' + '6');
    }

}