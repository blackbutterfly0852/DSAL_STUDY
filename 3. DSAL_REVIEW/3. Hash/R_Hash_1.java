import java.util.*;
public class R_Hash_1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> list = new HashMap<String,Integer>();

        // 1. 참여자
        for(String par : participant){
            if(!list.containsKey(par)){
                list.put(par, 1);
            }else{
                list.put(par,list.get(par)+1);
            }
        }

        // 2. 완주자
        for(String com : completion){
            list.put(com, list.get(com)-1);
        }

        // 3. 미완주자
        for(String par : participant){
            if(list.get(par) == 1){
                answer = par;
            }
        }


        // 참고
        for(String key : list.keySet()){
            System.out.println(key);
            System.out.println(list.get(key));
        }
        System.out.println("==================");
        Iterator it = list.keySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            System.out.println(list.get(it.next()));
        }
        System.out.println("==================");
        for(Map.Entry<String,Integer> entry : list.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


        return answer;
    }
    

    public static void main(String[] args) {
      String[] participant = {"mislav", "stanko", "mislav", "ana"};
      String[] completion =  {"stanko", "ana", "mislav"};
      System.out.println(solution(participant,completion));
    }
}
