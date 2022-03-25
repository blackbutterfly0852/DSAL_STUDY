public class Solution_1 {

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if (s.length() == 1)
            return 1;

        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            String tmp = "";
            String tmp_answer = "";

            for (int j = 0; j < s.length() / i; j++) {
                if (tmp.equals(s.substring(j * i, j * i + i))) {
                    cnt++;

                    continue;

                }

                if (cnt > 1) {
                    tmp_answer += Integer.toString(cnt) + tmp;
                    cnt = 1;
                } else {
                    tmp_answer += tmp;
                }

                tmp = s.substring(j * i, j * i + i);
                // System.out.println("tmp : " + tmp + " j : " + j );
            }

            if (cnt > 1) {
                tmp_answer += Integer.toString(cnt) + tmp;
            } else {
                tmp_answer += tmp;
            }

            if (s.length() % i != 0) {
                tmp_answer += s.substring(s.length() - s.length() % i, s.length());
            }

            answer = tmp_answer.length() < answer ? tmp_answer.length() : answer;

        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd"; // aabbaccc, ababcdcdababcdcd, abcabcdede, abcabcabcabcdededededede,
                                       // xababcdcdababcdcd
        System.out.println("main : " + solution(s));
    }

}
