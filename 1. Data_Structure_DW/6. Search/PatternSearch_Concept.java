import java.util.Arrays;

// 문자열 검색 Algorithm : 텍스트에서 패턴 찾기

public class PatternSearch_Concept {

    // 1. bruteForce_Search
    public static int bruteForce_Search(String text, String pattern) {

        int text_idx = 0;
        int pattern_idx = 0;
        // System.out.println("text_length : " + text.length());
        // System.out.println("pattern_length : " + pattern.length());
        while (text_idx < text.length() && pattern_idx < pattern.length()) {
            // System.out.println("text_idx : " + text_idx);
            // System.out.println("pattern_idx : " + pattern_idx);
            // 1) 문자열이 일치하는 경우
            if (text.charAt(text_idx) == pattern.charAt(pattern_idx)) {
                text_idx++;
                pattern_idx++;
            // 2) 문자열이 미일치하는 경우
            } else {
                // 2-1) 미일치하는 부분부터 패턴 재비교 하기 위함.
                text_idx = text_idx - pattern_idx + 1;
                pattern_idx = 0;
            }
        }
        System.out.println("start_idx : " + (text_idx - pattern_idx));
        System.out.println("end_idx : " + (text_idx - 1));
        // 3) 패턴이 존재하는 경우 해당 패턴이 시작되는 idx 리턴
        return pattern_idx == pattern.length() ? (text_idx - pattern_idx) : -1;
    }

    // 2. KMP_serch : BruteForce_Search의 비효율성을 개선

    // 3. Boyer_Moore

    public static void main(String[] args) {
        String text = "ZABCABXACCADEF";
        String pattern = "ABCABD";
        System.out.println(bruteForce_Search(text, pattern));
        System.out.println(text.indexOf(pattern)); // 처음 나온 pattern의 첫번째 문자 idx
        System.out.println(text.lastIndexOf(pattern)); // 마지막 나온 pattern의 첫번째 문자 idx

    }

}