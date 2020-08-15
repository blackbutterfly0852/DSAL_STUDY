import java.util.Arrays;

// K번째수
public class Sort_1 {

    static int[] buff;

    public static int[] solution(int[] array, int[][] commands) {
        // 1. 초기화
        int[] answer = new int[commands.length];
        // 2. commands 크기만큼 LOOP
        for (int i = 0; i < commands.length; i++) {
            // 2-1. 정해진 크기만큼 복사
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            // 2-2. 정렬
            // Arrays.sort(tmp);
            buff = new int[tmp.length];
            mergeSort(tmp, 0, tmp.length - 1);
            // 2-3. 특정 위치 대입
            System.out.println(Arrays.toString(tmp));
            answer[i] = tmp[commands[i][2] - 1];
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void mergeSort(int[] array, int left, int right) {

        if (left < right) {
            int center = (left + right) / 2;
            int p = 0;
            int i;
            int j = 0;
            int k = left;

            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);

            for (i = left; i <= center; i++) {
                buff[p++] = array[i];
            }

            while (i <= right && j < p) {
                array[k++] = array[i] > buff[j] ? buff[j++] : array[i++];

            }

            while (j < p) {
                array[k++] = buff[j++];
            }

        }

    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
        solution(array, commands);

    }

}