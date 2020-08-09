import java.lang.System;
import java.lang.Math;
import java.util.ArrayList;

public class StackQueue_3_1 {
    static int progressesCount;
    static int[] needDays;

    static ArrayList<Integer> workCountStorage;

    public static int[] solution(int[] progresses, int[] speeds) {

        // Init
        progressesCount = progresses.length;
        needDays = new int[progressesCount];
        workCountStorage = new ArrayList<Integer>();

        // 필요한 작업일 계산
        calcNeedDays(progresses, speeds); // needDays = {7,3,9}

        viewAll(needDays, 0);

        // 동시에 진행된 프로세스 계산
        for (int step = 0; step < progressesCount;) {
            int stepNeedDay = needDays[step];

            // 날짜 동시에 경과
            for (int remainStep = step; remainStep < progressesCount; remainStep++) {
                System.out.println("stepNeedDay : " + stepNeedDay);
                needDays[remainStep] -= stepNeedDay; // needDays = {7,3,9}
            }

            viewAll(needDays, step);
            System.out.println("step : " + step);
            // 완료한 작업까지의 갯수
            int workCount = 1;
            for (; step + workCount < progressesCount; workCount++) {
                System.out.println("needDays[step + workCount] : " + needDays[step + workCount]);
                if (needDays[step + workCount] > 0) {
                    break;
                }
            }

            System.out.println("workCount : " + workCount);

            // 완료한 작업 갯수 저장
            workCountStorage.add(workCount);

            // 작업 갯수만큼 step 증가
            step += workCount;

        }

        // int[] answer = {};

        int[] answer = convertInteger(workCountStorage);
        return answer;
    }

    private static void calcNeedDays(int[] progresses, int[] speeds) {
        for (int i = 0; i < progressesCount; i++) {
            double remainProgress = 100 - progresses[i];
            double fNeedDay = remainProgress / speeds[i];
            needDays[i] = (int) Math.ceil(fNeedDay);
        }
    }

    public static int[] convertInteger(ArrayList<Integer> integers) {
        int size = integers.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    private static void viewAll(int[] array, int startIdx) {
        System.out.print("viewAll:");

        int arrayCount = array.length;
        for (int i = startIdx; i < arrayCount; i++) {
            System.out.print(array[i] + ",");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
    }
}