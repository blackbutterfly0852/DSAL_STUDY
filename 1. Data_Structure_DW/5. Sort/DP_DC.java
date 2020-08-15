// 동적 계획법(Dynamic Programming)과 분할 정복(Divide and Conquer)
// 동적 계획법(DP) 
// -> 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서 상위 문제를 풀어가는 방식
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
        int[] list = new int[num+1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < num+1; i++) {
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

    public static void main(String[] args) {
        System.out.println("DP : " + fibonachi_DP(10));
        System.out.println("DC : " + fibonachi_DC(10));
    }

}