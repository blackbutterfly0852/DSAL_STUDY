import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class StackQueue_3 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<int[]> tmp_answer = new ArrayList<>();
        int[] answer = {};
        for (int i = 0; i < progresses.length; i++) {

            int pre;

            if ((100 - progresses[i]) % speeds[i] != 0) {
                pre = ((100 - progresses[i]) / speeds[i]) + 1;

            } else {
                pre = ((100 - progresses[i]) / speeds[i]);
            }
            // System.out.println("pre : " + pre);

       
            if (tmp_answer.size() == 0 || pre > tmp_answer.get(tmp_answer.size() - 1)[0]) {
                int[] tmp = new int[2];
                tmp[0] = pre;
                tmp[1] = 1;
                tmp_answer.add(tmp); 

            } else {
                tmp_answer.get(tmp_answer.size() - 1)[1] += 1;

            }

        }

        answer = new int[tmp_answer.size()];
        for (int i = 0; i < tmp_answer.size(); i++) {
            answer[i] = tmp_answer.get(i)[1];
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }

    // [93,30,55] [1,30,5] [2,1]
    public static void main(String[] args) {
        int[] a = { 93, 30, 55 };
        int[] b = { 1, 30, 5 };
        solution(a, b);

        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));// 생성시
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
