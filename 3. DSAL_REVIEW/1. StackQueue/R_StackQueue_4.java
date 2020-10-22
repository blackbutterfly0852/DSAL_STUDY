import java.util.*;

public class R_StackQueue_4 {

    static class Print {

        int locat;
        int prior;

        Print(int locat, int prior) {
            this.locat = locat;
            this.prior = prior;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // 1. 초기화
        Queue<Print> que = new LinkedList<Print>();
        List<Print> list = new ArrayList<Print>();
        for (int i = 0; i < priorities.length; i++) {
            que.add(new Print(i, priorities[i]));
        }

        // 2. 현재 우선순위와 나머지 우선순위 비교
        while (!que.isEmpty()) {
            Print p = que.poll();
            if (isCompare(p.prior, que)) {
                list.add(p);
            } else {
                que.add(p);
            }
        }

        // 3. 출력 순서
        for (int i = 0; i < list.size(); i++) {
            Print p = list.get(i);
            if (p.locat == location) {
                answer = i + 1;
            }
        }
      
        return answer;
    }

    // 현재 우선순위와 나머지 우선순위 비교
    public static boolean isCompare(int current, Queue<Print> que) {

        Iterator it = que.iterator();
        while (it.hasNext()) {
            Print p = (Print) it.next();
            int lastPrior = p.prior;

            if (current < lastPrior) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
        System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
    }

}
