public class binary_gap {


    public static int solution(int N) {
       int answer = 0 ;
        
       String binary_number = binary(N);
       int pre = 0;
       int tail = 0;

       for(int i = 0 ; i < binary_number.length() ; i ++){

            if(pre == 0 && binary_number.charAt(i) == '1'){
                pre ++;
            } else if(pre != 0 && binary_number.charAt(i) == '0'){
                tail ++;
            } else if (pre != 0 && binary_number.charAt(i) == '1'){
                answer = Math.max(answer, tail);
                tail = 0;
            }
        }
        //System.out.println(answer);
        return answer;    
    }


    // 2진수 출력
    public static String binary(int N){
        String binary_number ="";
        while(N!=1){
            binary_number += N%2;
            //System.out.println("bi : " + binary_number);
            N = N/2;

        }
        binary_number += 1;
        //System.out.println("bi : " + binary_number);
        return binary_number;
    }

    // 개수 출력 110010
                

    public static void main(String[] args) {
        solution(1041);
        
    }
    
}
