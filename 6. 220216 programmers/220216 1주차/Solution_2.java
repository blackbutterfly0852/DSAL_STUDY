public class Solution_2 {
    
    public static int solution(String s) {
       String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

       for(int i = 0 ; i < 10 ; i ++){
           s = s.replace(num[i], Integer.toString(i));
           //System.out.println("s : " + s);
       }
       return Integer.parseInt(s);
        
    }

    public static void main(String[] args) {
        String s = "2three45sixseven";
        System.out.println(solution(s));
    }
}
