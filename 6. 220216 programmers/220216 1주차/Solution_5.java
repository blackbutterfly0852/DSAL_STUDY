import java.util.HashMap;
import java.util.Map;

public class Solution_5 {

    public static int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer, Integer> in = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> out = new HashMap<Integer, Integer>();

        for(String record : records){

            String[] temp = record.split(" ");
            int time = calTime(temp[0]);
            int number = Integer.parseInt(temp[1]) ;
            String state = temp[2];

            if(state.equals("OUT")){
                int inTime = in.get(number);
                out.put(number, time - inTime);
                in.remove(number);
                continue;
            }
            in.put(number, time);
        
        }

        for(int number : in.keySet()){
            Integer time = in.get(number);
            time = time==null?0:time;
            int lastTime = calTime("23:59");

            int use_time = lastTime - time;
            Integer alreadyTime = out.get(number);
            alreadyTime = alreadyTime==null?0:alreadyTime;
            out.put(number, use_time + alreadyTime);
            in.remove(number);
           
        }

        int[] answer = new int[out.size()];
        int i  = 0;
        for(int number : out.keySet()){

            int total_use = out.get(number);

            if(total_use <= fees[0] ){
                answer[i] = fees[1];
                i++;
            }else{
                answer[i]=fees[1]+(int)Math.ceil((double)(total_use-fees[0])/fees[2])*fees[3];
                 i++;
            }
        }

        return answer;
    }


    public static int calTime (String time){
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0])*60;
        int min = Integer.parseInt(tmp[1]);
        return hour+min;
    }
    public static void main(String[] args) {
        String a = "19:23";
        String b = "12:42";
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));

        
       
    }

  
    
}
