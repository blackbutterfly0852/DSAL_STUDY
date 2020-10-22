import java.util.*;

public class R_StackQueue_2 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // 1. 작업일수 계산
        int[] jobTime = calJobTime(progresses, speeds);
        System.out.println(Arrays.toString(jobTime));

        // 2. 동시 배포 계산
        List<Integer> tmp = new ArrayList<Integer>();
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        for (int i = 1; i < jobTime.length; i++) {
            while (!que.isEmpty() && jobTime[que.peek()] < jobTime[i]) {
                tmp.add(que.size());
                while (!que.isEmpty()) {
                    que.poll();
                }
            }
            que.add(i);
        }

        // 3. queue에 남아있는 최종 원소들은 동시에 배포
        tmp.add(que.size());

        answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int[] calJobTime(int[] progresses, int[] speeds) {
        int[] jobTime = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            // if((100-progresses[i]) % speeds[i] == 0){
            // jobTime[i] = (100-progresses[i]) / speeds[i];
            // }else{
            // jobTime[i] = (100-progresses[i]) / speeds[i] + 1;
            // }

            // 참고
            // Math.ceil : 해당 수 보다 크거나 같은 정수.
            // ex) Math.ceil(7.3) == 8 , Math.ceil(-4.3) == -4
            jobTime[i] = (int) Math.ceil((double) 100 - progresses[i] / (double) speeds[i]);
        }
        return jobTime;
    }

    public static void main(String[] args) {

        // int[] progresses = {93, 30, 55};
        // int[] speeds = {1,30,5};

        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        solution(progresses, speeds);

    }
}
