import java.util.*;
public class R_DfsBfs_4 {
    static String[] answer = {};
    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        // 1. tickets[i][1] 기준으로 오름차순(문자열 순)
        Arrays.sort(tickets,new Comparator<String[]>(){
            @Override
            public int compare(String[] current, String[] last) {
                return current[1].compareTo(last[1]);
            }
        });

        // 2. DFS
        boolean[] visited = new boolean[tickets.length];
        answer[0] = "ICN";
        dfs("ICN", tickets, visited, 1);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void dfs(String begin, String[][] tickets, boolean[] visited, int count){
        // System.out.println("count : " + count);
        // count 숫자는 정답배열의 크기이나 모두 탐색 못하는 경우 return
        if(count == tickets.length + 1 && !isAllVisited(visited)){
            return ;
        }

        for(int i = 0 ; i < tickets.length ; i++){
            if(begin.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                answer[count] = tickets[i][1];
                dfs(tickets[i][1], tickets, visited, count+1);
                // System.out.println(Arrays.toString(answer) + " count  : " + count);
                // 모두 탐색을 못하는 경우는 정답배열 마지막 idx가 null 값이다.
                if(answer[tickets.length-1] == null){
                    visited[i] = false;
                }
                
            }
          
        }

    }

    public static boolean isAllVisited(boolean[] visited){
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        // String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" }};
        // String[][] tickets = { { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "COO", "BOO" } };
        // String[][] tickets ={ { "ICN", "A" }, { "A", "C" }, { "A", "D" }, { "D", "B"}, { "B", "A" } };
        String[][] tickets = { { "ICN", "A" }, { "A", "B" }, { "B", "A" }, { "A", "ICN"}, { "ICN", "A" } };
        solution(tickets);

        
    }
    
}
