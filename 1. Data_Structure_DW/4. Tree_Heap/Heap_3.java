import java.util.*;

public class Heap_3 {
    //
    public int[] solution(String[] operations) {
        String i = "I"; // 데이터 입력
        String d = "D 1"; // 최대값 제거
        String d_1 = "D -1"; // 최소값 제거
        // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
        // 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.

        // 이중 우선순위 큐 -> deque?

       Deque<Integer> deque = new ArrayDeque<>();

        for(String str : operations){
            // insert
            if (str.startsWith(i)){
                String number = str.replaceAll("[^0-9]", "");
                deque.add(Integer.parseInt(number));
                
            // 최대값 제거
            }else if (str.startsWith(d)){


            }
        }
        int[] answer = {};
        
        return answer;
    }
    
}