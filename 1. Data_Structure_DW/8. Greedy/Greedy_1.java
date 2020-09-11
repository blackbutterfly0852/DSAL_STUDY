
// 체육복
import java.util.*;

public class Greedy_1 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] lost_visited = new boolean[lost.length];
        boolean[] reserve_visited = new boolean[reserve.length];
        answer += Exist(lost, reserve, lost_visited, reserve_visited);
                
        for (int i = 0; i < reserve.length; i++) {
            if(reserve_visited[i]){
                continue;
            }
            int prev = reserve[i] - 1;
            int next = reserve[i] + 1;
            for (int j = 0; j < lost.length; j++) {
                if (!lost_visited[j] &&  (prev == lost[j] || next == lost[j])) {
                    lost_visited[j] = true;
                    reserve_visited[i] = true;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static int Exist(int[] lost, int[] reserve, boolean[] lost_visited, boolean[] reserve_visited) {
        int answer = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost_visited[i] = true;
                    reserve_visited[j] = true;
                    answer ++;
                }
            }
        }
        return answer;
    }

    // 다른 사람 풀이
    public static int solution_2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) // 2, 4
            people[l-1]--;
        System.out.println("1 : " + Arrays.toString(people));
        for (int r : reserve) //  1, 2, 3, 5
            people[r-1]++;
        System.out.println("2 : " + Arrays.toString(people));
        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                    System.out.println("3 : " + Arrays.toString(people));
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                    System.out.println("3 : " + Arrays.toString(people));
                }else 
                    answer--;
            }
        }
        return answer;
    }

     public static void main(String[] args) {
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = { 1, 2, 3, 5 };
        System.out.println(solution_2(n, lost, reserve));
    }

}
