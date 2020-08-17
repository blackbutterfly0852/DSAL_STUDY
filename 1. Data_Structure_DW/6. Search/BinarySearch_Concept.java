// 1. 이진 탐색 (Binary Search) 이란?
//  1) 정렬이 전제조건
//  2) 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법
//  3) 분할 정복 알고리즘과 이진 탐색
//    -> 분할 정복 알고리즘 (Divide and Conquer)
//    -> Divide: 문제를 하나 또는 둘 이상으로 나눈다.
//    -> Conquer: 나눠진 문제가 충분히 작고, 해결이 가능하다면 해결하고, 그렇지 않다면 다시 나눈다.
//  4) 이진 탐색
//    -> Divide: 리스트를 두 개의 서브 리스트로 나눈다.
//    -> Comquer
//       검색할 숫자 (search) > 중간값 이면, 뒷 부분의 서브 리스트에서 검색할 숫자를 찾는다.
//       검색할 숫자 (search) < 중간값 이면, 앞 부분의 서브 리스트에서 검색할 숫자를 찾는다.

//  5) 시간복잡도
//    -> 𝑙𝑜𝑔2𝑛  = k
//    -> 빅 오 표기법으로는 k + 1 이 결국 최종 시간 복잡도임 (1이 되었을 때도, 비교연산을 한번 수행)
//    -> 결국 O(𝑙𝑜𝑔2𝑛 + 1) 이고, 2와 1, 상수는 삭제 되므로, O(𝑙𝑜𝑔𝑛)

public class BinarySearch_Concept {
    // from java
    public static boolean binarySearch(int[] list, int search_data) {
        boolean answer = false;
        int left_idx = 0;
        int right_idx = list.length - 1;
        // 중요!! 오름차순 기준으로 right_idx가 어느 위치든, 
        // 찾고자하는 데이터는 해당 시점의 right_idx의 안쪽 범위에 존재하거나 없다.
        while (left_idx <= right_idx) { 
            int center_idx = (left_idx + right_idx) / 2; 
            if (search_data == list[center_idx]) {
                return true;
            } else if (search_data < list[center_idx]) {
                right_idx = center_idx - 1; 
            } else if (search_data > list[center_idx]) {
                left_idx = center_idx + 1;
            }
        }
        return answer;
    }
    // from python -> 확실히 python -> java는 비효율적이다
    public static boolean binarySearch_2(int[] list, int left, int right, int search_data) {
        System.out.println("시작");
        boolean answer = false;
        int center_idx = (left + right) / 2;
        int rc = right - center_idx;
        int lc = center_idx - left;

        // 1. list의 기준값이 search_data 인 경우.
        if (search_data == list[center_idx]) {
            return true;
        // 2. 기준 인덱스와의 차이가 1이며, search_data 인 경우.
        } else if ((rc == 1 || lc == 1)
                && ((list[center_idx + 1] == search_data) || (list[center_idx - 1] == search_data))) {
            return true;
        // 3. 기준 인덱스와의 차이가 1이며, search_data가 아닌 경우.
        } else if ((rc == 1 || lc == 1)
                && ((list[center_idx + 1] != search_data) || (list[center_idx - 1] != search_data))) {
            return false;
        }
        // 4. 찾는 값(search_data)가 list의 중앙값(list[center_idx]) 보다 작은 경우
        if (search_data < list[center_idx]) {
            return binarySearch_2(list, left, center_idx, search_data);

        // 5. 찾는 값(search_data)가 list의 중앙값(list[center_idx]) 보다 큰 경우
        } else if (search_data > list[center_idx]) { 
            return binarySearch_2(list, center_idx, right, search_data);

        }
        return answer;

    }

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        System.out.println(binarySearch(list, 21));

    }

}