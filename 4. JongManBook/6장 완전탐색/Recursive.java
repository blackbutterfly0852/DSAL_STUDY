public class Recursive {

    // 1. 1~n 까지의 합을 계산하는 반복 함수와 재귀 함수
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

   


    


}
