public class BaseStationInstallation {

    public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		boolean[] init = new boolean[n];

		// 초기 기지국 세팅
		for (int i = 0; i < stations.length; i++) {
			init[stations[i] - 1] = true;
		}

		// 초기 기지국 앞, 뒤로 세팅
		for (int i = 0; i < init.length; i++) {
			
			if (init[i]) {
                // 기지국 앞 세팅
				for (int j = 1; j <= w; j++) {
					if (i + j < n) {
						init[i + j] = true;
					}
				}
                // 기지국 뒤 세팅
				for (int j = w; j >= 1; j--) {
					if (i - j >= 0) {
						init[i - j] = true;
					}
				}

				i = i + w + 1;
			}

		}
        
        // 남은 기지국으로 계산
		for (int i = 0; i < init.length; i++) {
			if (!init[i]) {
				if (i + w < n) {

					answer++;
					i = i + w + 1;
				}

			}

		}

		return answer;
	}
	    public static void main(String[] args) {
	    	int n = 16;
	    	int[] stations = {9};
	    	int w = 2;
			System.out.println(solution(n,stations,w));
	    	

	    	
	    }
    
}
