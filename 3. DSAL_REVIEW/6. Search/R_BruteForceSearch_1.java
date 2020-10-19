import java.util.Arrays;

public class R_BruteForceSearch_1 {


    public static int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int p1_count = 0;
        int p2_count = 0;
        int p3_count = 0;

        for(int i = 0 ; i < answers.length ; i++){
            // p1
            if(answers[i] == p1[i%p1.length]){
                p1_count ++;
            } 
            // p2
            if(answers[i] == p2[i%p2.length]){
                p2_count ++;
            } 

            // p3
            if(answers[i] == p3[i%p3.length]){
                p3_count ++;
            } 
        }
        System.out.println(p1_count + " " + p2_count + " " + p3_count);
        int[] answer = list_P(p1_count, p2_count, p3_count);

        System.out.println(Arrays.toString(answer));
        
        return answer;
    }

   

    public static int[] list_P(int p1, int p2, int p3) {
        int[] answer ;

        // p1가 제일 큰 경우
        if(p1 > p2 && p1 > p3){
            answer = new int[1];
            answer[0] = 1;
        }

        // p2가 제일 큰 경우
        else if(p2 > p1 && p2 > p3){
            answer = new int[1];
            answer[0] = 2;
        }

        // p3가 제일 큰 경우
        else if(p3 > p1 && p3 > p1){
            answer = new int[1];
            answer[0] = 3;
        }

        // p1 == p2 
        else if(p1 == p2 && p1 > p3){
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 2;
        }

        // p1 == p3
        else if(p1 == p3 && p1 > p2){
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 3;
        }

        // p2 == p3
        // p1 == p3
        else if(p2 == p3 && p2 > p1){
            answer = new int[2];
            answer[0] = 2;
            answer[1] = 3;
        }

        // 셋 다 동일 한 경우

        else {
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }

        return answer;
    }



    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        solution(answers);
        
    }
    
}
