import java.util.*;

public class Cover {
    static int[][][] coverType = { { { 0, 0 }, { 0, 1 }, { 1, 0 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } } };

    static int[][] board;

    // 1. init
    // 1 : 덮힘, 0 : 안덮힘
    public static void init(int x, int y, String[][] current) {
        board = new int[x][y];

        for (int i = 0; i < current.length; i++) {
            String[] c = current[i][0].split("");
            for (int j = 0; j < c.length; j++) {
                if (c[j].equals("#")) {
                    board[i][j] = 1;
                }
            }
        }

        System.out.println(cover(board));
    }

    // 2.

    public static int cover(int[][] board) {

        // 1. 기저사례
        // 1) 안덮힌 개수 % 3 !=0 인경우
        int unCoverCnt = 0;
        for (int[] bd : board) {
            for (int b : bd) {
                if (b == 0) {
                    unCoverCnt++;
                }
            }
        }

        if (unCoverCnt % 3 != 0) {
            System.out.println("기저사례 1");
            return 0;
        }

        // 2) 모두 다 덮은 경우
        int x = -1;
        int y = -1;
        loop: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break loop;
                }
            }
        }

        if (x == -1 && y == -1) {
            return 1;
        }

        int ret = 0;
        for (int type = 0; type < 4; type++) {
            // 유효성 통과 여부
            if (isGoing(x, y, type, 1)) {
                ret += cover(board);
            }
            // 유효성 통과 여부와는 상관없이 이전에 덮은 걸 원상복구 시킨다.
            isGoing(x, y, type, -1);
        }

        return ret;

    }

    // 3. 유효성 검사
    public static boolean isGoing(int x, int y, int type, int flag) {
        boolean answer = true;

        for (int i = 0; i < 3; i++) {

            int moveX = x + coverType[type][i][0];
            int moveY = y + coverType[type][i][1];

            // 1) 범위가 넘은 경우
            if (moveX < 0 || moveX >= board.length || moveY < 0 || moveY >= board[moveX].length) {
                answer = false;
                // 2) 이미 덮여 있는 경우
                // * 우선 1을 더해준다
                // * 나중에 원상복구 시킬 때 안덮힌경우로 변경되는걸 방지위해
            } else if (board[moveX][moveY] + flag > 1) {
                board[moveX][moveY] += flag;
                answer = false;
                // 3) 그 외엔 정상이므로 덮어 준다.
            } else {
                board[moveX][moveY] += flag;
            }

        }
        return answer;

    }

    public static void main(String[] args) {
        int x = 3;
        int y = 7;
        String[][] current = { { "#.....#" }, { "#.....#" }, { "##..###" } };

        // int x = 8;
        // int y = 10;
        // String[][] current = { { "##########" }, { "#........#" }, { "#........#" },
        // { "#........#" }, { "#........#" },{ "#........#" }, { "#........#" }, {
        // "##########" } };
        init(x, y, current);
    }

}
