import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class Solution_7 {



    public static boolean checkDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd"); //검증할 날짜 포맷 설정
            dateFormatParser.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
            dateFormatParser.parse(checkDate); //대상 값 포맷에 적용되는지 확인
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(checkDate("18-1-31"));
        String aString = "11"
        ;

        Set<String> month = new HashSet<>();
        month.add("20");

        month.contains(aString);

        String a = "1990-01-02";

        String[] b = a.split("-");

        System.out.println(b[0]);
    }
    
}
