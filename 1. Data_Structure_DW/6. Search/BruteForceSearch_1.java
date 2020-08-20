// 완전탐색 - 모의고사
import java.util.*;
public class BruteForceSearch_1 {

    public static int[] solution(int[] answers) {
        int[] answer;
        int[] tmp_answer = new int[3];
        int[] people_1 = { 1, 2, 3, 4, 5 };
        int[] people_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] people_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        // 1. 맞은 개수 구하기
        for (int i = 0; i < answers.length; i++) {             // answers : 0,1,2,3,4, 5,6,7,8,9
            if (answers[i] == people_1[i % people_1.length]) { // people  : 0,1,2,3,4, 0,1,2,3,4
                tmp_answer[0] ++;
            }
            if (answers[i] == people_2[i % people_2.length]) {
                tmp_answer[1] ++;
            }
            if (answers[i] == people_3[i % people_3.length]) {
                tmp_answer[2] ++;
            }
        }
        // 다른 사람 풀이 -> int maxScore = Math.max(tmp_answer[0], Math.max(tmp_answer[1], tmp_answer[2]));
        // 2. 경우의 수 리턴
        System.out.println(Arrays.toString(tmp_answer));
        answer = max_value(tmp_answer);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int[] max_value(int[] list) {
        int[] answer = {};
        // idx 기준
        // 1. answer size 3인경우
        if ((list[0] == list[1]) && (list[1] == list[2])) {
            answer = new int[] { 1, 2, 3 };
            return answer;
            // 2. answer size 2인경우
            // 1) list[0] == list[1] > list[2]
        } else if ((list[0] == list[1]) && (list[1] > list[2])) {
            answer = new int[] { 1, 2 };
            return answer;
            // 2) list[0] == list[2] > list[1]
        } else if ((list[0] == list[2]) && (list[2] > list[1])) {
            answer = new int[] { 1, 3 };
            return answer;
            // 3) list[1] == list[2] > list[0]
        } else if ((list[1] == list[2]) && (list[2] > list[0])) {
            answer = new int[] { 2, 3 };
            return answer;
            // 3. answer size 1인경우
            // 1) idx_0 제일 큰 경우
        } else if ((list[0] > list[1]) && (list[0] > list[2])) {
            answer = new int[] { 1 };
            return answer;
            // 2) idx_1 제일 큰 경우
        } else if ((list[1] > list[0]) && (list[1] > list[2])) {
            answer = new int[] { 2 };
            return answer;
            // 3) idx_2 제일 큰 경우
        } else if ((list[2] > list[0]) && (list[2] > list[1])) {
            answer = new int[] { 3 };
            return answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers_1 = { 1, 2, 3, 4, 5 }; // (5,0,0) -> [1]
        int[] answers_2 = { 1, 3, 2, 4, 2 }; // (2,2,2) -> [1,2,3]
        int[] answers_3 = { 4, 4, 4, 5, 1 }; // (0,0,0) -> [1,2,3]
        int[] answers_4 = { 1, 5, 2, 3, 1 }; // (1,2,0) -> [2]
        int[] answers_5 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] answers_6 = {};

        solution(answers_2);
    }

}