import java.util.*;
public class Exam_1 {
    

    public static class Request{
        int reqTime ;
        int workTime;

        public Request(int reqTime, int workTime){

            this.reqTime = reqTime;
            this.workTime = workTime;
        }

    }
    
    public static int solution(int N, int[][] simulation_data) {
        int answer = 0;
        boolean[] visited = new boolean[N];
        int[] workedTimeList = new int[N];
        Queue<Request> q = new  LinkedList<Request>();

        for(int[] request : simulation_data){
            q.add(new Request(request[0], request[1]));
        }

        //System.out.println(q.size());
        
        int time = -1; // 전체 흐른 시간 초
        while(!q.isEmpty()){
            
            System.out.println(time);
            System.out.println(Arrays.toString(workedTimeList));
            time+=1;
            
            //  작업 넣기
            int cnt = 0;
            for(int i = 0 ; i < N ; i ++){
                if(!visited[i]){
                    Request person = q.poll();
                    visited[i] = true;
                    cnt ++;
                   
                    workedTimeList[i] = person.reqTime +person.workTime;
                    break;
                }
            }
            int min = Integer.MAX_VALUE;
            if(cnt == 0){
                System.out.println("들어옴");
                for(int i = 0 ; i < N ; i ++){
                    min = Math.min(min, workedTimeList[i]);
                }
                System.out.println(min);
                System.out.println(q.peek().reqTime);
                answer += min - q.peek().reqTime;
                System.out.println("answer : " + answer);
            }

            

            // 작업 빼기
            for(int i = 0 ; i < N ; i ++){
                if(workedTimeList[i] == time){
                    visited[i] = false;
                    workedTimeList[i] = 0;
                    break;
                }
            }
          
            System.out.println(Arrays.toString(workedTimeList));
            System.out.println("----------");

        }


        
        return answer;
    }
    public static void main(String[] args) {
        //int N = 2;
        //int[][] simulation_data = {{0,3},{2,5},{4,2},{5,2}};

        int N = 1;
        int[][] simulation_data = {{2,3},{5,4},{6,3},{7,4}};
        System.out.println(solution(N, simulation_data));
       
        
    }
}