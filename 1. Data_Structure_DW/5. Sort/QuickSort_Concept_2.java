import java.util.*;
// FASTCAMPUS (Python -> JAVA)
public class QuickSort_Concept_2 {

    static int sorted[];

    public static int[] quickSort(int[] list) {
        // 1. 초기화
        int[] left;
        int[] right;
        int[] sorted;

        if (list.length <= 1) {
            return list;
        }

        int pivot_idx = list.length / 2;

        ArrayList<Integer> tmp_left = new ArrayList<Integer>();

        ArrayList<Integer> tmp_right = new ArrayList<Integer>();

        // 2. pivot 기준으로 left, right 분리
        for (int i = 0; i < list.length; i++) {
            // i가 pivot_idx가 아닌경우
            if (i != pivot_idx) {
                // 2-1. 기준점을 기준으로 기준점보다 작은 경우 left에 대입
                if (list[i] < list[pivot_idx]) {
                    tmp_left.add(list[i]);
                // 2-2. 기준점을 기준으로 기준점보다 클 경우 right에 대입
                } else {
                    tmp_right.add(list[i]);
                }
            }
        }

        // 3. left, right 재귀함수 + pivot
        // 3-1. left
        left = new int[tmp_left.size()];
        for (int l = 0; l < left.length; l++) {

            left[l] = tmp_left.get(l);
        }
        left = quickSort(left);

        // 3-2. right
        right = new int[tmp_right.size()];
        for (int r = 0; r < right.length; r++) {
            right[r] = tmp_right.get(r);
        }
        right = quickSort(right);

        // 3-3. merge(left + pivot + right)
        ArrayList<Integer> tmp_sorted = new ArrayList<Integer>();
        for (int l = 0; l < left.length; l++) {
            tmp_sorted.add(left[l]);

        }
        tmp_sorted.add(list[pivot_idx]);
        for (int r = 0; r < right.length; r++) {
            tmp_sorted.add(right[r]);

        }
        // 3-4. list -> Array
        System.out.println("tmp_sorted " + tmp_sorted);
        sorted = new int[tmp_sorted.size()];
        for (int s = 0; s < sorted.length; s++) {
            sorted[s] = tmp_sorted.get(s);
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] test_0 = { 1, 9, 3, 2 };
        int[] test_1 = {6, 17, 19, 20, 42, 49, 63, 65, 67, 74};
        System.out.println(Arrays.toString(quickSort(test_1)));

    }

}