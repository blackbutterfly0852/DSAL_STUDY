public class DfsBfs_Review {
    // 1. 타겟넘버
    public static int solution_1(int[] numbers, int target) {
        int answer = 0;
        answer = dfs_1(0, target, numbers, 0);
        return answer;
    }

    public static int dfs_1(int sum, int target, int[] numbers, int idx) {
        // System.out.println(sum + " " + target + " " + idx);
        int answer = 0;
        if (sum == target && idx == numbers.length) {
            return 1;
        }
        if (idx < numbers.length) {
            answer += dfs_1(sum + numbers[idx], target, numbers, idx + 1);
            answer += dfs_1(sum - numbers[idx], target, numbers, idx + 1);
        }
        return answer;
    }

    // 2. 네트워크
    public static int solution_2(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            answer += dfs_2(i, computers, visited);
        }
        return answer;
    }

    public static int dfs_2(int i, int[][] computers, boolean[] visited) {

        if (visited[i]) {
            return 0;
        }

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1) {
                visited[i] = true;
                dfs_2(j, computers, visited);

            }
        }

        return 1;

    }

    // 3. 단어변환
    public static int solution_3(String begin, String target, String[] words) {
        int answer = 0;
        return answer;
    }

    public static int diffCount(String a, String b){
        int count = 0;
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i)){
                count ++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        // 1. 타겟넘버
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        // System.out.println(solution_1(numbers, target));

        // 2. 네트워크
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        // int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        System.out.println(solution_2(n, computers));

        // 3. 단어변환
        String begin = "hit";
        String target_3 = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        
        // String begin = "hit";
        // String target = "lot";
        // String[] words ={"hot", "dot","lot"};

        System.out.println(solution_3(begin, target_3, words));

    }

}