public class R_DfsBfs_3 {
    static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
       
        dfs(begin, target, words, 0, visited);

        return answer == Integer.MAX_VALUE? 0 : answer;

    }

    public static void dfs(String begin, String target, String[] words, int count, boolean[] visited) {
        if (begin.equals(target)) {
            // 여기서 정답을 추출.
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (isDifferCount(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1, visited);
                visited[i] = false;
            }
        }

    }

    public static boolean isDifferCount(String begin, String target) {
        int answer = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                answer++;
            }
        }
        return answer == 1 ? true : false;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(solution(begin, target, words));
    }

}
