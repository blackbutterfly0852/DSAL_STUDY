public class Test1 {

    public static int[] solution(int N) {
        int[] answer = new int[2];
        for (int i = 10 ; i < N ; i ++){
            
            if(!isContainZero(i)){
                continue;
            }
            int sub = N - i;
            if(!isContainZero(sub)){
                continue;
            }
            answer[0] = i;
            answer[1] = sub;
            break;
        }

        //System.out.println(Arrays.toString(answer));
        return answer;
        
    }
    
    public static boolean isContainZero(int number){
        String toNumber = Integer.toString(number);

        for(int i = 0 ; i < toNumber.length() ;i ++){
            if(toNumber.charAt(i) == '0'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(12));
       
        
    }
}
