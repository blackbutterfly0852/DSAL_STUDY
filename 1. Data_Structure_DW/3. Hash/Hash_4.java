import java.util.*;

// Hash
// 4. 베스트 앨범
public class Hash_4 {

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> tmp_answer = new ArrayList<Integer>();

        // 1. Genre 기준으로 저장 ex) {{c : 1450}, {p : 3100} , {B : 1100}}
        Map<String, Integer> g_list = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
            if (!g_list.containsKey(genres[i])) {
                g_list.put(genres[i], plays[i]);
            } else {
                g_list.put(genres[i], g_list.get(genres[i]) + plays[i]);
            }
        }

        // 2. 1의 value 값 기준으로 내림차순한 key값 정렬.ex) keySetList = {P , C , B}
        List<String> keySetList = new ArrayList<>(g_list.keySet());
        Collections.sort(keySetList, (o1, o2) -> (g_list.get(o2).compareTo(g_list.get(o1))));

        // System.out.println("-----------------------------------------------");
        // for (String key : keySetList) {
        // System.out.println("key : " + key + " || value : " + g_list.get(key));
        // }

        // 3. 2 기준으로 1번 탐색하여 각 Genre 당 인덱스 번호 저장 ex) g_index = {{1,5} , {0,2,4} , {3,6}}
        // -> keySetList 순
        ArrayList<ArrayList<Integer>> g_index = new ArrayList<ArrayList<Integer>>(keySetList.size());
        for (int i = 0; i < keySetList.size(); i++) {
            ArrayList<Integer> g_index_2 = new ArrayList<Integer>();
            for (int j = 0; j < genres.length; j++) {
                if (keySetList.get(i).equals(genres[j])) {
                    // System.out.println("key : " + keySetList.get(i) + " || value : " + j);
                    g_index_2.add(j);
                }
            }
            g_index.add(g_index_2);
        }

        // 4. g_index 기준으로 순차적으로 추출 (제약조건 : 최대 2개 / 장르 내 가장 재생 多 순/ 재생이 같다면 고유번호가 낮은 순 )
        for (ArrayList<Integer> a : g_index) {
            Map<Integer, Integer> tmp_list = new HashMap<Integer, Integer>();
            for (Integer b : a) {
                tmp_list.put(b, plays[b]);
            }
            List<Integer> tmp_keySetList = new ArrayList<>(tmp_list.keySet());
            Collections.sort(tmp_keySetList, (o1, o2) -> (tmp_list.get(o2).compareTo(tmp_list.get(o1))));

            int count = 0;
            for (Integer c : tmp_keySetList) {
                if (count < 2) {
                    tmp_answer.add(c);
                    count += 1;
                }
            }
        }

        // 5. 배열 복사
        answer = new int[tmp_answer.size()];
        int idx = 0;
        for (Integer a : tmp_answer) {
            answer[idx++] = a;
        }
        // System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        String[] a = { "classic", "pop", "classic", "Balade", "classic", "pop", "Balade" };
        String[] a_1 = { "classic", "pop", "classic", "classic", "pop" };
        int[] b = { 500, 600, 150, 700, 800, 2500, 400 };
        int[] b_1 = { 500, 600, 500, 800, 2500 };
        int[] b_2 = { 150, 600, 150, 800, 2500 };
        solution(a_1, b_1);
        // System.out.println(solution(a, b));
    }

}