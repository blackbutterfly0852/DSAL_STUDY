import java.util.*;

// 순차 탐색 (Sequential Search) 이란?
// 탐색은 여러 데이터 중에서 원하는 데이터를 찾아내는 것을 의미
// 데이터가 담겨있는 리스트를 앞에서부터 하나씩 비교해서 원하는 데이터를 찾는 방법
// 최악의 경우 리스트 길이가 n일 때, n번 비교해야 함 -> O(n)
public class SequentialSearch_Concept {

    public static boolean sequentialSearch(int[] list, int serach_data) {
        Boolean answer = false;

        for (int num : list) {
            if (num == serach_data) {
                answer = true;
                break;
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        int[] answers = { 1, 2, 3, 4, 5 };
        System.out.println(sequentialSearch(answers, 6));
        System.out.println("");
    }

}