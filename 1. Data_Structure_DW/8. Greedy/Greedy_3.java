import java.util.*;
public class Greedy_3 {
    static int answer = Integer.MAX_VALUE;
    public static int solution(String name){
        // 1. 최소 이동 횟수
        boolean[] isAllvisited = new boolean[name.length()];
        for(int i = 0 ; i < name.length() ; i ++){
            isAllvisited[0] = true;
            if(name.charAt(i) == 'A'){
                isAllvisited[i] = true;
            }
        }
        recur(name, isAllvisited, 0 ,0, "start");

        // 2. 각 자리 변경 횟수
        HashMap<Integer, Integer> reference = new HashMap<Integer, Integer>();
        for (int i = 0; i < 14; i++) {
              reference.put(65 + i, i);
        }
        for (int i = 12; i > 0; i--) {
              reference.put(91 - i, i);
        }
        
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += reference.get((int) name.charAt(i));
            }
        }

        
        return answer;

    }

    public static void recur(String name, boolean[] isAllVisited , int start, int count, String way){
        System.out.println("start : " + start );
        System.out.println("count : " + count );
        System.out.println("way : " + way );
        System.out.println("isAllVisited : " + Arrays.toString(isAllVisited));
        if(isAllVisitedMethod(isAllVisited) || count >=name.length()-1){
            System.out.println("answer , count : " + answer + " " + count);
            System.out.println("---------------------------------");
            answer = Math.min(answer, count);
            return;
        }

        int prev = (start - 1) < 0             ? name.length() - 1 : start - 1;
        int next = (start + 1) >=name.length() ? 0                 : start + 1;

        int prevCnt = 0;
        if(!isAllVisited[prev]){
            prevCnt ++;
            isAllVisited[prev] = true;
        }  
        recur(name, isAllVisited,prev,count+1, "prev" );
        if(prevCnt != 0){
            isAllVisited[prev] = false;
        }

        int nextCnt = 0;
        if(!isAllVisited[next]){
            nextCnt ++;
            isAllVisited[next] = true;
        } 
        recur(name, isAllVisited,next,count+1, "next" );
        if(nextCnt != 0){
            isAllVisited[next] = false;
        }   
       
    }
    public static boolean isAllVisitedMethod(boolean[] isAllVisited){
        boolean answer = true;
        for(boolean visited : isAllVisited){
            if (!visited) {
                return false;
            }
        }
        return answer;
    }


    // 다른 사람 풀이

    public static int solution_2(String name) {
        int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        for(char c:name.toCharArray())
            answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1;

        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }     
            System.out.println(min); 
            System.out.println(i+length-next);           
            System.out.println(Math.min(i,length-next));  
            System.out.println("---------------------");           
            min=Math.min(min, i+length-next + Math.min(i,length-next));
        }

        return answer+min;
    }



    public static void main(String[] args) {
        //String name = "ABAAAAAAAAABB";
         String name = "AACAD";
        System.out.println(solution_2(name));
    }
}
