import java.util.*;
public class Greedy_6 {

    // 종료지점이 제일 빠른 곳(가장 작은 수)까지 포함관계 확인
    public static int solution(int[][] routes) {
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
               
            }
        });

        int compare = routes[0][1];
        int answer = 1;
        for(int i = 0 ; i < routes.length ; i++){
            if(compare >= routes[i][0]){
               compare = Math.min(compare, routes[i][1]);
            }else{
                compare = routes[i][1];
                answer ++;
            }
        }
        return answer;
    }
    // 다른 사람 풀이
    public int solution_2(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        //int[][] routes = {{-20,-19}, {-18,-17}, {-16,-15}, {-14,-13}};
        System.out.println(solution(routes));
    }
    
}
