import java.util.Arrays;
import java.util.Comparator;
// 참고 : https://st-lab.tistory.com/243
public class BigNumber {

    public static String solution(int[] numbers) {
        String answer = "";
        // 1. int -> String

        String[] temp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = Integer.toString(numbers[i]); 
        }
        
        // 2. 글자를 합쳐 숫자로 변환 후 큰 쪽이 앞으로 오게 기준
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int ab = Integer.parseInt(a + b);
                int ba = Integer.parseInt(b + a);
                return ba - ab;
            }
        };

        // 3. 정렬
        Arrays.sort(temp, com);

        //System.out.println("final : " + Arrays.toString(temp));

        // 4. 정렬된 숫자를 다시 합치기. 
        int flag = 0;
        for (String t : temp) {
            answer += t;
            flag += Integer.parseInt(t);
        }

        return flag == 0 ? "0" : answer;
    }

    public static void main(String[] args) {
        int[] a = { 6, 10, 2 };
        int[] b = { 3, 30, 34, 5, 9 };
        System.out.println(solution(b));

    }

}
