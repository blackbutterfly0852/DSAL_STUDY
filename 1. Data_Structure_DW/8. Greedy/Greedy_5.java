import java.util.Arrays;
import java.util.Comparator;
// 크루스칼 알고리즘
public class Greedy_5 {
  
    static int[] parent ;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        // 1. 초기화
        // 1) 간선 비용 기준 오름차순 정렬 
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
               
            }
        });
        for(int i = 0 ; i < costs.length ; i ++){
            System.out.print(Arrays.toString(costs[i]) + " ");
        }
        System.out.println("" );
        // 2) 부모노드설정
        parent = new int[n];
        for(int i = 0 ; i < n ; i ++){
            parent[i] = i;
        }

        for(int i = 0 ; i < costs.length ; i ++){
            int[] edges = costs[i];
            int start = edges[0];
            int end = edges[1];
            int cost = edges[2];

            int a = find(start);
            System.out.println(Arrays.toString(parent));
            int b = find(end);
            System.out.println(Arrays.toString(parent));
            
            if(a == b) continue;
            union(a,b);
            System.out.println(Arrays.toString(parent));
            System.out.println("---------------------");
            answer += cost;
        }
       
        return answer;
    }

    // find : rootNode 찾기, pathCompression
    public static int find(int node){
        if(node == parent[node]) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    // union : find 후 합치기, unionByRank -> (Rank 확인 안함)
    public static void union(int n1, int n2){
        int findN1 = find(n1);
        int findN2 = find(n2);
        if(findN1 != findN2){
            parent[findN1] = n2;
        }else{
            return;
        }
    }

  
    public static void main(String[] args) {
        int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;
        System.out.println(solution(n, costs));
         
    }

    
}
