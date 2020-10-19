import java.util.HashMap;

import java.util.*;
public class R_Hash_3 {

    public static int solution(String[][] clothes) {
        int answer = 1;
        // 1. 초기화
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for(String[] cloth : clothes){
            if(!list.containsKey(cloth[1])){
                list.put(cloth[1], 1);
            }else{
                list.put(cloth[1], list.get(cloth[1])+1);
            }
        }

        for(String key : list.keySet()){
            answer *= list.get(key) + 1;
        }
        
       
        return answer-1;
    }


    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
    
}
