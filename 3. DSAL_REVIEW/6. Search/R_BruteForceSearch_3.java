import java.util.Arrays;

public class R_BruteForceSearch_3 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        // 참고
        // Total이 아니라 brown까지 For문
        // 가로의 최대값은 brown이기 때문
        for (int brownWidth = 1; brownWidth <= brown; brownWidth++) {
            if (total % brownWidth == 0) {
                int x = total / brownWidth;
                if ((brownWidth - 2) * (x - 2) == yellow) {
                    answer[0] = brownWidth;
                    answer[1] = x;
                }
            }
        }

        return answer;
    }

    // 참고
    // 기하학 풀이
    // 내부 사각형을 감싸고 있는 전체 사각형의 가로, 세로의 차는
    // 전체 사각형의 (가로 + 세로 ^ 2) - (내부 사각형의 크기 * 4)의 제곱근
    // 전체 사각형의 가로는 ((가로+세로) + 제곱근값) /2, 세로는 ((가로+세로) - 제곱근값) /2
    // 위의 가로 세로는 문제에 따라 달라질 수 있다.
    public static int[] solution_2(int brown, int yellow) {
        int b_w_h = (brown + 4) / 2;
        int total = brown + yellow;

        int width = (int) ((b_w_h + Math.sqrt((b_w_h * b_w_h) - (4 * total))) / 2);
        int height = (int) ((b_w_h - Math.sqrt((b_w_h * b_w_h) - (4 * total))) / 2);
        int[] answer = { width, height };

        return answer;

    }

    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        solution_2(brown, yellow);

    }
}
