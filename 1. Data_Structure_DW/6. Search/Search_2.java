import java.util.*;

// 완전탐색 - 소수찾기
public class Search_2 {
    static Set<Integer> isExist = new HashSet<Integer>();

    public static int solution(String numbers) {
        int answer = 0;

        int length = numbers.length();
        // 1. numbers의 순열 구하기
        for (int i = 1; i < length + 1; i++) {
            char[] output = new char[length];
            boolean[] visited = new boolean[length];
            isPermutation(numbers, output, visited, 0, length, i);
        }
        for (int num : isExist) {
            // System.out.println("num : " + num);
            if (isOne(num) && num > 1) {
                answer += 1;
            }
        }
        // 2. 소수 이면 answer +1;
        return answer;
    }

    // 1. numbers의 순열 구하기
    public static void isPermutation(String numbers, char[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String element = "";
            for (int i = 0; i < r; i++) {
                element += output[i];
            }
            isExist.add(Integer.parseInt(element));
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[depth] = numbers.charAt(i);
                isPermutation(numbers, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 2. 소수 판별 함수 true : 소수, false : 소수 X
    public static boolean isOne(int num) {
        boolean answer = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return answer;
    }

    // 다른 사람 풀이(순열)
    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        // if (n == 0) System.out.println(prefix);
        if (!prefix.equals("")){
            System.out.println("prefix : " + prefix);
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++){
            System.out.println(prefix + str.charAt(i) + " " + str.substring(0, i) + str.substring(i + 1, n) );
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("011"));
        HashSet<Integer> list = new HashSet<Integer>();
        permutation("","123",list);

    }

}