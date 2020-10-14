import java.util.*;
public class Sort_1 {

    public static int[] solution(int[] array, int[][] commands) {
        // 1. 초기화
        int[] answer = new int[commands.length];

        // 2. 배열 자르기
        // 참고 : int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        for(int i = 0 ; i < commands.length ; i ++){
            int[] tmp_array = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;
            for(int j = commands[i][0]-1 ; j < commands[i][1] ; j ++){
                tmp_array[idx] = array[j];
                idx ++ ;
            }
            Arrays.sort(tmp_array);
            answer[i] = tmp_array[commands[i][2]-1];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(array, commands);
    }
    
}
