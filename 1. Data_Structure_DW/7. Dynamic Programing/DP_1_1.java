
// 다른사람 풀이
// 나의 개념을 깔끔하게 정리한 것
import java.util.ArrayList;
import java.util.HashSet;

public class DP_1_1 {
    static HashSet<Integer> check = new HashSet<Integer>();
    static ArrayList<Integer>[] cache = new ArrayList[9];

    public static int add(int left, int right) {
        return left + right;
    }

    public static int sub(int left, int right) {
        return left - right;
    }

    public static int mul(int left, int right) {
        return left * right;
    }

    public static int div(int left, int right) {
        if (right == 0)
            return 0;
        return left / right;
    }

    public static void addCache(int digit, int ret) {
        if (!check.contains(ret)) {
            check.add(ret);
            cache[digit].add(ret);
        }
    }

    public static void cal(int digit, int left, int right) {
        addCache(digit, add(left, right));
        addCache(digit, sub(left, right));
        addCache(digit, mul(left, right));
        addCache(digit, div(left, right));
    }

    public static int solution(int N, int number) {

        if (N == number) {
            return 1;
        }

        int temp = N;
        for (int i = 1; i < 9; i++) {
            if (temp == number)
                return i;
            cache[i] = new ArrayList<Integer>();
            cache[i].add(temp);
            check.add(temp);
            temp *= 10;
            temp += N;
        }

        for (int digit = 1; digit < 9; digit++) { // 3
            for (int i = 1; i < digit; i++) { // 1, 2
                int j = digit - i; // i,j = 1,2 // 2,1
                for (int left : cache[i]) {
                    for (int right : cache[j]) {
                        cal(digit, left, right);
                        if (check.contains(number)) {
                            return digit;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

}
