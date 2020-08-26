public class DfsBfs_3_2 {
    public static int dfs(String begin, String target, String[] words, int sum, int idx, boolean[] visited) {
        int answer = 0;
        if (begin.equals(target)) {
            return sum;
        }

        visited[idx] = true;

        for (int i = 0; i < words.length; i++) {
            if (idx != i && diff(begin, words[i]) == 1 && !visited[i]) {
                answer = dfs(words[i], target, words, sum + 1, i, visited);
            }
        }

        visited[idx] = false;
        return answer;
    }

    public static int diff(String begin, String target) {
        int answer = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                answer++;
            }
        }
        return answer;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if (diff(begin, words[i]) == 1) {
                answer = Math.min(answer, dfs(words[i], target, words, 1, i, visited));
                // System.out.println("answer : " + answer);
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "lot", "dog", "cog", "log" };

        // String begin = "hit";
        // String target = "lot";
        // String[] words ={"hot", "dot","lot"};

        System.out.println(solution(begin, target, words));

    }

}