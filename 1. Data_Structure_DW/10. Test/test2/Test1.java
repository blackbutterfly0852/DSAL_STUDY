public class Test1 {

    public static int solution(int[][] land) {
        int answer = 0;
        for(int i = 0 ; i < land.length-1 ; i ++){
            land[i+1][0] += isBiggest(land[i],0);
            land[i+1][1] += isBiggest(land[i],1);
            land[i+1][2] += isBiggest(land[i],2);
            land[i+1][3] += isBiggest(land[i],3);
                 
        }
        answer = isBiggest(land[land.length-1], 5);
        return answer;
    }


    public static int isBiggest(int[] land, int column){
        int max = 0;
        if(column != 5){
            for(int i = 0 ; i < land.length ; i ++){
                if(i!=column && max <= land[i] ){
                    max = land[i];
                }
            }
        }else{
            for(int i = 0 ; i < land.length ; i ++){
                if( max <= land[i] ){
                    max = land[i];
                }
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
        
    }
    
}
