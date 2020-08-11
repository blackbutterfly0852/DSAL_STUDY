import java.util.*;

// 더 맵게
public class Heap_1 {

    public static int solution(int[] scoville, int K) {
        // 1. 초기화
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) {
            priorityQueue.add(i);
        }

        // 2. 계산
        while (true) {
            // 2-1. priorityQueue의 첫 요소가 K이상일 경우 중지.
            if (priorityQueue.peek() >= K) {
                return answer;
            }
            // 2-2. priorityQueue의 크기가 1 이하 이며, 첫 요소가 K 미만 경우 중지.
            if(priorityQueue.size()<=1 && priorityQueue.peek() < K ){
                return -1;
            }
            // 2-3. 계산
            answer += 1;
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int convert = first + (second * 2);
            priorityQueue.add(convert);
        }

    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        System.out.println(solution(scoville, K));
        
    }

//  테스트 1 〉	통과 (1.08ms, 42.5MB)
//  테스트 2 〉	통과 (1.22ms, 43.1MB)
//  테스트 3 〉	통과 (1.08ms, 42.7MB)
//  테스트 4 〉	통과 (1.12ms, 42.8MB)
//  테스트 5 〉	통과 (1.21ms, 42.5MB)
//  테스트 6 〉	통과 (4.36ms, 43.1MB)
//  테스트 7 〉	통과 (3.53ms, 43.3MB)
//  테스트 8 〉	통과 (1.58ms, 42.3MB)
//  테스트 9 〉	통과 (1.63ms, 42.7MB)
//  테스트 10 〉통과 (3.64ms, 42.9MB)
//  테스트 11 〉통과 (2.60ms, 42.6MB)
//  테스트 12 〉통과 (5.26ms, 43.1MB)
//  테스트 13 〉통과 (3.70ms, 42.9MB)
//  테스트 14 〉통과 (1.25ms, 42.8MB)
//  테스트 15 〉통과 (3.59ms, 42.8MB)
//  테스트 16 〉통과 (1.23ms, 42.8MB)

//  테스트 1 〉	통과 (134.15ms, 58MB)
//  테스트 2 〉	통과 (242.76ms, 69.7MB)
//  테스트 3 〉	통과 (1614.04ms, 124MB)
//  테스트 4 〉	통과 (138.90ms, 57.2MB)
//  테스트 5 〉	통과 (1534.19ms, 128MB)

}