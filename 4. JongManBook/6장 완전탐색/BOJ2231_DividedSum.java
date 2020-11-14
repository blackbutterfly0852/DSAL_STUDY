import java.util.*;

public class BOJ2231_DividedSum {
    // 1. 시간복잡도 확인(== 경우의 수 확인)
    // 1) 1,000,000 * 990,000 = 990,000,000,000 == 9천억? -> 실패 가능성 有 -> 이 문제를 범위를 어떻게 줄이느냐가 핵심.

    // 2. 첫번째 접근 방법 
    // 1) M은 N보다 작다
    // 2) M과 N은 최대 1자리까지만 차이 난다. -> M의 최소값을 N의 자릿수 -1 로 생각했다.
    // 3) M이 커질 수록 N이 계속 커지는 것은 아니다.
    public static int solution_1(int N) {

        String nToString = Integer.toString(N);
        int min = (int) Math.pow(10, nToString.length() - 2);
        // System.out.println("min : " + min);
        int ret = 987654321;
        for (int i = min; i < N; i++) {
            int cRet = i;
            String[] startToString = Integer.toString(i).split("");
            for (String s : startToString) {
                cRet += Integer.parseInt(s);

            }
            if (cRet == N) {
                ret = Math.min(ret, i);
                break;
            }

        }

        return ret == 987654321 ? 0 : ret;

    }

    // 3. 두번째 접근 방법 
    // 1) M은 N보다 작다
    // 2) M이 커질 수록 N이 계속 커지는 것은 아니다.
    // 3) 전체조회
   
    public static int solution_2(int N) {

        int ret = 987654321;
        for (int i = 1; i < N; i++) {
            int cRet = i;
            String[] startToString = Integer.toString(i).split("");
            for (String s : startToString) {
                cRet += Integer.parseInt(s);

            }
            if (cRet == N) {
                ret = Math.min(ret, i);
                break;
            }

        }

        return ret == 987654321 ? 0 : ret;

    }
    // 4. 회고
    // 1) 시간 및 공간 제약이 정답안에 가까스로 포함된다.
    // 2) 시간 및 공간 복잡도를 낮춰야 한다.
    public static int solution_3(int N) {
        // 5. 개선할 점
        // 1) 탐색 범위를 줄이자
        // 2) M + K = N에서 3개의 문자는 모두 양수 -> M이 커지면 K가 작아지고 M이 작아지면 K가 커진다.
        // 3) K는 자리 수의 숫자를 더한 것 -> 각 자리수는 0~9까지 존재. 그럼 K의 값은 M의 자리수를 기준으로 할지 N의 자리수를
        // 기준으로 할지 정해야 된다.
        // 4) M의 최소값을 구하므로(M의 값을 모른다.), N의 자리수를 기준으로 K의 최대값 (N의 자리수 x 9) 을 구한다.
        // 5) K의 최대값이 M의 최소값이므로 M의 탐색범위는 N-K <= M < N이 된다.
        // ex) N이 227일 때 M의 최소는 200 -> 만약 199이면? N이 세 자리이므로 (그냥) 최대 27을 더해도 226으로 227이 될 수 없음.

        String nToString = Integer.toString(N);
        int length = nToString.length();
        int min = N - (9 * length);

        int ret = 0;

        for (int i = min; i < N; i++) {

            int compare = i;
            int div = i;
            // TIP : 각 자리수를 더하는 방법 % 10
            while (div > 0) {
                compare += div % 10;
                div = div / 10;
            }

            if (compare == N) {
                ret = i;
                break;
            }

        }

        return ret;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(solution_1(sc.nextInt()));

    }
}
