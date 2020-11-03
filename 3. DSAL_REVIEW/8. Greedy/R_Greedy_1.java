import java.util.Arrays;

public class R_Greedy_1 {

    public static int solution(int n, int[] lost, int[] reserve) {
        // 1. 초기화 : 편의상 idx 1부터 시작, 비교시 편하게 하기 위해 n+2
        int[] total = new int[n + 2];
        int answer = n;
        
        // 참고
        // lost와 reserve를 각각 반영하면
        // 도난 당한 사람이 여분 옷을 가지고 있는 사람이면 별도의 처리 없이 바로 반영
        // 각각이 반영된 total을 확인하여 해당 idx에 값이 -1이면
        // 뒤 또는 앞에서 확인하여 빌릴 수 있으면 빌리고, 없으면 answer -

        // 2. lost 반영
        for(int l : lost){
            total[l] --;
        }

        // 3. reserve 반영
        for(int r : reserve){
            total[r] ++;
        }

        for(int i = 1 ; i < total.length-1 ; i++){
            if(total[i] == -1){
                if(total[i-1] == 1){
                    total[i] ++ ;
                    total[i-1] --;
                }else if(total[i+1] == 1){
                    total[i] ++;
                    total[i+1] --;
                }else{
                    answer--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = { 4, 5 };
        int[] reserve = { 3, 4 };
        System.out.println(solution(n, lost, reserve));
    }



    
}
