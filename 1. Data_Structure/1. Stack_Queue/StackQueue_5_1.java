import java.util.*;

// 프린트
//{2,1,3,2} // 2 -> return 1
public class StackQueue_5_1 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location; // 2
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i : priorities) {
            que.add(i); // {2,1,3,2}
        }
        Arrays.sort(priorities); // {1,2,2,3}
        int size = priorities.length - 1; // 3

        while (!que.isEmpty()) {
            Integer i = que.poll();
            System.out.println("i : " + i);
            System.out.println("priorities[size - answer] : " + priorities[size - answer]);
            // 가장 먼저 나가야 되기 때문
            if (i == priorities[size - answer]) {
                //System.out.println("A");
                answer++;
                l--; // {1,1,1,1,1}
                System.out.println("AString : "  + que.toString());
                System.out.println("Al : " + l);
                if (l < 0)
                    break;
            } else {
                //System.out.println("B");
                que.add(i); // {9,1,1,1,1,1}  {1,1,1,1,1}
                l--;
                System.out.println("BString : "  + que.toString());
                System.out.println("Bl : " + l);
                if (l < 0)
                    l = que.size() - 1;
            }
            System.out.println("---------------------");
        }

        return answer;
    }

    public static void main(String[] args) {
       System.out.println(solution(new int[] { 1,1,9,1,1,1 }, 0)); 
    }
}