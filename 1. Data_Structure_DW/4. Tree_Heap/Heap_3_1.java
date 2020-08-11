import java.util.*;

// 이중 우선순위 큐 -> PriortyQueue 사용
public class Heap_3_1 {
    public static int[] solution(String[] arguments) {
        int[] answer = { 0, 0 };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대값
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소값

        for (String str : arguments) {
            String input[] = str.split(" ");
            switch (input[0]) {
                case "I":
                    maxHeap.add(Integer.parseInt(input[1]));
                    minHeap.add(Integer.parseInt(input[1]));
                    break;

                case "D":
                    // 각각의 PriortityQueue를 동기화 시킨다.
                    if (maxHeap.size() > 0) {
                        // 최대값 삭제
                        if (Integer.parseInt(input[1]) == 1) {
                            int max = maxHeap.poll();
                            minHeap.remove(max); // 값이 삭제?
                        // 최소값 삭제
                        } else {
                            int min = minHeap.poll();
                            maxHeap.remove(min); // 값이 삭제?
                        }
                    }
                    break;
            }

        }

        if (maxHeap.size() >= 1) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        System.out.println("answer[0] : " + answer[0]);
        System.out.println("answer[1] : " + answer[1]);

        return answer;
    }

    public static void main(String[] args) {
        String[] input_0 = { "I 16", "D 1" };
        String[] input_1 = { "I 7", "I 5", "I -5", "D -1" };
        String[] input_2 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        System.out.println(solution(input_2));

    }
}