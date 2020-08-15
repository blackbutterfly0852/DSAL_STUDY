// 정렬 (sorting): 어떤 데이터들이 주어졌을 때 이를 정해진 순서대로 나열하는 것
// 버블정렬(BubbleSort) : 두 인접한 데이터를 비교해서, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬 알고리즘
// 시간복잡도
// - 반복문이 두 개 O( 𝑛2 )
// - 최악의 경우,  𝑛∗(𝑛−1)/2 -> 즉 리스트 내 모든 원소를 두 개씩 추출하여 비교 -> 리스트 내 순서의 상관없이 두 개를 추출하는 경우의 수(조합)
// - 완전 정렬이 되어 있는 상태라면 최선은 O(n)
// 중요!! 회차가 끝날때마다 마지막 숫자가 정해진다.
// -> 1 < length // 0 < length-i

// ex) 1,9,3,2
// 1회차
// idx 0,1 비교 -> 1,9,3,2 
// idx 1,2 비교 -> 1,3,9,2 
// idx 2,3 비교 -> 1,3,2,9 
// 2회차
// idx 0,1 비교 -> 1,3,2,9 
// idx 1,2 비교 -> 1,2,3,9
// idx 2,3 비교 -> 1,2,3,9
// 3회차
// idx 0,1 비교 -> 1,2,3,9
// idx 1,2 비교 -> 1,2,3,9
// idx 2,3 비교 -> 1,2,3,9

import java.util.*;
public class BubbleSort_Concept {

    public static void bubbleSort(int[] list) {
        // 오름차순 기준
        // 1. 최대 n-1 회차 -> 회차가 끝날때마다 마지막 숫자가 정해진다.
        for (int i = 1; i < list.length; i++) {          // i :  1 // 2 // 3
            // 1-1. isChanged : 회차가 끝났는데 변경된게 없으면 종료 
            // ex ) 1,2,3,5,4 : 1회차 끝나면 모두 정렬 상태 -> 2회차까지 진행했는데 미변경 -> 3회차부터는 진행 안함.
            //                : 즉, 모두 정렬된 상태 회차 + 1회차 까지 진행 후 종료.
            boolean isChanged = false;
            System.out.println("회차 : " + i);
            for (int j = 0; j < list.length - i; j++) { // j : 0,1,2 // 0,1 // 0
                if (list[j] > list[j + 1]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                    isChanged = true;
                }
            }
            if(!isChanged){
                break;
            }
            System.out.println(Arrays.toString(list));
        }
    }

    public static void main(String[] args) {
        int[] list_0 = {1,9,3,2};
        int[] list_1 = {1,2,3,5,4};
        bubbleSort(list_1);
    }

}