import java.util.*;

public class StackQueue_1_1 {
    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        // 1. 초기화
        // 1) waitQ 초기화
        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }
        // 2) answer 및 curWeight(현재무게) 초기화
        int answer = 0;
        int curWeight = 0;

        // 2. while 반복
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++; 
            // 1) 다리위에 올라가 있는 트럭이 없는 경우
            if (moveQ.isEmpty()) {
                System.out.println("트럭추가");
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }
            System.out.println("answer 0 : " + answer);
            // 2) 다리위의 트럭 한 칸씩 이동
            for (Truck t : moveQ) {
                t.moving();
            }
            System.out.println("answer 1 : " + answer);
            // 3) 다리위의 트럭의 움직인 거리가 다리 길이보다 큰 경우
            if (moveQ.peek().move > bridgeLength) {
                // 3-1) 다리위의 맨 앞 트럭제거
                Truck t = moveQ.poll();
                // 3-2) 제거한 트럭만큼 무게 제외
                curWeight -= t.weight;
            }
            // 4) 대기트럭 존재하면서 대기트럭의 무게와 다리위의 현재무게가 다리무게보다 작거나 같은경우
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("final : " + solution(2,10, new int[]{7}));
     
    }
}