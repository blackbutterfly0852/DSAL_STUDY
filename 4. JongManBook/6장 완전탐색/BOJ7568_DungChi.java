
//201115 BOJ7568_덩치
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ7568_DungChi {
    // 1. 경우의 수 
    // 1) 최대 50명이면 50+49+48+...+1 = 50*51 / 2 = 1275 -> 완전탐색으로 충분히 가능하다.

    
    public static void main(String[] args) throws IOException {
        // 1. 초기화
        // 1) 각 데이터를 분리해서 저장한다. (상태, 몸무게, 키)
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
      
        // int[] state = new int[n];
        // int[] weight = new int[n];
        // int[] height = new int[n];

        // for(int i = 0 ; i < n ; ++i){
        //     weight[i] = sc.nextInt();
        //     height[i] = sc.nextInt();
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] state = new int[N];
        int weight[] = new int[N];
		int height[] = new int[N];
		
		for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
			
        }
        
       
        // 2. 완전 탐색 진행
        // 1) N(N+1) / 2 완전탐색 하면서 상태값 배열을 업데이트 후 별도로 상태값 배열을 출력
        // for(int i = 0 ; i < N ; ++i){
        //     int wa = weight[i];
        //     int ha = height[i];
        //     for(int j = i+1 ; j < N ; ++j){
        //         int wb = weight[j];
        //         int hb = height[j];

        //         if(wa > wb && ha > hb){
        //             state[j] ++;
        //         }else if ( wb > wa && hb > ha){
        //             state[i] ++;
        //         }

        //     }
        // }

        // for(int i : state){
        //     System.out.print(i+1 + " ");
        // }

        // 2) N^2 완전 탐색하면서 상태값 배열 사용 없이 바로 출력 -> 조금 더 빠름.
        for(int i=0; i<N; i++) {
			int count = 0;
			for(int j=0; j<N; j++) {
				if(height[i]<height[j] && weight[i]<weight[j]) {
					count++;
				}
			}
			sb.append(count+1).append(" ");
		}
		
		System.out.println(sb);
    }
    
    
}
