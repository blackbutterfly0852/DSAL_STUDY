// DFS/BFS_3 단어변환
public class DfsBfs_3 {
    static int cnt = 0;
    public  static int dfs(String begin, String target, String[] words, int sum,  boolean[] visited) {
        cnt++;
        int tmp_answer = words.length + 1; // 7
        // System.out.println(begin + " " + target + " " + sum );
        if (begin.equals(target)) {
            return sum;
        }

        for (int i = 0; i < words.length; i++) {
            if (diff(begin, words[i])==1 && !visited[i]) {
                visited[i] = true;
                int tmp_2 = dfs(words[i], target, words, sum + 1, visited);
                System.out.println("tmp_answer, tmp_2 : " + tmp_answer + " " +  tmp_2);
                tmp_answer = Math.min(tmp_answer, tmp_2);
                System.out.println("tmp_answer : " + tmp_answer );
                visited[i] = false;

            }
        }
        return tmp_answer ;
    }

    public  static int diff(String begin, String word) { // 차이값 : 0, 1, 2, 3
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        answer = dfs(begin, target, words, 0, visited);
        System.out.println("cnt : " + cnt);
        return answer == words.length + 1?0:answer;
    }

    public static void main(String[] args) {

        // String begin = "hit";
        // String target = "cog";
        // String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        String begin = "hit";
        String target = "lot";
        String[] words ={"hot", "lot","dot"};

        System.out.println(solution(begin, target, words));

    }

}