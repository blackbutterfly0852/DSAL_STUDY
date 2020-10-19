import java.util.Arrays;

public class R_DfsBfs_2 {

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            answer += dfs(i, computers, visited);
        }
        return answer;
    }

    public static int dfs(int start, int[][] computers, boolean[] visited) {

        if (visited[start]) {
            return 0;
        } 
        
        visited[start] = true;
        
        for (int i = 0; i < computers[start].length; i++) {
            if (start != i && !visited[i] && computers[start][i] == 1) {
                dfs(i, computers, visited);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int n = 3;
        // int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

        System.out.println(solution(n, computers));
    }

}
