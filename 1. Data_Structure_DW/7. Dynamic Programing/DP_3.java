public class DP_3 {

    public static int solution(int m, int n, int[][] puddles) {

        int[][] count = new int[n + 2][m + 2];
        count[1][1] = 1;

        boolean[][] notGo = new boolean[n + 2][m + 2];
        for (int x = 0; x < puddles.length; x++) {
            // 좌표 혼동 유의
            notGo[puddles[x][1]][puddles[x][0]] = true;
        }

        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < m + 1; y++) {
                if (x == 1 && y == 1) {
                    continue;
                }
                // System.out.println(x+" "+y);
                if (!notGo[x][y]) {
                    // 중간과정 중, 최단 경로의 수가 int형 범위를 넘을 수 있기 때문에 미리 나머지를 구해준다.
                    // 그렇다면, 먼저 나머지를 구하고 나머지끼리 더한 다음, 다시 나머지를 구해도 답은 맞다.
                    // 경우의 수가 굉장히 많고, 특정(1억이상) 수로 나눌 경우, int 형 범위를 생각해보고, 미리 나머지를 구할 수 있는 부분은 먼저 구한다.
                    count[x][y] = (count[x][y - 1] + count[x - 1][y]) % 1000000007;
                }
            }
        }
        return count[n][m];
    }

    public static void main(String[] args) {
        // int m = 5;
        // int n = 4;
        // int[][] puddles = {{2,1},{2,2},{2,3},{4,4},{4,3},{4,2}} ;

        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };

        System.out.println(solution(m, n, puddles));
    }

}
