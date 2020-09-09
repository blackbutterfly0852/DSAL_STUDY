import java.util.*;

// 징검다리 -> DP, 메모리 초과
public class BinarySearch_2_1 {
    static ArrayList<int[]> combList = new ArrayList<int[]>();

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        boolean[] visited = new boolean[rocks.length];
        comb(rocks, visited, 0, rocks.length, rocks.length - n);
        for (int[] list : combList) {
            Arrays.sort(list);
            //System.out.println("arrays : " + Arrays.toString(list));
            int[] rockList = new int[list.length];
            rockList[0] = 0;
            rockList[rockList.length - 1] = distance;
            for (int i = 1; i < rockList.length - 1; i++) {
                //System.out.println("i+1 : " + (i+1));
                rockList[i] = list[i + 1];
            }
            //System.out.println("rockList : " + Arrays.toString(rockList));
            int[] shortList = new int[list.length + 2];
            shortList[1] = rockList[1];
            for (int j = 2; j < rockList.length; j++) {
                shortList[j] = Math.min(shortList[j - 1], rockList[j] - rockList[j - 1]);

            }
            answer = Math.max(answer, shortList[rockList.length - 1]);

        }
        return answer;
    }

    // 조합
    public static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        if (depth == n) {
            return;
        }
        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    static void print(int[] arr, boolean[] visited, int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                //System.out.print(arr[i] + " ");
                tmp[i] = arr[i];
            }
        }
        System.out.println();
        combList.add(tmp);

    }

    public static void main(String[] args) {
        int distance = 25;
        int rocks[] = { 2, 14, 11, 21, 17 };
        int n = 2;

        System.out.println(solution(distance, rocks, n));
    }


}