import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class Practice {
    public static int[] solution(int[][] tickets) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> X = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> Y = new HashMap<Integer, Integer>();
        for (int i = 0; i < tickets.length; i++) {
            if (!X.containsKey(tickets[i][0])) {
                X.put(tickets[i][0], 1);
            } else {
                X.remove(tickets[i][0]);
            }

            if (!Y.containsKey(tickets[i][1])) {
                Y.put(tickets[i][1], 1);

            } else {
                Y.remove(tickets[i][1]);
            }

        }

        for (int x : X.keySet()) {
            answer[0] = x;
        }
        for (int y : Y.keySet()) {
            answer[1] = y;
        }
        System.out.println(answer.toString());

        return answer;
    }

    public static List<Long> dividedAmount(long initAmt, int initCnt){
        
        long leftMoney = initAmt;
        int leftCnt = initCnt;
        long minValue = 0L;
        long maxValue = initAmt/initCnt * 2;

        System.out.println(maxValue);
        List<Long> dividedList = new ArrayList<>();
        for(int i = 0 ; i < initCnt-1 ; i++){
            int currInt = (int) (Math.random()*leftCnt+1)+1;
            System.out.println("curr : " + currInt);
            long dividedMoney = Math.max(minValue,Math.min(maxValue,leftMoney / currInt));
            dividedList.add(dividedMoney);
            leftMoney-=dividedMoney;
           
        }
        dividedList.add(leftMoney);
     
        return dividedList;
    }

    public static void main(String[] args) {
        long initSum = 21231230;
        Long sum = 0L;
        List<Long> lists = dividedAmount(initSum, 50);
        for(Long l : lists){
            System.out.println(l);
            sum += l;
        }

        if(sum ==initSum ){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
       

    }

}