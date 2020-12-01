import java.util.*;

public class Exam2 {

    public static int solution(int[] A) {
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            if (i != 0) {
                A[i] = A[i - 1];
            }
            // System.out.println("=========================");
            // System.out.println("A = " + Arrays.toString(A));
            if (isOrdered(A)) {
                // System.out.println("count 증가");
                ret++;
            }
            A[i] = tmp;
        }

        return ret;
    }

    public static boolean isOrdered(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOrderedPivot(int[] A, int left, int right) {
        if (right - left <= 1) {
            if (A[left] <= A[right]) {
                return true;
            }
            return false;
        }
        // System.out.println("left = " + left + " " + "right = " + right);
        int left_idx = left;
        int right_idx = right;
        int mid_idx = (left_idx + right_idx) / 2;
        // int pivot = A[mid_idx];

        while (left_idx <= mid_idx) {
            if (A[left_idx] <= A[mid_idx]) {
                left_idx++;
            } else {
                return false;
            }
        }

        while (mid_idx <= right_idx) {
            if (A[right_idx] >= A[mid_idx]) {
                right_idx--;
            } else {
                return false;
            }
        }

        boolean answer1 = isOrderedPivot(A, left, mid_idx - 1);
        boolean answer2 = isOrderedPivot(A, mid_idx + 1, right);

        if (answer1 && answer2) {
            return true;
        } else {
            return false;
        }

    }

    public static int solution_1(int[] A) {

        Stack<Integer> list = new Stack<>();
        return (recursive(A, 0, list));

    }

    public static int recursive(int[] A, int curIdx, Stack<Integer> list) {

        // 기저사례 1 : size가 A.length - 1 인경우
        if (list.size() == A.length - 1) {
            return 1;
        }

        int answer = 0;

        for (int i = curIdx; i < A.length; i++) {
            // 남은 (인덱스의 수)가 (전체개수 - 1 - 현 개수보다 작을 경우 == 스택에 들어가야할 개수)
            if (A.length - i >= A.length - 1 - list.size()) {

                if (list.size() == 0) {
                    list.push(A[i]);
                    answer += recursive(A, i + 1, list);
                    list.pop();
                    // 현재 선택한 요소가 직전 요소보다 작을 경우  현재 선택한 요소를 건너뛰고 다음 요소를 선택한다.
                } else if (list.size() > 0 && A[i] >= list.peek()) {
                    list.push(A[i]);
                    answer += recursive(A, i + 1, list);
                    list.pop();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
         //int[] A = { 3, 4, 5, 4 };
         //int[] A = { 4, 5, 2, 3, 4};
        int[] A = new int[4000];
        for (int i = 0; i < 4000; i++) {
            A[i] = i + 1;
        }
        long startTime = System.currentTimeMillis();
        System.out.println(solution(A));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("걸린 시간 : " + estimatedTime / 1000.0 + " seconds");
        long startTime1 = System.currentTimeMillis();
        System.out.println(solution_1(A));
        long estimatedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("걸린 시간 : " + estimatedTime1 / 1000.0 + " seconds");

    }

}
