import java.util.Arrays;
import java.util.Comparator;


public class Sort_2 {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] numberToString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberToString[i] = Integer.toString(numbers[i]);
        }
        // 참고
        // 문자열 형식의 숫자를 조합해서 큰 수를 나열한다?
        // 순서를 바꿔서 합쳐본 다음, 대소 비교 한다.
        // Compartor -> return 1, 0, -1의 값을 모두 return 한다.
        Comparator<String> cp = new Comparator<String>() {
            @Override
            public int compare(String current, String last) {
                // String clString = current + last;
                // String lcString = last + current;
                // int cl = Integer.parseInt(clString);
                // int lc = Integer.parseInt(lcString);
                // if (cl < lc) {
                //     return 1;
                // } else if(cl == lc){
                //     return 0;
                // }else{
                //     return -1;
                // }

                // 참고 : 내림차순
                return (last+current).compareTo(current+last); 
            }
        };
        // 참고
        // 배열 정렬
        Arrays.sort(numberToString, cp);
        // 컬렉션 정렬
        // Collections.sort(컬렉션, cp);

        int isZero = 0;
        for (String number : numberToString) {
            answer += number;
            isZero += Integer.parseInt(number);
        }
        return isZero == 0 ? "0" : answer;
    }

    public static void main(String[] args) {
        int[] numbers_1 = { 6, 10, 2 };
        int[] numbers_2 = { 3, 30, 34, 5, 9 };
        int[] numbers_3 = { 3, 30, 34, 5, 9 };
        int[] numbers_4 = { 3, 30, 31, 5, 9 };
        int[] numbers_5 = { 0, 0, 0, 0, 0 };
        int[] numbers_6 = { 235, 23585 };
        int[] numbers_7 = { 1000, 1000, 1000, 1000, 1000 };
        int[] numbers_8 = { 110, 10 };
        int[] numbers_9 = { 1, 11, 111, 1111 };
        System.out.println(solution(numbers_4));

    }

}
