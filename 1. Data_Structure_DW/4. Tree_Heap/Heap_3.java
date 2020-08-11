import java.util.*;
// 이중 우선순위 큐 -> PriortyQueue 미사용
public class Heap_3 {
    
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        String i = "I"; // 데이터 입력
        String d = "D 1"; // 최대값 제거
        String d_1 = "D -1"; // 최소값 제거
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (String str : operations) {
            // insert
            if (str.startsWith(i)) {
                String number = str.replaceAll("[^-?0-9]+", "");
                list.add(Integer.parseInt(number));

            // 최대값 제거
            } else if (str.startsWith(d)) {
                if (list.size() != 0) {
                    int maxIdx = maxValueIdx(list);
                    list.remove(maxIdx);
                }

            // 최소값 제거
            } else if (str.startsWith(d_1)) {
                if (list.size() != 0) {
                    int minIdx = minValueIdx(list);
                    list.remove(minIdx);
                }
            }
        }
        if (list.size() != 0) {
            answer[0] = (Collections.max(list));
            answer[1] = (Collections.min(list));

        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        System.out.println("answer[0] : " + answer[0]);
        System.out.println("answer[1] : " + answer[1]);
        return answer;
    }
    // 최대값 idx 구하기
    public static int maxValueIdx(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                idx = i;
            }
        }
        return idx;
    }
    // 최소값 idx 구하기
    public static int minValueIdx(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
                idx = i;
            }
        }
        
        return idx;
    }

    public static void main(String[] args) {
        String[] input_0 = { "I 16", "D 1" };
        String[] input_1 = { "I 7", "I 5", "I -5", "D -1" };
        String[] input_2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(solution(input_2));
        
    }
}