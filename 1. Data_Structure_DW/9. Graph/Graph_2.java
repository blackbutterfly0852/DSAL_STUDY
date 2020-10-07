import java.util.*;

public class Graph_2 {

    static class Node {
        private final int num;
        HashSet<Integer> win = new HashSet<>(); // 해당 노드가 이긴 경우
        HashSet<Integer> lose = new HashSet<>(); // 해당 노드가 진 경우

        public Node(int num) {
            this.num = num;
        }
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        // 1. 초기화
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < n + 1; i++) {
            nodes.add(new Node(i));
        }

        // int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        for (int[] r : results) {
            nodes.get(r[0]).win.add(r[1]);
            nodes.get(r[1]).lose.add(r[0]);
        }

        // 2. 해당 노드가 이긴경우는 진 경우들을 이긴경우에 모두 add
        for (int k = 0; k < n; k++) {
            for (int i = 1; i < nodes.size(); i++) {
                HashSet<Integer> winList = nodes.get(i).win; // 5
                HashSet<Integer> loseList = nodes.get(i).lose; // 1,4,3
                Iterator ll = loseList.iterator();
                while (ll.hasNext()) {
                    int lose = (int) ll.next(); // 1,4,3
                    nodes.get(lose).win.addAll(winList);
                }
            }
        }

        // 2. 해당 노드가 진경우는 이긴 경우들을 진 경우에 모두 add
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < nodes.size(); i++) {
                HashSet<Integer> winList = nodes.get(i).win; // 5
                HashSet<Integer> loseList = nodes.get(i).lose; // 1,4,3
                Iterator ll = winList.iterator();
                while (ll.hasNext()) {
                    int win = (int) ll.next(); // 1,4,3
                    nodes.get(win).lose.addAll(loseList);
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            int winSize = nodes.get(i).win.size();
            int loseSize = nodes.get(i).lose.size();

            if (winSize + loseSize == n - 1) {
                answer++;
            }

        }
        return answer;

    }

    public static void main(String[] args) {

        int n = 5;
        // int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int[][] results = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        System.out.println(solution(n, results));

    }
}
