import java.util.*;
public class Graph_1_1 {

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i = 0 ; i < edge.length ; i ++){
            Arrays.sort(edge[i]);
        }
        Arrays.sort(edge, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] e : edge){
            System.out.print(Arrays.toString(e));
        }
        System.out.println("");

        Integer[] distance = new Integer[n+1];
        distance[0] = 0;
        distance[1] = 0;
        for(int i = 2 ; i < distance.length ; i++){
            distance[i] = Integer.MAX_VALUE;
        }
              
        Queue<int[]> q = new LinkedList<int[]>();
        for(int[] e : edge){
            q.add(e);
        }
        while(!q.isEmpty()){
            int[] node = q.poll(); // {1,2}
            System.out.println(node[0] + " " + node[1]);
                if(node[0] == 1){
                    distance[node[1]] = 1;
                }else{
                    if(distance[node[1]] > distance[node[0]]+ 1 ){
                    distance[node[1]] = distance[node[0]] + 1;
                    }
                }
         
     
            System.out.println(Arrays.toString(distance));
    
        }
    
        Arrays.sort(distance);

        System.out.println(Arrays.toString(distance));
        for(int i = distance.length-2 ; i > 0 ; i --){
            if(distance[distance.length-1] == distance[i]){
                answer ++;
            }else{
                break;
            }

        }
       
        return answer+1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 4}};
        //int[][] edge = {{1, 2}, {1, 3}, {2, 4}, {3, 2}, {3, 6}, {4, 3}, {5, 2}};
        System.out.println(solution(n, edge));
        
        
    }
    
    
}
