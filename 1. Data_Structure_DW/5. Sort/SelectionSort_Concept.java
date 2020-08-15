// 선택정렬
// 주어진 데이터 중, 최소값을 찾음
// 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
// 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함
// 시간복잡도는 BubbleSort와 동일
// 중요!! 회차가 끝날 때마다 맨 앞 부터 순차적으로 작은 값이 정해진다.
// -> 0 < length // i+1 < length
// ex) 4,7,1,3
// 1회차 : idx 0 기준 -> idx 1, 2, 3 비교 -> idx 0 보다 작으면 min 및 idx 업데이트 [min, x, x, x]   -> [1,7,4,3]
// 2회차 : idx 1 기준 -> idx 2, 3 비교 -> idx 1 보다 작으면 min 및 idx 업데이트 [min, mi2, x, x]    -> [1,3,4,7]
// 3회차 : idx 2 기준 -> idx 3 비교 -> idx 2보다 작으면 min 및 idx 업데이트 [min, min2, min3, min4] -> [1,3,4,7]

import java.util.*;

public class SelectionSort_Concept {

    public static void selectionSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            System.out.print(i + 1 + "회차 : ");
            int min = list[i];
            int idx = i;
            Boolean isChanged = false;
            for (int j = i + 1; j < list.length; j++) {
                if (min > list[j]) {
                    min = list[j];
                    idx = j;
                    isChanged = true;
                }
            }
            if (isChanged) {
                int tmp = list[i];
                list[i] = list[idx];
                list[idx] = tmp;
            }
            System.out.print(Arrays.toString(list) + " ");
            System.out.println(" ");

        }

    }

    public static void main(String[] args) {
        int[] list_0 = { 1, 9, 3, 2 };
        int[] list_1 = { 1, 2, 3, 5, 4 };
        int[] list_2 = { 9, 3, 2, 5 };
        int[] list_3 = { 5, 2, 1, 3, 4 };
        int[] list_4 = { 4, 5, 2, 3, 1 };
        int[] list_5 = { 4, 7, 1, 3 };
        selectionSort(list_5);

    }

}