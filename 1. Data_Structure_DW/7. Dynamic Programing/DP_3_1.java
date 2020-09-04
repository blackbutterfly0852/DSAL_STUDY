import java.util.*;
// 등굣길
public class DP_3_1 {
    // 정확성은 맞으나, 효율성 테스트에서 실패
    static int answer = 0;
    public static int solution(int m, int n, int[][] puddles) {
        boolean[][] visited = new boolean[n + 2][m + 2];

        // 웅덩이
        if (puddles.length >= 1) {
            for (int x = 0; x < puddles.length; x++) {
                if(puddles[x].length >=1){
                visited[puddles[x][1]][puddles[x][0]] = true;
                }
            }
        }

        dfs(1, 1, n, m, puddles, visited);

        return answer ;
    }

    public static void dfs(int x, int y, int n, int m, int[][] puddles, boolean[][] visited) {
        if (x == n && y == m) {
            answer += 1;
            answer = answer % 1000000007;
            return;
        }
        int[] move_x = { 0, 1 };
        int[] move_y = { 1, 0 };

        for (int mxy = 0; mxy < 2; mxy++) {
            int xx = x + move_x[mxy];
            int yy = y + move_y[mxy];

            //System.out.println("xx, yy 2 : " + count + " " + xx + yy);
            
            if (xx <= n && yy <= m && !visited[xx][yy]) {
                visited[xx][yy] = true;
                dfs(xx, yy, n, m, puddles, visited);
                visited[xx][yy] = false;
            }

        }

    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { {2,2} };

        System.out.println(solution(m, n, puddles));
    }

}
