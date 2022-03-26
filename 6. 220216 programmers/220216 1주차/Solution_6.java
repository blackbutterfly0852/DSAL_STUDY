public class Solution_6 {
    public static int solution(int[][] taxes, int income){
        int answer = 0;
          
        boolean flag = false;
        for(int i = 0 ; i < taxes.length-1 ; i ++){
            if(income > taxes[i][0]){
                if(i-1<0){
                    answer += (taxes[i][0]) * taxes[i][1]/100;
                }else{
                    answer += (taxes[i][0]-taxes[i-1][0]) * taxes[i][1]/100;
                }
            }else {
                if(i-1<0){
                    answer += (income) * taxes[i][1]/100;
                }else{
                    answer += (income -taxes[i-1][0]) * taxes[i][1]/100;
                }
                flag = true; 
            }
        }

        if(!flag){
            answer+= (income -taxes[taxes.length-2][0]) * taxes[taxes.length-1][1]/100;
          
        }
     
        return answer ;
    }
    

    public static void main(String[] args) {
        //int[][] taxes = {{1200,6},{4600,15},{8800,24},{15000,35},{0,38}};
        //int income = 9500;

        //int[][] taxes = {{1000,1},{0,10}};
        //int income = 2000;

        //int[][] taxes = {{1500,12},{3500,23},{5700,29},{0,30}};
        //int income = 6400;

        //int[][] taxes = {{49900,99},{0,50}};
        //int income = 50000;

        int[][] taxes = {{5000,50},{0,50}};
        int income = 1000;
        System.out.println(solution(taxes, income));
    }
}
