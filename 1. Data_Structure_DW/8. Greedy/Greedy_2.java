import java.util.*;

public class Greedy_2 {

    public static String solution(String number, int k) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < number.length() - k; i++) {
            System.out.println("1");
            if((number.length() - idx) == (number.length() - k-i)){
                answer+=number.substring(idx, number.length());
                break;
            }
            char max = '0';
            // System.out.println("idx : " + idx);
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j;
                }
            }
            answer += max;
            idx += 1;
        }
        return answer;
    }

    // 다른 사람 풀이 -> 시간복잡도 효율 더 좋음
    public static String solution_2(String number, int k) {

        char[] result = new char[number.length()-k];
        Stack<Character> result_list = new Stack<Character>();

        for(int i = 0 ; i < number.length() ; i ++){
            char num = number.charAt(i);

            while(!result_list.isEmpty() && result_list.peek() < num && k-- > 0){
                result_list.pop();
            }
            result_list.push(num);
        }
        
        for(int i = 0 ; i < result.length;i++){
            result[i] = result_list.get(i);
        }
        return new String(result);
       
    }

    public static void main(String[] args) {
        String number = "133748";
        int k = 1;
        // String number = "559913";
        // int k = 1;
        System.out.println(solution_2(number, k));
        // System.err.println((number.substring(1, 5)));
    }

}
