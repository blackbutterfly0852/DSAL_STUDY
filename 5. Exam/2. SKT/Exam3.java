public class Exam3 {
    static int bigCnt = 0;
    static int smallCnt = 0;
    static String ret = "";
    static int totalCnt = 0;

    public static String solution(int A, int B) {
        totalCnt = A + B;
        if (A > B) {
            return solution_2(A, B, "a", "b", "");
        } else {
            return solution_2(B, A, "b", "a", "");
        }
    };

    public static String solution_2(int bigInt, int smallInt, String big, String small, String flag) {
        if (ret.length() > totalCnt) {
            return "";
        }

        // if(flag.equals(big)) return big;
        // if(flag.equals(small)) return small;

        while (bigInt > 0 || smallInt > 0) {
            
            if (bigInt > 0 && bigCnt < 2) {
                bigCnt += 1;
                bigInt--;
                smallCnt = 0;
                ret += big;
            }
            if (smallInt > 0 && smallCnt < 2) {
                smallCnt += 1;
                smallInt--;
                bigCnt = 0;
                ret += small;
            }

        }

        return ret;

    }

    public static void main(String[] args) {
        int A = 4;
        int B = 1;
        System.out.println(solution(A, B));

    }

}
