import java.util.Arrays;

// 주식가격
public class StackQueue_2 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 초기값 0으로 셋팅
       
        // int[] vari = {1,2,3,2,3};
        for (int i = 0; i < prices.length; i++) {
            // System.out.println("i : " + i);
            for (int j = i + 1; j < prices.length; j++) {
                // System.out.println("j : " + j);
                if (prices[i] <= prices[j]) {
                    answer[i] +=1; 
                } else {
                    answer[i] +=1;
                    break;
                }
                // System.out.println("count : " + count);
            }
           
        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        int[] vari = { 1, 2, 3, 2, 3 };
        solution(vari);
        
    }
}