import java.util.Arrays;

public class Sum {
    
    // 1. 일반 재귀함수
    public static int recursiveSum(int n){
        if(n == 1){
            return 1;
        }
        return n + recursiveSum(n-1);
    }

    // 2. 분할정복 
    public static int fastSum(int n){
        if(n == 1) return 1;
        if(n % 2 == 1) return fastSum(n-1) + n;
        return 2 * fastSum(n/2) + (n/2) * (n/2);
    }

    // 3. 차이
    // 1) 일반 재귀함수는 한 조각과 나머지 전체로 나눈다. O(N)
    // 2) 분할정복은 거의 같은 크기의 부분문제로 나눈다.  O(log N)

    // 4. 행렬의 곱셈 N x N O(N^3)
   
    public static void multifly(int[][] A, int[][] B, int[][] C){
        for(int i = 0 ; i < A.length ; i ++){
            for(int j = 0 ; j < B.length ; j ++){
                for(int k = 0 ; k < 2 ; k ++){
                   C[i][k] += A[i][j] * B[j][k];
                   for(int[] c : C){
                    System.out.println(Arrays.toString(c));
                    }
                    System.out.println("");
                }
            }
        }    
        
    }


    public static void main(String[] args) {
        System.out.println(recursiveSum(3));
        System.out.println(fastSum(3));

        int[][] A = {{1,2},{3,4}};
        int[][] B = {{1,2},{3,4}};
        int[][] C = new int[2][2];
        multifly(A, B, C);
    }



}
