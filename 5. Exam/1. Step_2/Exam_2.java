import java.util.*;
import java.text.*;

public class Exam_2 {
    public static int solution(int[] people, int limit) {

        boolean[] visited = new boolean[people.length];
        int answer = 0;
        Arrays.sort(people);
        HashSet<ArrayList<Integer>> list = new HashSet<>();
        int stand = 0;
        for (int i = stand + 1; i < people.length; i++) {

        }

        return list.size();
    }

    public static void main(String[] args) {
        // int[] people = {70,50,80,50};
        // int[] people = { 70, 50, 80, 50, 40, 60 };
        // int limit = 100;

        // System.out.println(solution(people, limit));

        String time = "13:22";
        String today = null;

        Date date = new Date();

        System.out.println(date);

        // 포맷변경 ( 년월일 시분초)
        SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        // Java 시간 더하기

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        today = sdformat.format(cal.getTime());
        System.out.println("지금 : " + today);

        // 3분 더하기
        cal.add(Calendar.MINUTE, 3);

        today = sdformat.format(cal.getTime());
        System.out.println("3분전 : " + today);

        cal.setTime(date);
        // 1시간 전
        cal.add(Calendar.HOUR, -1);

        today = sdformat.format(cal.getTime());
        System.out.println("1시간 전 : " + today);

        cal.setTime(date);
        // 하루 전
        cal.add(Calendar.DATE, -1);

        today = sdformat.format(cal.getTime());
        System.out.println("1일 전 : " + today);

        //SimpleDateFormat input_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 입력포멧
        SimpleDateFormat input_format = new SimpleDateFormat("HH:mm");
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss"); // 년월일시분초 14자리 포멧

        // 일시 문자열을 읽고 출력하는 실습
        try {
            String str_source = "13:59"; // 입력포멧 문자열
            Date date_parsed = input_format.parse(str_source); // 문자열을 파싱해 Date형으로 저장한다
            cal.setTime(date_parsed);
            cal.add(Calendar.MINUTE, 30);
            String add = input_format.format(cal.getTime());
            System.out.println(add);
            //System.out.println(input_format.format(date_parsed));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
