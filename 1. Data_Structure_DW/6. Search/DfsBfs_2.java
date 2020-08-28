// DFS/BFS_2 - 네트워크
public class DfsBfs_2 {
    // 그룹핑 문제 -> 그룹핑이 끝나면 1을 더한다. 아래에 return 1; -> 이후 위에 방문했으면 return 0;
    public static int dfs(int n, int[][] computers, boolean[] visited) {

        if (visited[n]) {
            return 0;
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[n][i] == 1 && n != i) {
                visited[n] = true;
                dfs(i, computers, visited);
            }
        }
        return 1;
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            answer += dfs(i, computers, visited);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(solution(n, computers));

    }
}