import java.util.*;

// DFS/BFS_1 타켓 넘버 1 -> https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4?category=929770 참조
public class DfsBfs_1 {

    public static int dfs(int sum, int idx, int[] numbers, int target) {
        if (idx >= numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int answer = 0;
        int plus = numbers[idx];
        int minus = -numbers[idx];
        answer += dfs(sum + plus, idx + 1, numbers, target);
        answer += dfs(sum + minus, idx + 1, numbers, target);
        return answer;
    }

    public static class BfsClass {
        int sum;
        int idx;

        public BfsClass(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        // answer = dfs(0,0,numbers,target);

        Queue<BfsClass> bfsQ = new LinkedList<BfsClass>();
        bfsQ.add(new BfsClass(numbers[0], 0));
        bfsQ.add(new BfsClass(-numbers[0], 0));

        while (!bfsQ.isEmpty()) {
            BfsClass queue = bfsQ.poll();

            if (queue.idx >= numbers.length - 1) {
                if (queue.sum == target) {
                    answer += 1;
                }
                continue;
            }
            int cur_plus = queue.sum + numbers[queue.idx+1];
            int cur_minus = queue.sum - numbers[queue.idx+1];
            bfsQ.add(new BfsClass(cur_plus, queue.idx + 1));
            bfsQ.add(new BfsClass(cur_minus, queue.idx + 1));
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(solution(numbers, target));
    }

}