import java.util.Comparator;
import java.util.*;

public class R_Heap_2 {

    static class Job {

        int start;
        int time;
        int finish;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        // 1. 요청 순으로 정렬
        PriorityQueue<Job> timeA = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job current, Job last) {
                if (current.start > last.start) {
                    return 1;
                } else if (current.start == last.start) {
                    if (current.time > last.time) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        for (int[] job : jobs) {
            timeA.offer(new Job(job[0], job[1]));
        }

        int totalTime = 0;
        List<Job> finalJob = new ArrayList<Job>();
        List<Job> inJob = new ArrayList<Job>();
        while (!timeA.isEmpty() || inJob.size() != 0) {

            // 2. 종속작업 확인
            while (!timeA.isEmpty()) {
                Job j = timeA.poll();
                System.out.println("종속작업 확인 = " + j.start + " " + j.time);
                if (j.start <= totalTime) {
                    inJob.add(j);
                } else {
                    timeA.offer(j);
                    break;
                }
            }

            // 2-1. 종속작업이 있는 경우 -> 작업시간이 빠른 순으로 정렬
            if (!inJob.isEmpty()) {
                Collections.sort(inJob, new Comparator<Job>() {
                    @Override
                    public int compare(Job current, Job last) {
                        if (current.time > last.time) {
                            return 1;
                        }
                        return -1;
                    }
                });
                // 참고
                // 종속작업이 여러 개 있어도 하나씩 처리
                // 해당 종속작업이 추가된 후 누적 작업 시간이 결정되며
                // 이는 다시 이전에 추가를 못했던 종속작업을 재추가 가능성이 존재한다.
                Job j = inJob.remove(0);
                System.out.println("종속작업 확인2 = " + j.start + " " + j.time);
                j.finish = totalTime + j.time;
                totalTime += j.time;
                finalJob.add(j);

            // 2-2. 종속작업이 없는 경우 -> 요청 시간 중 가장 빠른 하나만 추출
            } else {
                Job j = timeA.poll();
                j.finish = j.start + j.time;
                totalTime = j.finish;
                finalJob.add(j);
            }

            System.out.println("================");

        }

        for (Job j : finalJob) {
            System.out.println("final Job = " + j.start + " " + j.time + " " + j.finish);
            answer += j.finish - j.start;
        }
        System.out.println("answer = " + answer);

        return answer / finalJob.size();
    }

    public static void main(String[] args) {
        int[][] jobs_0 = { { 0, 3 }, { 1, 9 }, { 2, 6 } }; // 9
        int[][] jobs_1 = { { 0, 3 }, { 4, 4 }, { 9, 4 } }; // 3
        int[][] jobs_2 = { { 0, 10 }, { 2, 10 }, { 9, 10 }, { 15, 2 } }; // 14 #
        int[][] jobs_3 = { { 0, 4 }, { 6, 1 }, { 6, 3 } }; // 3
        int[][] jobs_4 = { { 0, 10 }, { 2, 10 }, { 25, 10 }, { 25, 2 } }; // 10 #

        System.out.println(solution(jobs_2));

    }

}
