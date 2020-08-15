import java.util.*;

// 삽입 정렬은 두 번째 인덱스부터 시작
// 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
// 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동
// 중요!! 해당 idx(key 값)부터 idx0까지 정렬 후 다음 회차로 넘어간다.
// -> 1 < length // i > 0, i--
// 시간복잡도는 BubbleSort와 동일


// ex) 9, 3, 2, 5
// 1회차 : 9, 3, 2, 5 -> 3, 9, 2, 5               : [1,0]          : idx 1 ~ 0 까지 정렬
// 2회차 : 3, 9, 2, 5 -> 3, 2, 9, 5 -> 2, 3, 9 ,5 : [2,1] -> [1,0] : 위의 idx 1 ~ 0 까지 정렬된 기준으로 idx 2를 추가하여 정렬
// 3회차 : 2, 3, 9, 5 -> 2, 3, 5, 9               : [3,2]          : 위의 idx 2 ~ 0 까지 정렬된 기준으로 idx 3를 추가하여 정렬


public class InsertionSort_Concept {
    public static void insertionSort(int[] list) {
        System.out.println("0회차 : " + Arrays.toString(list) + " ");
        // 1. 최대 : n-1 회차 이며 idx는 1부터 시작
        for (int i = 1; i < list.length; i++) { 
            System.out.print(i + "회차 : ");
            // 1-1. 기준값 idx2 -> 만약 idx2와 idx1를 비교 했는데 idx1 값이 큰 경우 우선 idx2와 idx1 위치 변경
            // 1-2. for문 j--로 기준값 idx2는 idx1로 변경
            // 1-3. 만약 idx1이 idx0보다 큰 경우 break;
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j-1]) { 
                    int tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
                
            }
            System.out.print(Arrays.toString(list) + " ");
            System.out.println(" ");
        }

    }

    public static void main(String[] args) {
        int[] list_0 = {1,9,3,2};
        int[] list_1 = {1,2,3,5,4};
        int[] list_2 = {9,3,2,5};
        int[] list_3 = {5,2,1,3,4};
        int[] list_4 = {4,5,2,3,1};
        insertionSort(list_0);
       
    }
}