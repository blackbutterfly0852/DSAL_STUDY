import java.util.*;

public class BruteForceSearch_2 {

    // 순열 저장소 - 중복제거
    static HashSet<Integer> permutation_list = new HashSet<Integer>();

    public static int solution(String numbers) {
        int answer = 0;
        String[] numberToString = new String[numbers.length()];

        // 1. 순열 구하기
        for(int i = 0 ; i < numbers.length() ; i++){
            numberToString[i] = numbers.substring(i, i+1);
        }

        for(int i = 1 ; i <= numberToString.length ; i++){
            boolean[] visited = new boolean[numbers.length()];
            permutation(numberToString, numbers.length(), i, 0, visited, "");
        }

        // 2. 소수 판별
        Iterator it = permutation_list.iterator();
        while(it.hasNext()){
            int setNumber = (int) it.next();
            //System.out.println("setNumber : " + setNumber);
            if(isPrime(setNumber)){
                answer ++;
            }
        }
        //System.out.println("answer = " + answer);
        return answer;
    }

    // 순열(Permutation) : 순서를 생각한다. nPr -> n! / (n-r)!
    // 조합(Combination) : 순서를 생각하지 않는다. 중복을 제거한다. nCr -> n! / r(n-r)!

    public static void permutation(String[] numberToString, int n, int r, int depth, boolean[] visited, String result_number ) {
        if(r == depth){
            permutation_list.add(Integer.parseInt(result_number));
            return;
        }else{
            for(int i = 0 ; i < numberToString.length; i ++){
                if(!visited[i]){
                    visited[i] = true;
                    permutation(numberToString,n,r,depth+1,visited,result_number+numberToString[i]);
                    visited[i] = false; 
                }
            }
        }
    }

    // 소수판별
    // true : 소수, false : 소수 X
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPrime(6));

        solution("011");
    }
}
