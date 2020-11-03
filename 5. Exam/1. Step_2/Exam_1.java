import java.util.*;;

public class Exam_1 {
    public static String solution(String s) {
        String answer = "";
        String[] tmp_answer = s.split(" ");

        System.out.println(Arrays.toString(tmp_answer));

        for (int i = 0; i < tmp_answer.length; i++) {
            for (int j = 0; j < tmp_answer[i].length(); j++) {

                int tmp = (int) tmp_answer[i].charAt(j);
                if (j == 0 && 97 <= tmp && tmp <= 122) {
                    answer += (char) (tmp - 32);
                } else if(j!=0 && 65 <= tmp && tmp <=90) {
                    answer += (char) (tmp + 32); 
                }else{
                    answer += (char) tmp;

                }

            }
            if(i != tmp_answer.length-1){
                answer += " ";
            }
            
        }

        System.out.println("answer : " + answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));

    }
}
