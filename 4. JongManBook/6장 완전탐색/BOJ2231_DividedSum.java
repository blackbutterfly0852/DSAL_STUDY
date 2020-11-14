import java.util.*;

public class BOJ2231_DividedSum {

    public static int solution(int n) {
        // 1. 시간복잡도 확인(== 경우의 수 확인)
        // 1) 1,000,000 * 990,000 = 990,000,000,000 == 9천억? -> 실패 가능성 有
        
        // 2. 첫번째 접근 방법 : 실패 -> 2번 조건 포함
        // 1) M은 N보다 작다
        // 2) M과 N은 최대 1자리까지만 차이 난다.
        // 3) M이 커질 수록 N이 계속 커지는 것은 아니다.

        // 3. 두번째 접근 방법 : 성공 -> 2번 조건 제외
        // 1) M은 N보다 작다
        // 2) M이 커질 수록 N이 계속 커지는 것은 아니다.
        // 3) 즉, 전체조회

        // 4. 회고
        // 1) 시간 및 공간 제약이 정답안에 가까스로 포함된다.
        // 2) 시간 및 공간 복잡도를 낮춰야 한다.
        int ret = 987654321;
        for (int i = 1; i < n; i++) {
            int cRet = i;
            String[] startToString = Integer.toString(i).split("");
            for (String s : startToString) {
                cRet += Integer.parseInt(s);
                
            }
            if (cRet == n) {
                ret = Math.min(ret, i);
                break;
            }

        }

        return ret == 987654321 ? 0 : ret;

    }

    public static void main(String[] args) {
        List<Integer> zeroList = new ArrayList<Integer>();
        List<Integer> trueList = new ArrayList<Integer>();
        List<Integer> falseList = new ArrayList<Integer>();

        // Scanner sc = new Scanner(System.in);
        for (int i = 4; i <= 4; i++) {
            int M = solution(i);
            if (M == 0) {
                zeroList.add(i);
            } else {
                String[] answerToString = Integer.toString(M).split("");
                int N = M;
                for (String s : answerToString) {
                    N += Integer.parseInt(s);
                }
                System.out.println("M : " + M + " N : " + N);
                if (N == i) {
                   
                    trueList.add(i);
                } else {
                    System.out.println("falseList : " + i);
                    falseList.add(i);
                }

            }

        }

        for(int z : zeroList){
            System.out.println("zeroList : " + z);
        }
        for(int t : trueList){
            System.out.println("trueList : " + t);
        }
        for(int f : falseList){
            System.out.println("falseList : " + f);
        }
        

    }

}
