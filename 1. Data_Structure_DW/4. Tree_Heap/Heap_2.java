import java.util.*;

public class Heap_2 {

    // SortClass : 종속작업인경우, 작업시간이 짧은 기준으로 정렬
    private static class SortClass implements Comparable<SortClass> {
        int startPoint = 0;
        int workTime = 0;

        public SortClass(int startPoint, int workTime) {
            this.startPoint = startPoint;
            this.workTime = workTime;
        }
        // 종속작업인경우, 작업시간이 짧은 기준으로 정렬
        @Override
        public int compareTo(SortClass target) {
            if (this.workTime > target.workTime) {
                return 1;
            } else if (this.workTime <= target.workTime) {
                return -1;
            }
            return 0;
        }
    }
 
    // * 현 작업의 요청시간이 누적작업시간 보다 작거나 같은 경우 insert
    // * answer = (누적작업시간 - 현 작업의 요청시간) + 누적작업시간
    // * 이전 작업에 종속되는 경우(중요) 
    // -> 누적작업시간 += 현 작업의 작업시간
    // * 이전 작업과 별개로 시작하는 하는 경우(중요)
    // -> 누적작업시간 = 현 작업의 요청시간
    public static int solution(int[][] jobs) {
        // 1. 초기화
        int answer = 0;
        int workTime = 0; // 누적작업시간
        int idx = 0;
        PriorityQueue<SortClass> pg = new PriorityQueue<SortClass>(); // 작업시간 기준으로 오름차순 // 0,3 / 2,6 / 1,9
        ArrayList<int[]> jobList = new ArrayList<int[]>();
        for(int[] job : jobs){
            jobList.add(job);
        }
        Collections.sort(jobList,(j1,j2) -> j1[0] - j2[0]); // 요청시간 기준으로 오름차순 0,3 / 1,9 / 2,6
        
        // 2. idx와 pg.size()를 기준으로 작업시작
        while (idx < jobList.size() || pg.size() != 0) {
            // 2-1. 현 작업의 요청시간이 누적작업시간 보다 작거나 같은 경우 insert 
            //      -> 작업 중인데 다른 작업 요청이 들어오는 경우  
            while (idx < jobList.size() && jobList.get(idx)[0] <= workTime) {
                pg.add(new SortClass(jobList.get(idx)[0], jobList.get(idx)[1]));
                idx += 1; // idx : 1 // idx : 3
            } 
            // 2-2. 이전 작업에 종속되는 경우
            if (pg.size() != 0) { // 2
                SortClass sort = pg.poll();
                // answer = (누적작업시간 - 현 작업의 요청시간) + 현 작업의 작업시간 -> 현 작업의 요청시간부터 완료시간까지 소요시간
                answer += (workTime - sort.startPoint) + sort.workTime; // 3 // 10 // 27
                // 누적작업시간 += 현 작업의 작업시간
                workTime += sort.workTime; // 3 // 9 // 18 
            // 2-3. 이전 작업과 별개로 시작하는 하는 경우
            } else {
                workTime = jobList.get(idx)[0];
            }
        }
        return answer / jobs.length;
    }


    public static void main(String[] args) {
        int[][] jobs_0 = { { 0, 3 }, { 1, 9 }, { 2, 6 } }; //9
        int[][] jobs_1 = { { 0, 3 }, { 4, 4 }, { 9, 4 } }; // 3
        int[][] jobs_2 = { { 0, 10 }, { 2, 10 }, { 9, 10 }, { 15, 2 } }; // 14
        int[][] jobs_3 = { { 0, 4 }, { 6, 1 }, { 6, 3 } }; // 3
        int[][] jobs_4 = { { 0, 10 }, { 2, 10 }, { 25, 10 }, { 25, 2 } }; // 10

        System.out.println(solution(jobs_4));

    }

}