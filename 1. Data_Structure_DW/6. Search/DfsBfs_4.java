import java.util.*;

public class DfsBfs_4 {

    // 여러개일 경우 순서 정한다.

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] visited = new boolean[tickets.length];
        answer = dfs(0, visited, "ICN", tickets, answer);
        // System.out.println("final answer : " + Arrays.toString(answer));
        return answer;
    }

    public static String[] dfs(int length, boolean[] visited, String start, String[][] tickets, String[] answer) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });
        // System.out.print("length : " + length + " ");
        // System.out.println(Arrays.toString(answer) + " " + start);
        // System.out.println("");
        if(length == answer.length-1){
            answer[length] = start;
            return answer;
        }

        // System.out.print("arrays : ");
        // for (int i = 0; i < tickets.length; i++) {
        //     for (int j = 0; j < tickets[i].length; j++) {
        //         System.out.print(tickets[i][j] + " ");
        //     }
        // }
        // System.out.println("");

            
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                if (tickets[i][0].equals(start) && !visited[i]) {
                    visited[i] = true;
                    answer[length] = tickets[i][0];
                    length++;
                    answer = dfs(length, visited, tickets[i][1], tickets, answer);
                    // System.out.println("length_2 : " + length + " " + Arrays.toString(answer));
                    if(answer[length]==null){
                        visited[i] = false;
                        length--;
                        answer[length] = null;
                    }
                }
            }
        }
       
        return answer;
    }

    public static void main(String[] args) {
        // String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }};
        // String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
        // String[][] tickets = { { "ICN", "A" }, { "A", "C" }, { "A", "D" }, { "D", "B"}, { "B", "A" } };
        // String[][] tickets = { { "ICN", "SFO" }, { "ICN", "SFO" },{ "SFO", "ICN" } };
        // String[][] tickets = { { "ICN", "A" }, { "A", "B" }, { "B", "A" }, { "A", "ICN"}, { "ICN", "A" } };
        String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" }, { "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
        // ['ICN', 'BOO', 'DOO', 'BOO', 'ICN', 'COO', 'DOO', 'COO', 'BOO']
        solution(tickets);
    }

}