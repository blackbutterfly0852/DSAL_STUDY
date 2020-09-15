import java.time.YearMonth;
import java.util.*;

public class Practice {
    public static int[] solution(int[][] tickets) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> X = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> Y = new HashMap<Integer, Integer>();
        for (int i = 0; i < tickets.length; i++) {
            if (!X.containsKey(tickets[i][0])) {
                X.put(tickets[i][0], 1);
            } else {
                X.remove(tickets[i][0]);
            }

            if (!Y.containsKey(tickets[i][1])) {
                Y.put(tickets[i][1], 1);

            } else {
                Y.remove(tickets[i][1]);
            }

        }

        for (int x : X.keySet()) {
            answer[0] = x;
        }
        for (int y : Y.keySet()) {
            answer[1] = y;
        }
        System.out.println(answer.toString());

        return answer;
    }

    public static void main(String[] args) {
       
    }

}