// 동적 계획법(Dynamic Programming)과 분할 정복(Divide and Conquer)
// 동적 계획법(DP) 
// -> 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을                                                                                                          이용해서 상위 문제를 풀어가는 방식
// -> Memoization : 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 기술
// 분할 정복(DC)
// -> 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
// -> 문제를 잘게 쪼갤 때, 부분 문제는 서로 중복되지 않음
// -> 재귀함수
// -> 병합정렬, 큌정렬

// 공통점
// -> 문제를 잘게 쪼개서, 가장 작은 단위로 분할
// 차이점
// 동적 계획법
// -> 부분 문제는 중복되어, 상위 문제 해결 시 재활용됨
// -> Memoization 기법 사용 (부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용)
// 분할 정복
// -> 부분 문제는 서로 중복되지 않음
// -> Memoization 기법 사용 안함

import java.util.*;

public class DP_DC {
    // fibonachi : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    // 다음 피보나치 수열은 바로 앞의 두 수의 합
    // num -> idx 순이랑 동일 ex) num = 10 -> 11번째

    // 1. fibonachi_DP
    public static int fibonachi_DP(int num) {
        int[] list = new int[num + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < num + 1; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[num];
    }

    // 2. fibonachi_DC
    public static int fibonachi_DC(int num) {
        if (num <= 1) {
            return num;
        } else {
            return fibonachi_DC(num - 1) + fibonachi_DC(num - 2);
        }
    }

    // 200831 코딩인터뷰 완전 분석(P.192~), 재귀와 동적계획법

    // 1. 일반적인 재귀
    // 1) fi_1(5) -> fi_1(3) 2번 호출, fi_1(2) 3번 호출, O(2^N)
    // 2) 재귀 호출을 트리로 그려 보는 것은 재귀적 알고리즘의 수행시간을 알아내는데 효과적이다.
    public static int fi_1(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return fi_1(i - 1) + fi_1(i - 2);
    }

    // 2. 일반적인 재귀 + 캐쉬 저장 -> fi_1(3) 2번, fi_1(2) 3번 중복 호출 제거, O(N)
    // 1) 동적프로그래밍 : 재귀적 알고리즘 + 반복적으로 호출되는 부분문제를 찾는게 핵심.
    // 2) 부분문제를 찾아 캐쉬에 저장 -> 메모리제이션
    // 3) 어느 노드에서 캐쉬값을 반환하고 어느 노드에서 가지를 확장에 나갈지를 결정하면 된다.
    public static int fi_2(int i, int[] list) {
        if (i == 0 || i == 1) {
            return i;
        }
        if (list[i] == 0) {
            list[i] = fi_2(i - 1, list) + fi_2(i - 2, list);
        }
        return list[i];
    }

    // 3. 상향식
    public static int fi_3(int i, int[] list) {

        list[0] = 0;
        list[1] = 1;
        for (int j = 2; j < i; j++) {
            list[j] = list[j - 1] + list[j - 2];
        }
        return list[i - 1] + list[i - 2];
    }

    // 4. 변수 몇 개 많으로 활용 가능
    public static int fi_4(int i) {
        if (i == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;

        for (int j = 2; j < i; j++) {
            int c = a + b;
            a = b;
            b = c;

        }
        return a + b;

    }

    public static void main(String[] args) {
        // System.out.println("DP : " + fibonachi_DP(10));
        // System.out.println("DC : " + fibonachi_DC(10));
        System.out.println("DC : " + fi_4(5));
    }

}