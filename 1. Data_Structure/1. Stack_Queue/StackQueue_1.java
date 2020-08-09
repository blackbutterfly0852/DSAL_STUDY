
import java.util.ArrayList;
import java.util.List;
// 다리를 지나는 트럭.
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        List<Integer> bridge_list = new ArrayList<> ();
        List<Integer> truck_list = new ArrayList<> ();
       
        for (int i = 0; i < bridge_length; i++) {
            bridge_list.add(i, 0);
        }

        for (int j = 0; j < truck_weights.length; j++) {
            truck_list.add(j, truck_weights[j]);
        }
        int tmp_sum = 0;

        while (bridge_list.size() != 0) {
            answer += 1;
            int tmp_remove = bridge_list.remove(0);
            tmp_sum -= tmp_remove;

            if (truck_list.size() != 0) {

                if (tmp_sum + truck_list.get(0) <= weight) {
                    tmp_sum += truck_list.get(0);
                    int tmp_add = truck_list.remove(0);
                    bridge_list.add(tmp_add);
                } else {
                    bridge_list.add(0);

                }

            }

        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] abc = { 7, 4, 5, 6 };
        System.out.println(solution(2, 10, abc));
        
    }




}
