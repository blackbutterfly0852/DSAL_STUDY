import java.util.Arrays;

public class ClockSync {
    static int[][] switchs = { { 0, 1, 2 }, { 3, 7, 9, 11 }, { 4, 10, 14, 15 }, { 0, 4, 5, 6, 7 }, { 6, 7, 8, 10, 12 },
            { 0, 2, 14, 15 }, { 3, 14, 15 }, { 4, 5, 7, 14, 15 }, { 1, 2, 3, 4, 5 }, { 3, 4, 5, 9, 13 } };

    static int[] clocks = new int[16];

    public static void init(int[] initClocks) {
        for (int i = 0; i < initClocks.length; ++i) {
            clocks[i] = initClocks[i];

        }
        System.out.println(solve(clocks, 0));
    }

    // 모두 12시 여부
    public static boolean isAll(int[] clocks) {
        for (int clock : clocks) {
            if (clock != 12) {
                return false;
            }
        }
        return true;
    }

    public static void push(int[] clocks, int current_switch) {
        for (int s : switchs[current_switch]) {

            int switch_clock = clocks[s] + 3;
            if (switch_clock > 12) {
                clocks[s] = 3;
            } else {
                clocks[s] = switch_clock;
            }

        }

    }

    public static int solve(int[] clocks, int current_switch) {
        // 1. 경우의 수 : 4^10 == 2^20 == 1,048,576

        // 2. 기저사례

        // 1) 현재 누를 스위치가 마지막 스위치라면
        if (current_switch == switchs.length) {
            return isAll(clocks) ? 0 : 987654321;
        }

        int ret = 987654321;
        // 3. 재귀함수
        for (int i = 0; i < 4; ++i) {
            ret = Math.min(ret, i + solve(clocks, current_switch + 1));
            push(clocks, current_switch);
        }

        return ret;

    }

    public static void main(String[] args) {

        // ClockSync c = new ClockSync();
        // int[] initClocks = { 12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12,
        // 12 };
        int[] initClocks = { 12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
        init(initClocks);

    }
}
