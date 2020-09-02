import java.util.*;

public class DP_1_1 {
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    public static int solution(int N, int number) {
        HashSet<Integer> init = new HashSet<Integer>();
        init.add(0);
        list.add(init);
        int answer = -1;

        int setting = 0;
        for (int n = 0; n < 8; n++) {
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(10 * setting + N);
            setting = 10 * setting + N;
            list.add(set);
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < i; j++) {
                int m = i - j;
                //System.out.print(i + "는 " + j + " " + m + " ");
                cal(i, j, m);

            }

            Iterator it = list.get(i).iterator();
            while (it.hasNext()){
                System.out.println(it.next() + " ");

            }
            System.out.println(" ");
                            
            if (list.get(i).contains(number)) {
                return i;
            }
        }
        return answer;
    }

    public static void cal(int i, int j, int m) {

        Iterator it1 = list.get(j).iterator();
        Iterator it2 = list.get(m).iterator();

        while (it1.hasNext()) {
            int one = (int) it1.next();
            while (it2.hasNext()) {
                int two = (int) it2.next();
                list.get(i).add(one + two);
                list.get(i).add(one - two);
                list.get(i).add(two - one);
                list.get(i).add(one * two);
                if (two != 0) {
                    list.get(i).add(one / two);
                }
                if (one != 0) {
                    list.get(i).add(two / one);
                }
            }
        }

    }

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }
}