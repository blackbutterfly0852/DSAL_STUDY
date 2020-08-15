import java.util.Arrays;

// 병합정렬 from Java
// 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
// 각 부분 리스트를 재귀적으로 병합 정렬을 이용해 정렬한다.
// 두 부분 리스트를 다시 하나의 정렬된 리스트로 병합한다.
// 중요!! 크기가 (1->2->4) 순으로 두 개의 리스트들을 병합 정렬 
//        아래는 크기가 4인 리스트를 병합정렬시 -> 2차 끼리 병합정렬 후 1차가 나오면 1차까리 병합정렬
//       
// ex) {1,9,3,2} : 해석은 아래부터 위로
//              right = none
//              right = 2
//sp(2)	        data  = 2         -> 2차 right
//              left  = 3
//sp(3)	        data  = 3         -> 2차 left
//sp(3,2)	    data  = 3,2       -> 1차 right
//              left  = none
//              right = 9
//sp(9)	        data  = 9         -> 2차 right
//              left  = 1
//sp(1)	        data  = 1         -> 2차 left
//sp(1,9) 	    data  = 1, 9      -> 1차 left
//sp(1,9,3,2)	data  = 1, 9, 3, 2 
public class MergeSort_Concept {
    public static int[] buff;

    public static void mergeExample(int[] a, int aSize, int[] b, int bSize, int[] c) {
        // int[] a = {2,4,6,8,11,13}
        // int[] b = {1,2,3,4,9,16,21}
        int a_idx = 0;
        int b_idx = 0;
        int c_idx = 0;
        // 1. a array, b array 둘다 존재하는 경우
        while (a_idx < aSize && b_idx < bSize) {
            c[c_idx++] = a[a_idx] <= b[b_idx] ? a[a_idx++] : b[b_idx++];
        }
        // 2. a array만 존재하는 경우
        while (a_idx < aSize) {
            c[c_idx++] = a[a_idx++];
        }
        // 3. b array만 존재하는 경우
        while (b_idx < bSize) {
            c[c_idx++] = b[b_idx++];
        }

        System.out.println(Arrays.toString(c));

    }

    public static void __mergeSort(int[] a, int left, int right) {
        // 중요!! 기본적으로 a array를 새로 생성하지 않고, 그대로 가져와 idx로 구분한다.
        if (left < right) {
            int i; // a array를 buff로 복사할 때 주어진 길이에서 왼쪽부터 넣기 위한 용도.
            int center = (left + right) / 2;
            int p = 0; // a array buff로 복사시 buff array의 첫 idx(0) 부터 넣기 위한 용도.
            int j = 0; // 이미 복사된 buff array의 첫 idx(0)부터 검색하기 위한 용도.
            int k = left; // 다시 buff array와 a array를 비교 후 a array의 가장 왼쪽 부터 넣기 위한 용도.

            __mergeSort(a, left, center);
            __mergeSort(a, center + 1, right);

            // 1. a array의 왼쪽 요소를 buff의 저장
            for (i = left; i <= center; i++) {
                buff[p++] = a[i]; // 이때 p = center - left + 1
                                    // p는 a array의 왼쪽요소의 길이 + 1, 즉 a array 오른쪽 요소 시작 idx
                                    // i는 a array의 왼쪽 idx 값 + a array의 왼쪽 요소의 길이
            }
            // 2. buff와 a array의 오른쪽 요소를 비교하여 다시 a에 저장
            while (i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }
            // 3. 만약 buff가 남아있다면 a에 복사
            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    public static void mergeSort(int[] a, int a_length) {
        buff = new int[a_length];
        __mergeSort(a, 0, a_length - 1);
        
        buff = null;
    }

    public static void main(String[] args) {

        int[] a = { 2000, 4, 92, 8, 400, 13 };
        int[] b = { 1, 2, 3, 4, 9, 16, 21 };
        // int[] c = new int[a.length + b.length];
        // mergeExample(a, a.length, b, b.length, c);
        mergeSort(a, a.length);
        mergeSort(b, b.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }

}