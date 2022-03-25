public class BaseStationInstallation {

    public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		boolean[] init = new boolean[n];

		// 초기 기지국 세팅
		for (int i = 0; i < stations.length; i++) {
			init[stations[i] - 1] = true;
		}

		int cnt = 0;
		for (int i = 0; i < init.length; i++) {
			if(!init[i]){
				System.out.println("1_init[i] : " + init[i]);
				cnt++;
				System.out.println("1_cnt : " + cnt);
			}
			if(cnt == (2*w+1)){
				answer++;
				cnt = 0;
				System.out.println("2_answer : " + answer);
				System.out.println("2_cnt : " + cnt);
			}else if(init[i] && cnt>w ){
				answer++;
				cnt = 0;
				i = i+w;
				System.out.println("3_answer : " + answer);
				System.out.println("3_i : " + i);

			}else if(init[i] && cnt<w && cnt>0){
				answer++;
				cnt = 0;
				i = i+w;
				System.out.println("4_answer : " + answer);
				System.out.println("4_i : " + i);

			}
		}

		return answer;
	}
	    public static void main(String[] args) {
	    	int n = 11;
	    	int[] stations = {4,11};
	    	int w = 1;
			System.out.println(solution(n,stations,w));
	    	

	    	
	    }
    
}
