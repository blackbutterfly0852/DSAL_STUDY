public class Exam3 {
    public static String solution(int A, int B) {
        if (A >= B) {
            return findString(A, B, "a", "b" );
        } else {
            return findString(B, A, "b", "a" );
        }
    };

    public static String findString(int bigInt, int smallInt, String bigS, String smallS) {
        int curBigInt = bigInt;
        int curSmallInt = smallInt;
        int bigCnt = 0;
        int smallCnt = 0;
        String answer = "";

        while (curBigInt != 0 || curSmallInt != 0) {
            System.out.println("answer = " + answer);
            System.out.println("answer.length = " + answer.length());
            while (bigCnt < 2 && curBigInt > 0) {
                answer += bigS;
                bigCnt++;
                curBigInt--;
                smallCnt = 0;
            }

            while (smallCnt < 2 && curSmallInt > 0) {
                answer += smallS;
                smallCnt++;
                curSmallInt--;
                bigCnt = 0;
            }

        }

        return answer;
    }

    // 탐욕 알고리즘
    public static String solution_2(int A, int B) {
        StringBuilder sb = new StringBuilder();
        
        while(A>0 || B>0){
            boolean writeA = false;
            int size = sb.length();
            // 1. A를 작성할 지 B를 작성할 지 결정
            if(sb.length() >=2 && sb.charAt(size-1) == sb.charAt(size-2)){
                if(sb.charAt(size-1) == 'b'){
                    writeA = true;
                }
            }else if( A >= B){
                    writeA = true;
            }

            // 2. 위에서 결정된 내용을 가지고 StringBuilder에 추가
            if(writeA){
                sb.append('a');
                A--;
            }else{
                sb.append('b');
                B--;
            }

        }




        return sb.toString();

    };
    public static void main(String[] args) {
        int A = 4;
        int B = 1;
        System.out.println(solution_2(2, 5));

    }

}
