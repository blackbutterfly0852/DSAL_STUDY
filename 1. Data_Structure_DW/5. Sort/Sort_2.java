import java.util.*;




// 가장 큰 수
public class Sort_2 {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] stringSorted = new String[numbers.length];
        System.out.print("stringSorted : " );
        for(int i = 0 ; i< numbers.length ; i++){
            stringSorted[i] = Integer.toString(numbers[i]);
            System.out.print(stringSorted[i] + " ");
           
        }
        System.out.println("");
        // stringSorted = {"6", "10", "2"};
        Arrays.sort(stringSorted, new Comparator<String>(){
            // a : 10(idx = 1), b : 6(idx = 0)
            // 중요 return 값이 양수인 경우만 자리 변경(Comparable.CompareTo() // Comparator.Compare() 모두 적용)
            public int compare(String a , String b){ 
                System.out.println("-----" + Arrays.toString(stringSorted));
                System.out.println("a : " + a + " b : " + b);
                System.out.println("b+a : " + (b+a));
                System.out.println("a+b : " + (a+b));
                System.out.println("값 : " + (b + a).compareTo(a + b));
                 // (b+a) = 610 > (a+b) = 106 -> string a(기준객체), String b(비교 객체) 위치 변경
                 // 왜냐하면 처음 시작시, 기준 객체가 idx 1, 비교 객체가 idx 0 ->  기준객체가 10 vs 비교객체가 6이므로 10, 6 자리 변경
                 // 중요!! stringSorted의 배열 순서보다 처음 시작시 기준객체가 idx1, 비교 객체가 idx0인 것에 주목하자.
                return (b + a).compareTo(a + b);
            }
        });
        System.out.println("****" + Arrays.toString(stringSorted));
            
        // Comparator<String> myComparator = new Comparator<String>() {
        //     @Override
        //     // 중요!! 기준은 앞 // 1 : 자리변경, // -1, 0 : 자리미변경 
        //     public int compare(String a, String b) { 
        //         // 1-1. 해당 요소보다 다음 요소가 큰 경우 -> 변경      ex) 3 vs 4
        //         if(a.charAt(0) < b.charAt(0)){
        //             return 1;
        //         // 1-2. 해당 요소가 다음 요소보다 큰 경우 -> 미변경    ex) 3 vs 2
        //         }else if(a.charAt(0) > b.charAt(0)){
        //             return -1;
        //         // 1-3. 해당 요소와 다음 요소가 같은 경우              ex) 3 vs 3
        //         }else if(a.charAt(0) == b.charAt(0)){
        //             // 1-3-1. 해당 요소와 다음 요소의 길이가 같은 경우 ex) 30 vs 34   333 334
        //             if(a.length() == b.length()){
        //                 // 1-3-1-1. 해당 요소보다 다음 요소가 큰 경우 -> 변경
        //                 if(Integer.parseInt(a) < Integer.parseInt(b)){ 
        //                     return 1;
        //                 // 1-3-1-1. 해당 요소가 다음 요소보다 큰 경우 -> 미변경    
        //                 }else{
        //                     return -1;
        //                 }
        //             // 1-3-2. 해당 요소와 다음 요소의 길이가 다른 경우 ex)  30%3 = 0, 31%3 = 1, 32%3 = 2 -> 330, 331, 332
        //             //                                                    33%3 = 0, 34%3 = 1, 35%3 = 2 -> 333, 343 ,353
        //             }else{
        //                  String tmp_ab = a+b;
        //                  String tmp_ba = b+a;
        //                 // 1-3-2-1. 해당요소가 다음요소보다 작거나 같은 경우 -> 변경
        //                 if( Integer.parseInt(tmp_ab) <= Integer.parseInt(tmp_ba)){
        //                    return 1;
        //                 // 1-3-2-1. 해당요소가 다음요소보다 큰 경우 -> 미변경
        //                 }else{
        //                    return -1;
        //                 }
        //             }
        //         }
        //         //System.out.println(Arrays.toString(stringSorted));
        //         return 0;
        //     }
        // };

        // Arrays.sort(stringSorted, myComparator);
       
        int count = 0;
        for(int i = 0 ; i< numbers.length ; i++){
           //System.out.println(stringSorted[i]);
           answer += stringSorted[i];
           count+=Integer.parseInt(stringSorted[i]);
        }
        return  count !=0 ? answer : Integer.toString(count);
    }

    public static void main(String[] args) {
        int[] numbers_1 = {6, 10, 2};
        int[] numbers_2 = {3, 30, 34, 5, 9};
        int[] numbers_3 = {3, 30, 34, 5, 9};
        int[] numbers_4 = {3, 30, 31, 5, 9};
        int[] numbers_5 = {0, 0, 0, 0, 0};
        int[] numbers_6 = {235 , 23585 };
        System.out.println(solution(numbers_1));
        
    }


    
}