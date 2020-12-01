import java.util.*;

public class Exam1 {
    static int[] winter;
    static int[] spring;
    static int[] summer;
    static int[] autumn;


    public static String solution(int[] T) {
        // 1. 초기화
        init(T.length/4, T);

        // 2. 각 계절의 진폭계산
        int winterA = winter[winter.length-1] - winter[0];
        int springA = spring[spring.length-1] - spring[0];
        int summerA = summer[summer.length-1] - summer[0];
        int autumnA = autumn[autumn.length-1] - autumn[0];

        //3. 비교
        int max = Math.max(winterA,springA);
        max = Math.max(max,summerA);
        max = Math.max(max,autumnA);

        if(max == winterA){
            return "WINTER";
        }else if(max == springA){
            return "SPRING";
        }else if(max == summerA){
            return "SUMMER";
        }else{
            return "AUTUMN";
        }
    }

    public static void init(int length, int[] T){
        winter = new int[length];
        spring = new int[length];
        summer = new int[length];
        autumn = new int[length];

        for(int i = 0 ; i < length ; i++){
            winter[i] = T[i];
        }
        for(int i = length ; i < length*2 ; i++){
            spring[i-length] = T[i];
        }
        for(int i = length*2 ; i < length*3 ; i++){
            summer[i-length*2] = T[i];
        }

        for(int i = length*3 ; i < length*4 ; i++){
            autumn[i-length*3] = T[i];
        }
        
        Arrays.sort(winter);
        Arrays.sort(spring);
        Arrays.sort(summer);
        Arrays.sort(autumn);

    }

    public static void main(String[] args) {
        int[] T = {-3,-14,-5,7,8,42,8,3};
        //int[] T = {2,-3,3, 1,10,8 ,2,5,13, -5,3,-18};
        System.out.println(solution(T));
        
    }
    
}
