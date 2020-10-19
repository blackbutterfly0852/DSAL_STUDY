import java.util.*;
public class R_Hash_2 {


    public static boolean solution(String[] phone_book) {
        

        boolean answer = true;

        // 참고
        // 접두사 문제이다.
        // String 정렬은 사전 순 정렬
        // 사전 순 정렬을 하면, 첫번째가 두번째의 접두사가 안되면, 첫번째는 세번째의 접두사도 아니다.
        Arrays.sort(phone_book); 
        System.out.println(Arrays.toString(phone_book));

        // 1. 초기화
        HashMap<String, Integer> list = new HashMap<String,Integer>();
        for(String pb : phone_book){
            list.put(pb, 0);
        }
        // 2. LOOP
        for(String key : list.keySet()){
           int size = key.length();
            for(String pb : phone_book){
                // pb가 key보다 작으면 continue;
                if(pb.length() < size){
                    continue;
                }
                if(key.equals(pb.substring(0,size))){
                   list.put(key, list.get(key)+1);
                }
            }
            if(list.get(key) > 1){
               return false;
            }
        }

      
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"012345123", "119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
        System.out.println("119".subSequence(0, 2));
    }
    
}
