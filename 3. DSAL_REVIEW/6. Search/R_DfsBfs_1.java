public class R_DfsBfs_1 {
    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        dfs(0, target, 0, numbers, visited);
        return answer;
    }

    public static void dfs(int start, int target, int idx, int[] numbers, boolean[] visited) {
        if (idx >= numbers.length && start == target) {
            answer++;
            return;
        } else if (idx >= numbers.length) {
            return;
        } else {

            if (!visited[idx]) {
                visited[idx] = true;
                dfs(start + numbers[idx], target, idx + 1, numbers, visited);
                dfs(start - numbers[idx], target, idx + 1, numbers, visited);
                // 다시 돌아와서 시작해야 하기 때문이다.
                visited[idx] = false;
            }
        }
    }

    public static int dfs_2(int start, int target, int idx, int[] numbers ){
        if(idx >= numbers.length){
            if(start == target){
                return 1;
            }else{
                return 0;
            }
        }

        int answer = 0;
        int plus = numbers[idx];
        int minus = - numbers[idx];

        answer += dfs_2(start + plus,  target,  idx + 1, numbers);
        answer += dfs_2(start + minus, target,  idx + 1, numbers);

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(solution(numbers, target));

    }
}
