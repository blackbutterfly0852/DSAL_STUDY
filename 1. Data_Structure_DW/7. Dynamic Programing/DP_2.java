import java.util.*;

public class DP_2 {
    // 1. dfs 활용 -> 시간초과(시간복잡도 O(2^n))
    public static int solution_1(int[][] triangle) {
        int first = triangle[0][0];
        return dfs(1, first, triangle, 0);
    }

    public static int dfs(int depth, int sum, int[][] triangle, int locate) {
        // System.out.println(depth + " " + sum + " " + locate);
        if (depth == triangle.length) {
            // System.out.println("sum : " + sum);
            return sum;
        }

        int answer = 0;
        for (int i = locate; i <= locate + 1; i++) {
            answer = Math.max(answer, dfs(depth + 1, sum + triangle[depth][i], triangle, i));

        }
        return answer;
    }

    // 2. 하향식 DP 활용
    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] compare = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            compare[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                compare[i][j] = triangle[i][j];
            }

        }

        // System.out.println(compare == triangle);
        // triangle[0][0] = 99;
        // System.out.println(compare[0][0]);

        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                for (int k = j; k <= j + 1; k++) {
                    compare[i + 1][k] = Math.max(compare[i + 1][k], compare[i][j] + triangle[i + 1][k]);
                    answer = Math.max(answer, compare[i + 1][k]);
                }

            }
        }

        // for (int[] a : compare) {
        // for (int b : a) {
        // System.out.print(b + " ");
        // }
        // System.out.println("");
        // }

        return answer;

    }

    // 3. 다른 사람 풀이(부분 상향식, DP)
    public int solution_3(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            // 1) 양 끝, 즉 겹치지 않은 곳을 먼저 채워 넣어준다. idx 1을 기준으로 idx 0번째를 불러온다.
            triangle[i][0] += triangle[i - 1][0];     // [2,0] -> 3개 첫번째
            triangle[i][i] += triangle[i - 1][i - 1]; // [2,2] -> 3개 마지막
            // 2) 겹치는 부분 계산, 부분 상향식:  [2,1]은 [1,0] [1,1] 중 큰 수를 더해주면 된다.
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]); 
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        // int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 } };
        // int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 } };
        System.out.println(solution(triangle));

    }

}
