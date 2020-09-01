import java.util.*;

public class Exam_2 {

    static int[] standard_count;

    public static int solution(int num, int[] cards) {
        int answer = Integer.MAX_VALUE;

        standard_count = new int[cards.length];

        for (int i = 0; i < standard_count.length; i++) {
            standard_count[i] = num / cards[i]; // 8 , 2 ,1
        }

        int[] current_count = new int[cards.length];

        for (int j = 0; j < cards.length; j++) {
            current_count[j]++;
            answer = Math.min(answer, dfs(num, cards, cards[j], 1, current_count, j));
            current_count[j] = 0;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static int dfs(int num, int[] cards, int sum, int count, int[] current_count, int idx) {
        System.out.println(Arrays.toString(standard_count));
        System.out.println(Arrays.toString(current_count));
        System.out.println("sum : " + sum);
        System.out.println("---------------------");
        int answer = Integer.MAX_VALUE;

        if (sum == num) {
            System.out.println("들어옴");

            return count;
        }

        if (standard_count[idx] < current_count[idx] || sum > num) {
            System.out.println("들어옴2");
            current_count[idx] = 0;
            return Integer.MAX_VALUE;
        }

        // if(sum > num){
        // return Integer.MAX_VALUE;
        // }
        int tmp_sum = sum;
        for (int j = 0; j < cards.length; j++) {
            sum = tmp_sum;
            System.out.println("sum : " + sum);
            current_count[j]++;

            answer = Math.min(answer, dfs(num, cards, sum + cards[j], count + 1, current_count, j));

            System.out.println("answer : " + answer);

            // current_count[j] -=1;Y

        }

        return answer;
    }

    public static void main(String[] args) {
        // int num = 8;
        // int[] cards = {1,4,6};

        int num = 18;
        int[] cards = { 1, 2, 5 };
        System.out.println(solution(num, cards));

    }
}