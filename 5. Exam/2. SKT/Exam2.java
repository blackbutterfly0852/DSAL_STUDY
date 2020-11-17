public class Exam2 {
    

    public static int solution(int[] A) {
        int ret = 0;
        for(int i = 0 ; i < A.length ; i ++){
            int tmp = A[i];
            if(i != 0){
                A[i] = A[i-1];
            }
            if(isOrdered(A)){
                ret++;
            }
            A[i] = tmp;
        }

        
        return ret;
    }

    public static boolean isOrdered(int[] A){
        for(int i = 0 ; i < A.length-1; i ++){
            if(A[i] > A[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[] A = {3,4,5,4};
        int[] A = new int[100000];
        for(int i = 0; i<100000 ; i++){
            A[i] = i+1;
        }
        //int[] A = {4,5,2,3,4};
        System.out.println(solution(A));
        
    }
    
}
