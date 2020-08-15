import java.util.Arrays;

public class Sort_Review {
    // 오름차순 기준

    // 1. BubbleSort(버블정렬)
    // 중요!! 회차가 끝날때마다 마지막 요소가 결정
    // 시간복잡도 : O(n^2), O(n(n-1)/2), O(n)
    public static int[] bubbleSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            // 특정 회차부터 변경이 안되었다면 break
            boolean isChanged = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
        return list;
    }

    // 2. InsertionSort(삽입정렬)
    // 중요!! 기준 idx가 1 부터 시작하며, 해당 기준 idx에서 0번째까지 정렬 후, 다음 기준 idx로 넘어간다.
    // 시간복잡도 : O(n^2), O(n(n-1)/2), O(n)
    public static int[] insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    int tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                } else {
                    // no break? 이미 정렬된 것을 재탐색
                    break;
                }
            }
        }
        return list;
    }

    // 3. SelectionSort(선택정렬)
    // 중요!! 회차가 끝날 때마다 맨 앞의 요소가 정해진다.
    public static int[] selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < list.length - 1; j++) {
                if (list[j] < list[j + 1]) {
                    min_idx = j;
                }
            }
            if (list[i] > list[min_idx]) {
                int tmp = list[i];
                list[i] = list[min_idx];
                list[min_idx] = tmp;
            }
        }
        return list;
    }

    // 4. QuickSort(큌 정렬)
    // 중요!! pivot 기준으로 왼쪽, 오른쪽 정렬, 배열생성 no(idx로 조정)

    public static int[] quickSort(int[] list, int left, int right) {

        int pivot = list[(left + right) / 2];
        int left_idx = left;
        int right_idx = right;

        // left_idx > right_idx 경우 pivot을 기준으로 정렬되었다는 의미.
        while (left_idx <= right_idx) {
            while (list[left_idx] < pivot) {
                left_idx++;
            }

            while (list[right_idx] > pivot) {
                right_idx--;
            }
            // left_idx와 right_idx가 멈춘 부분은 pivot 기준으로 자리 변경 필요.
            if (left_idx <= right_idx) {
                int tmp = list[left_idx];
                list[left_idx++] = list[right_idx];
                list[right_idx--] = tmp;
            }

        }
        // pivot 기준으로 정렬이 되면, pivot 왼쪽 / 오른쪽을 각각 다시 재귀함수로 호출.
        // left_idx > right_idx -> left에 가까운 right_idx, right에 가까운건 left_idx
        if (left < right_idx) {
            quickSort(list, left, right_idx);
        }

        if (left_idx < right) {
            quickSort(list, left_idx, right);
        }

        return list;
    }

    static int[] buff;

    // 5. MergeSort(병합정렬) : list 크기 1 까지 쪼갠 후 2 -> 4 -> 8 -> 16 정렬
    // 중요!! 배열생성 no(idx로 조정)
    // 안정적

    public static int[] mergeSort(int[] list, int left, int right) {
        // {0,1} 생각
        if (left < right) {
            int center = (left + right) / 2;
            int p = 0;
            int i;
            int j = 0;
            int k = left; // list 재대입 하기 위한 변수

            mergeSort(list, left, center);
            mergeSort(list, center + 1, right);

            // 1. list의 왼쪽을 buff의 복사
            for (i = left; i <= center; i++) {
                buff[p++] = list[i];
            }
            // 2. buff와 list의 오른쪽 비교 후 list에 재대입
            while (i <= right && j < p) {
                list[k++] = list[i] > buff[j]  ? buff[j++] : list[i++];
            }
            // 3. 만약 buff가 남아있다면 list에 대입
            while (j < p) {
                list[k++] = buff[j++];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = { 5, 7, 1, 5, 6, 2, 3, 9, 8 };
        System.out.println(Arrays.toString(bubbleSort(list)));
        System.out.println(Arrays.toString(insertionSort(list)));
        System.out.println(Arrays.toString(selectionSort(list)));
        System.out.println(Arrays.toString(quickSort(list, 0, list.length - 1)));
        buff = new int[list.length];
        System.out.println(Arrays.toString(mergeSort(list, 0, list.length - 1)));
    }

}