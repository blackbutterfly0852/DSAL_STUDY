import java.util.Stack;

public class Solution_3 {

    public static int solution_me(String s)
    {
        int i = s.length()-2;
        int size = s.length();

        while(true){
            if(s.charAt(i) == s.charAt(i+1)){
               s = s.replaceFirst(s.substring(i, i+2), "");
               //System.out.println("s : " + s);
               size = s.length();
               i = size - 2;
               //System.out.println("size : " + size + " i : " + i);
            }else{
                i--;
            }
            if(i < 0) break;

        }
        //System.out.println("final s : " + s);
        return size == 0 ? 1 : -1;
    }

    public static int solution(String s)
    {
        
        Stack<Character> st = new Stack<>();


        for(int i = 0 ; i <s.length(); i ++){

            char tmp = s.charAt(i);

            if(!st.empty() && st.peek() == tmp) {
                st.pop();
            }else{
                st.push(tmp);
            }
        }

        return st.isEmpty()?1:0;



        
    }


    public static void main(String[] args) {

        String s = "baabaa"; // cdcd, baabaa
        System.out.println(solution(s));
    }
    
}
