import java.util.HashMap;
import java.util.Map;

// Hash
// 1.완주하지 못한 선수
public class Hash_1 {

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> parList = new HashMap<String, Integer>();
        String answer = "";
        // {a,b,b}
        for (String par : participant) {
            if (!parList.containsKey(par)) {
                parList.put(par, 1);
            } else {
                parList.put(par, parList.get(par) + 1);
            }
        }
        
        
        for (String com : completion) {
            // comList에 존재하지 않는 경우
            if (parList.containsKey(com)) {
                parList.put(com, parList.get(com) - 1);
            }
        }
        
      
        for (String par : participant) {
            if (parList.get(par) == 1) {
                answer = par;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] a = { "leo", "kiki", "eden" };
        String[] b = { "eden", "kiki" };
        System.out.println(solution(a, b));
        
    }
}
