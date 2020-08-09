import java.util.*;
// Hash
// 3. 위장
public class Hash_3 {

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> c_count = new HashMap<String, Integer>();
        // 1. 의상 종류 별로 count
        for (String[] cloth : clothes) {
            // System.out.println("cloth : " + cloth[1]);
            // 1-1. 의상의 종류가 존재 X
            if (!c_count.containsKey(cloth[1])) {
                c_count.put(cloth[1], 1);
            // 1-2. 의상의 종류가 이미 존재
            } else {
                c_count.put(cloth[1], c_count.get(cloth[1]) + 1);
            }
        }

        // 2. 경우의 수
        for(Integer count : c_count.values()){
            answer *=(count+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        String[][] answer = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } };
        String[][] answer2 = { { "crow_mask", "face" }, { "blue_sunglasses", "up" }, { "blue_sunglasses", "up" },
                             { "smoky_makeup", "down" }, { "smoky_makeup", "down" }, { "smoky_makeup", "down" }, { "s", "outer" },
                             { "s", "outer" }, { "s", "outer" }, { "s", "outer" } };

        System.out.println(solution(answer));
    }
}