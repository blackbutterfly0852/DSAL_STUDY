import java.util.*;

public class Greedy_4 {

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int idx = 0;
        int answer = people.length;

        for(int i = people.length - 1 ; i >= idx ; i --){
            System.out.println("i : " + i  + " " + idx);
            if(idx == i ){
                break;
            }
            if(people[i] + people[idx] <= limit){ // idx 가 안되었다는 의미는 idx와 같이 탈 사람이 없다는 의미.
                idx ++;
                answer --;
            }

            if(idx == i ){
                 break;
            }
        }
    

        //System.out.println(Arrays.toString(people));
        return answer;
   
    }


    public int solution_2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

    public static void main(String[] args) {

        //int[] people = {70,50,80,50};
        //int[] people = {70,80,50};
        //int[] people = {70,80,50,20,70,30,20,50};
        //int[] people = {70,80,20,25,4};
        int[] people = {25,30,40,70,80};
        //int[] people = {40,40,40};
        int limit = 100;

        System.out.println(solution(people, limit));
        
    }

}
