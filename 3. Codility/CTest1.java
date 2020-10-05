import java.util.*;

public class CTest1 {
    public static int solution(String S) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i<S.length() ; i++){
            // 여는 기호면 add
            if(S.charAt(i) == '[' || S.charAt(i) == '{' || S.charAt(i) == '('){
                stack.push(S.charAt(i));
            // 그렇지 않으면 마지막에 넣은 
            }else{
                if(stack.isEmpty()) return 0;
                char lastPush = stack.pop();    
                if(lastPush == '[' && S.charAt(i) != ']') return 0;
                if(lastPush == '{' && S.charAt(i) != '}') return 0;
                if(lastPush == '(' && S.charAt(i) != ')') return 0;

            }
       }


        
    

        return stack.isEmpty() ?  1 : 0;

    }

    public static void main(String[] args) {
        String  A = "{[()()]}";
        System.out.println(solution(A));
    }


}
