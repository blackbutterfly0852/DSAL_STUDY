// 1. N으로 표현
// 1) 동적계획법 문제다
// 2) 세 자리를 이용하는 경우, (한 자리와 두 자리의 조합, 두 자리와 한 자리의 조합) 동시에 진행을 해야한다.
//    (1) "-", "/" 는 앞뒤가 변경된 경우 값이 달라질 수 있기 때문
// 3) 즉, 각 사용한 갯수의 집합은 고유해야한다. 집합끼리 공통 분모가 있어서는 안된다.
// 4) 기타
//    (1) 하나의 set을 선언하고, 2개의 ArrayList에 동시에 넣을 경우 set에 데이터 추가시 ArrayList에 동시에 업데이트 된다.(같은객체)
import java.util.*;
public class DP_1 {
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    static HashSet<Integer> check = new HashSet<Integer>();

    public static int solution(int N, int number) {
        int answer = -1;
        int setting = 0;
        for (int n = 0; n < 8; n++) {
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(10 * setting + N);
            check.add(10 * setting + N);
            list.add(set);
            setting = 10 * setting + N;
            
        }

        for (int i = 0; i < list.size(); i++) { // i = 0~7
            for (int j = 0; j < i; j++) {
                int m = i - j;
                cal(i, j, m - 1);
            }
            if (list.get(i).contains(number)) {
                return i + 1;
            }
        }
        return answer;
    }

    public static void cal(int i, int j, int m) {

        for (int one : list.get(j)) {
            for (int two : list.get(m)) {
                int add = one + two;

                if (!check.contains(add)) {
                    check.add(add);
                    list.get(i).add(add);
                }
                int sub = one - two;
                if (!check.contains(sub)) {
                    list.get(i).add(sub);
                    check.add(sub);
                }
             
                int mul = one * two;

                if (!check.contains(mul)) {
                    list.get(i).add(mul);
                    check.add(mul);
                }

                if (two != 0) {
                    int div = one / two;
                    if (!check.contains(div)) {
                        list.get(i).add(div);
                        check.add(div);
                    }
                }

               
            }

        }
    }

    public static void main(String[] args) {
        int N = 4;
        int number = 17;
        System.out.println(solution(N, number));

      

    }
}