import java.util.*;

public class BOJ2798_BlackJack {
    // 1. 시간복잡도 확인(== 경우의 수 확인)
    // 1) 10 C 3 = 120 가지 -> 완전탐색 가능
    public static int solution(int[] list, int m, int sum, int cnt, int idx) {
        // 2. 기저사례
        // 1) 더한 값이 m 보다 크면 0으로 리턴한다.
        if(sum > m) return 0;
        // 2) 더한 갯수가 3개 일 때 리턴한다.
        if (cnt == 3) {
            return sum > m ? 0 : sum;
        }
        // 3. 접근 방식 
        // 1) 기저사례에서 m 값보다 크면 0을 리턴한다
        // 2) 즉, m 값보다 큰 값이 리턴은 안된다.
        // 3) 처음 접근한 방식은 m값과 차이값이 가장 작은 sum값을 구했지만
        // 4) 불필요한 연산과정만 추가될 뿐, 처음부터 최대값을 찾으면 된다. 
        int max = 0;

        for (int i = idx; i < list.length; i++) {
            max = Math.max(max, solution(list, m, sum + list[i], cnt + 1, i + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        System.out.println(solution(list, m, 0, 0, 0));

    }

}
