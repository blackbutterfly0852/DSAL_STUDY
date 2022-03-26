public class Solution_4 {

    public static String solution(int a, int b) {
        int months[] = {31, 29, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
        String days[] = {"THU","FRI", "SAT", "SUN", "MON", "TUE", "WED" };

        int sum_days = 0;
        for(int i = 0 ; i < a-1; i++){
            sum_days += months[i];
        }
        sum_days+= b;

        String answer = days[sum_days%7];
        return answer;
    }
    
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        System.out.println(solution(a, b));
    }
}
