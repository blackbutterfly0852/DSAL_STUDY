import java.util.Scanner;

public class Practice2 {
// https://jdm.kr/blog/213
    public static void main(String[] args) {

        // 변수 : variable -> 어떠한 데이터를 담는 통;
        // 문자, 문자열, 정수, 실수

        // 기본 자료형
        // byte, short, int, long, float, double, char, boolean
        // 1. 정수 자료형 (int > long > short > byte )
        // 1) byte -128 ~ +127
        Byte byteV = -128;  
        // 2) short -32768 ~ 32767
        Short shortV = 30000;
        // 3) int // -2147483648 ~ 2147483647 -> -21~21억
        int intV = 400000000;
        // 4) long // -9223372036854775808 ~ 9223372036854775807
        long longV = 123123;

        // 2. 실수 자료형 -> X.XXXXXXXXXXXXX
        float floatV = (float) 3.2;
        double doulV = 3.2;

        // 3. 문자 자료형
        char charV = 'a';

        // 4. boolean 자료형 -> true, false
        boolean boov = true;
        boolean boov_2 = false;

        String stringV = "ABC"; 

        // 문제

        // 0. variablePractice 이름의 자바 파일을 생성하세요. 해당 파일 내에서 아래 문제를 수행하시요.

        // 1. 문자 변수를 선언하고, 해당 변수로 'a'를 출력하세요

        // 2. 문자열 변수를 선언하고, 해당 변수로 'BD'를 출력하세요

        // 3. int 자료형 변수를 선언하고, 42를 출력하세요

        // 4. double 변수를 선언하고,  4.2를 출력하세요.

        // 5. boolean 변수를 선언하고, false를 선언하세요
        
        // 6. boolean 변수를 선언하고, true를 선언하세요


        // 조건문 : 어떠한 조건에 맞게 나눠주는 것
        // Scanner sc = new Scanner(System.in);
        // System.out.println("김헌현님 숫자 두 개를 입력해주세요, 단 숫자 범위는 -21억 ~ 21억까지 입니다.");
        // int a = sc.nextInt();
        // int b = sc.nextInt();

        // if(a+b < 2 ) { // if 문 안에 질문에 대한 대답이  맞다(true) 아니다(false)로 나오겠금 작성을 해야합니다.
        //     // a+b가 2보다 작으면 여기부분을 출력해라.
        //     System.out.println("a+b는 2보다 작습니다.");

        // }else{
        //     // a+b가 2보다 크거나 같으면 여기 부분을 출력해라.
        //     System.out.println("a+b는 2보다 크거나 같습니다.");

        // }
       
        Scanner sc = new Scanner(System.in);
        // 사용자가 입력 받으면 비교할 값
        String original_id = "kimdongwoo";
        String original_pw = "1234";   
        
        // 사용자가 입력할 값.
        String user_id = sc.next();
        String user_pw = sc.next();

        if(user_id.equals(original_id) && user_pw.equals(original_pw)){
            System.out.println("아이다와 비밀번호가 맞습니다. 로그인 합니다.");
        }else{
            System.out.println("아이디 또는 비밀번호가 틀립니다. 확인해주시기 바랍니다.");
        }
    }
   
}
