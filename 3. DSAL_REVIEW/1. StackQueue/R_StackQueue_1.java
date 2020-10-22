import java.util.*;

public class R_StackQueue_1 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i]++;
                } else if (prices[i] > prices[j]) {
                    // 참고
                    // 증가값 및 누적값 idx 활용
                    answer[i] = j - i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }


    public static int[] solution_2(int[] prices) {
        // 참고
        // 감소하는 부분 idx를 만나면, 해당 idx 기준으로 뒤로 다시 돌면서 증가 또는 감소 확인한다.
        // 최종 stack에는 증가하는 idx만 존재하도록 한다.
        
        int[] answer = new int[prices.length];
        Stack<Integer> idx = new Stack<Integer>();
        int startIdx = 0;
        idx.push(startIdx);

        for(startIdx = 1 ; startIdx < prices.length ; startIdx ++){
            // 감소하는 부분 idx를 만나면, 해당 idx 기준으로 뒤로 다시 돌면서 증가 또는 감소 확인한다.
            while(!idx.isEmpty() && prices[startIdx] < prices[idx.peek()]){
                // System.out.println("startIdx : " + startIdx);
                int curIdx = idx.pop();
                // System.out.println("curIdx : " + curIdx);
                answer[curIdx] = startIdx - curIdx;
                // System.out.println(Arrays.toString(answer));
            }
            idx.push(startIdx);
        }

        // 최종 stack에는 증가하는 idx만 존재하도록 한다.
        while(!idx.isEmpty()){
            int curIdx = idx.pop();
            answer[curIdx] = prices.length - curIdx - 1;
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
      
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 3 };
        // int[] prices = { 3, 2, 3, 1, 4 };
        solution_2(prices);
    }

}
