// 가장 먼 노드
import java.util.*;


public class Graph_1 {
    
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];
        boolean[][] visited = new boolean[n+1][n+1];
        
        for(int[] e : edge){
            visited[e[0]][e[1]] = true;
            visited[e[1]][e[0]] = true;
        }

        for(boolean[] v : visited){
            System.out.println(Arrays.toString(v));
        }
        System.out.println("");
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        int max = 0;
        while(!q.isEmpty()){
            int idx = q.poll();
            System.out.println("idx : " + idx);
            for(int j = 2 ; j <= n ;j ++){
                if(distance[j] == 0 && visited[idx][j]){
                    distance[j] = distance[idx] + 1;
                    q.add(j); 
                    System.out.println(Arrays.toString(distance) + " " + q.size());
                   
                }
            }
            System.out.println("-----------------");
        }

        Arrays.sort(distance);
        for(int i = distance.length-2 ; i>0 ; i--){
            if(distance[distance.length-1] == distance[i]){
                answer ++;
            }else{
                break;
            }
        }

        
        
        return answer+1;
    }
    public static void main(String[] args) {
        // int n = 7;
        // int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2},{7,5}};

        int n = 4;
        int[][] edge = {{2, 1}, {3, 2}, {2, 4}, {4, 3},{1,3}};
        //int[][] edge = {{1, 2}, {1, 3}, {2, 4}, {3, 2}, {3, 6}, {4, 3}, {5, 2}};
        System.out.println(solution(n, edge));
                
    }
    
}
