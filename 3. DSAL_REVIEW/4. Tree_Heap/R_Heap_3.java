import java.util.*;

public class R_Heap_3 {
    // 이중 우선순위 큐
    public static int[] solution(String[] operations) {
        int[] answer = { 0, 0 };

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer current, Integer last) {
                if (current < last) {
                    return 1;
                }
                return -1;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer current, Integer last) {
                if (current > last) {
                    return 1;
                }
                return -1;
            }
        });

        for (String o : operations) {
            // 참고
            // 문자열 자르기 : splict("기준")
            String[] flag = o.split(" ");
            if (flag[0].equals("I")) {
                int number = Integer.parseInt(flag[1]);
                minHeap.offer(number);
                maxHeap.offer(number);
            } else {
                // 참고
                // 삭제 시 maxHeap과 minHeap 동기화
                if (!maxHeap.isEmpty()) {
                    if (flag[1].equals("1")) {
                        int maxNumber = maxHeap.poll();
                        minHeap.remove(maxNumber);

                    } else {
                        int minNumber = minHeap.poll();
                        maxHeap.remove(minNumber);

                    }
                }

            }

        }

        if (!maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        String[] input_0 = { "I 16", "D 1" };
        String[] input_1 = { "I 7", "I 5", "I -5", "D -1" };
        String[] input_2 = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
        String[] input_3 = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        System.out.println(solution(input_3));

    }

}
