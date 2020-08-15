import java.util.*;

public class Practice {
    import java.util.*;
class Solution {
     public static String solution(int[] numbers) {
        String answer = "";
        String[] stringSorted = new String[numbers.length];
        
        for(int i = 0 ; i< numbers.length ; i++){
            stringSorted[i] = Integer.toString(numbers[i]);
        }
            
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            // 중요!! 기준은 앞 // 1 : 자리변경, // -1, 0 : 자리미변경 
            public int compare(String a, String b) { 
                //System.out.println("a : " + a + " B : " + b);
                //System.out.println("");

                // 1-1. 해당 요소보다 다음 요소가 큰 경우
                if(a.charAt(0) < b.charAt(0)){
                    return 1;
                // 1-2. 해당 요소가 다음 요소보다 작은 경우
                }else if(a.charAt(0) > b.charAt(0)){
                    return -1;
                // 1-3. 해당 요소와 다음 요소가 같은 경우
                }else if(a.charAt(0) == b.charAt(0)){
                    // 1-3-1. 해당 요소와 다음 요소의 길이가 같은 경우 ex) 30 vs 34
                    if(a.length() == b.length()){
                        if(Integer.parseInt(a) < Integer.parseInt(b)){
                            return 1;
                        }else{
                            return -1;
                        }
                    // 1-3-2. 해당 요소와 다음 요소의 길이가 다른 경우 ex)  30%3 = 0, 31%3 = 1, 32%3 = 2 -> 330, 331, 332
                    //                                                    33%3 = 0, 34%3 = 1, 35%3 = 2 -> 333, 343 ,353
                    // 끝자리 숫자가 나누눈 수보다 작다? 
                    }else{
                         String tmp_ab = a+b;
                        String tmp_ba = b+a;
                       if( Integer.parseInt(tmp_ab) <= Integer.parseInt(tmp_ba)){
                           return 1;
                       }else{
                           return -1;
                       }
                        

                    }


                
                }
                //System.out.println(Arrays.toString(stringSorted));
                return 0;
            }

        
        };

        Arrays.sort(stringSorted, myComparator);
        int count = 0;
        for(int i = 0 ; i< numbers.length ; i++){
           //System.out.println(stringSorted[i]);
           answer += stringSorted[i];
           count+=Integer.parseInt(stringSorted[i]);
        }

    
                

        return  count !=0 ? answer : Integer.toString(count);
    }
}
    public static void main(String[] args) {
        int[] array_sort = { 4, 1, 3, 2 };
        int[] tmp = Arrays.copyOfRange(array_sort, 1, 3);
        System.out.println(Arrays.toString(tmp));
        Arrays.sort(tmp);
    }

}