import java.util.*;

// Hash
// 2. 전화번호 목록
public class Hash_2_1 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0 ; i<phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
           
        }
     
        return answer;
    }
   
    public static void main(String[] args) {
        String[] a = { "119", "97674223", "1195524421","1111111111" };
        // 2 -> 1 , 3->3, 4->6 5->10
        // 0, 1 -> 1, 2 -> 1, 3
        String[] a_1 = { "119", "9769", "9768" };
        String[] b = { "123", "456", "789" };
        String[] c = { "12", "123", "1235", "567", "88" };
        String[] d = { "11111111111111111111", "11111111111111111111", "11111111111111111111", "11111111111111111111", "11111111111111111111" };
        String[] e = { "2", "11111111111111111111", "11111111111111111111", "11111111111111111111", "11111111111111111111" };
        String[] f = {"111113", "1112", "12"};
     
        //System.out.println(solution(a));
        System.out.println(solution(a_1));
        //System.out.println(solution(b));

        //System.out.println(solution(c));
        //System.out.println(solution(d));
        //System.out.println(solution(e));
        //System.out.println(solution(f));

    }

}