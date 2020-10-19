import java.util.ArrayList;
import java.util.List;

public class StackQueue_5 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        List<int[]> printList = new ArrayList<>();
        // 1. 인덱스번호로 초기화
        for (int i = 0; i < priorities.length; i++) {
            printList.add(new int[] { i, priorities[i] });
        }

        while (!printList.isEmpty()) {
            int start_order = printList.get(0)[0];
            int start_value = printList.get(0)[1];
            printList.remove(0);

            // System.out.println("startorder : " + start_order + ", " + start_value);
            // System.out.println("printList.size() : " + printList.size());
            int max = 0;

            for (int j = 0; j < printList.size(); j++) {
                if (max <= printList.get(j)[1]) {
                    max = printList.get(j)[1];
                }
            }
            // System.out.println("max : " + max);

            if (start_value < max) {
                // System.out.print("pringList.get(j) : " + printList.get(j)[1]);
                // System.out.println("");
                printList.add(new int[] { start_order, start_value });
                // System.out.println("printList.size()_2 : " + printList.size());

            } else {
                answer += 1;
                if (start_order == location) {
                    return answer;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = { 2, 1, 3, 2 };
        //int[] a = { 1, 1, 9, 1, 1, 1 };
        int b = 2;
        System.out.println(solution(a, b));

    }

}