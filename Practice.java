class Solution {
    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });
        answer = dfs(0, visited, "ICN", tickets, answer);

        return answer;
    }

    public static String[] dfs(int length, boolean[] visited, String start, String[][] tickets, String[] answer) {
        //
        if (length == answer.length - 1) {
            answer[length] = start;
            return answer;
        }

        for (int i = 0; i < tickets.length; i++) {

            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                answer[length] = tickets[i][0];
                length++;
                answer = dfs(length, visited, tickets[i][1], tickets, answer);

                if (answer[length] == null) {
                    visited[i] = false;
                    length--;
                    answer[length] = null;
                }
            }

        }

        return answer;
    }
}