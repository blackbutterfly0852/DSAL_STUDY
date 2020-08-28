import java.util.*;
// https://eoghks0521.tistory.com/entry/N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4 참조
public class DP_1 {
    static int answer = -1;

    public static int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }

    public static void dfs(int N, int number, int count, int result) {
        int NN = N; // 5

        if (count > 8) {
            answer = -1;
            return;
        }

        if (result == number) {
            if (count < answer || answer == -1) {
                answer = count;
            }
            return;
        }
        for (int i = 1; i < 9 - count; i++) { // 1 ~ 8
            dfs(N, number, count + i, result + NN); // (5, 12, 0+1, 5)   -> (5,12,2,5+5) ->  (5,12,2,5-5) -> (5,12,2,5*5) -> (5,12,2,5/5)
            dfs(N, number, count + i, result - NN); // (5, 12, 0+1, -5)
            dfs(N, number, count + i, result * NN); // (5, 12, 0+1, 0)
            dfs(N, number, count + i, result / NN); //  X
            NN = NN * 10 + 5;

        }

    }

    public static int addString(String n, int num) {
        String number = "";
        for (int i = 0; i < num; i++) {
            number += n;
        }
        return Integer.parseInt(number);
    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

}