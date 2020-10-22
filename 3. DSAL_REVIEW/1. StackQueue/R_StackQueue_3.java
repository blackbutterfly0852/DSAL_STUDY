import java.util.*;

public class R_StackQueue_3 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 초기화
        Queue<Integer> trucks = new LinkedList<Integer>();
        Queue<Integer> curBridge = new LinkedList<Integer>();

        for (int truck : truck_weights) {
            trucks.add(truck);
        }
        for (int i = 0; i < bridge_length; i++) {
            curBridge.add(0);
        }

        int exitCnt = 0;
        int answer = 0;
        // 참고
        // 기존과 비교
        // 공통점 : 먼저 추출
        // 차이점 : while 문 Break 방법, 현재 무게 검증방법
        while (exitCnt != truck_weights.length) {
            answer++;
            int cur = curBridge.poll();
            if (cur != 0) {
                exitCnt++;
            }
            if (!trucks.isEmpty() && curBridgeSum(curBridge) + trucks.peek() <= weight) {
                curBridge.add(trucks.poll());
            } else {
                curBridge.add(0);
            }
        }
        return answer;
    }

    // 현재 다리 무게의 합

    public static int curBridgeSum(Queue<Integer> curBridge) {
        int sum = 0;
        Iterator it = curBridge.iterator();
        while (it.hasNext()) {
            sum += (int) it.next();
        }
        return sum;
    }

    // 다른 사람 풀이
    static class Truck {
        int weight;
        int move;

        Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        void moving() {
            move++;
        }
    }


    public static int solution_2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> waitQ = new LinkedList<Truck>();
        Queue<Truck> moveQ = new LinkedList<Truck>();

        for(int truck : truck_weights){
            waitQ.add(new Truck(truck));
        }

        int cur_weight = 0;

        while(!waitQ.isEmpty() || !moveQ.isEmpty()){
            answer ++;
            if(moveQ.isEmpty()){
                Truck t = waitQ.poll();
                cur_weight += t.weight;
                moveQ.add(t);
                continue;
            }

            for(Truck t : moveQ){
                t.moving();
            }
            // 참고
            // 기존과 다른점 : 트럭 클래스의 내부 변수로 얼만큼 움직였는지 확인
            if(moveQ.peek().move > bridge_length){
                Truck t = moveQ.poll();
                cur_weight -= t.weight;
            }

            if(!waitQ.isEmpty() && cur_weight + waitQ.peek().weight <= weight){
                Truck t = waitQ.poll();
                cur_weight += t.weight;
                moveQ.add(t);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("final : " + solution_2(2, 10, new int[] { 7, 4, 5, 6 }));
        System.out.println("final : " + solution_2(100,100, new int[]{10}));
        System.out.println("final : " + solution_2(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
    }

}
