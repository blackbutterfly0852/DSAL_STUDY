// FASTCAMPUS (Python -> JAVA)
import java.util.*;

public class MergeSort_Concept_2 {
    static int[] sorted;

    // 1. mergeSplict : list의 크기가 1이 될 때까지 자르는 함수
    public static int[] mergeSplict(int[] list) {
        int[] left;
        int[] right;
        // 1-1. list의 크기가 1이하이면 return list;
        if (list.length <= 1) {
            return list;
        }

        // 1-2. 그렇지 않은 경우 list의 크기를 반으로 나눈다.
        int length = list.length / 2;

        int[] tmp_left = new int[length];
        int[] tmp_right = new int[length];

        for (int i = 0; i < length; i++) {
            tmp_left[i] = list[i];
        }
        for (int j = length; j < list.length; j++) {
            tmp_right[j - length] = list[j];
        }

        left = mergeSplict(tmp_left);
        right = mergeSplict(tmp_right);

        // 1-3. 크기가 1인 리스트들을 정렬 및 병합한다.(크기는 점차 증가)
        return merge(left, right);
    }
    // 2. 정렬
    public static int[] merge(int[] left, int[] right) {
        //System.out.println("left.length : " + left.length + " " + left[0]);
        //System.out.println("right.length : " + right.length + " " + right[0]);
        ArrayList<Integer> tmp_sorted = new ArrayList<Integer>();
        sorted = new int[left.length + right.length];
        int left_idx = 0;
        int right_idx = 0;
        // 2-1. left, right 둘 다 존재
        while (left_idx < left.length && right_idx < right.length) {
            // 2-1-1. left가 작은 경우 -> left 추출 후 left_idx +=1
            if (left[left_idx] < right[right_idx]) {
                tmp_sorted.add(left[left_idx]);
                left_idx += 1;
            }
            // 2-1-2. right가 작은 경우 -> right 추출 후 right_idx +=1
            else if (left[left_idx] > right[right_idx]) {
                tmp_sorted.add(right[right_idx]);
                right_idx += 1;
            }

        }

        // 2-2. left만 존재하는 경우
        while (left_idx < left.length) {
            tmp_sorted.add(left[left_idx]);
            left_idx += 1;
        }

        // 2-3. right만 존재하는 경우
        while (right_idx < right.length) {
            tmp_sorted.add(right[right_idx]);
            right_idx += 1;
        }

        // 2-4. ArrayList -> Array로 복사
        for (int i = 0; i < tmp_sorted.size(); i++) {
            sorted[i] = tmp_sorted.get(i);
            //System.out.println(sorted[i]);
        }
        //System.out.println("");
        return sorted;
    }

    public static void main(String[] args) {
        int[] test = { 1, 9, 3, 2 };
        mergeSplict(test);
        System.out.println(Arrays.toString(sorted));

    }

}