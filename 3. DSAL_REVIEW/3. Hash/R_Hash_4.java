import java.util.*;

public class R_Hash_4 {

    // 참고
    // 객체 지향 고려
    // PriorityQueue -> Pratice.java 참고
    static class GenreNode {
        String genreName; // 장르 이름
        int totalCount; // 해당 장르의 전체 재생 횟수

        PriorityQueue<PerGenreNode> pq = new PriorityQueue(new Comparator<PerGenreNode>() { // 해당 장르의 전체 재생 횟수
            public int compare(PerGenreNode current, PerGenreNode last) {
                if (current.count < last.count) return 1;
                else if (current.count == last.count) {
                    if(current.uniqueNumber > last.uniqueNumber) return 1;
                    else {return -1;}
                } else {
                    return -1;
                }

            };
        });

        public GenreNode(String genreName, int totalCount) {
            this.genreName = genreName;
            this.totalCount = totalCount;
        }

    }
    static class PerGenreNode {
        int uniqueNumber;
        int count;

        public PerGenreNode(int uniqueNumber, int count) {
            this.uniqueNumber = uniqueNumber;
            this.count = count;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        // 1. 장르별 합산
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
            if (!list.containsKey(genres[i])) {
                list.put(genres[i], plays[i]);
            } else {
                list.put(genres[i], list.get(genres[i]) + plays[i]);
            }
        }

        // 2. 장르별 합산 순으로 객체 생성 후 PriorityQueue 대입
        PriorityQueue<GenreNode> pq = new PriorityQueue<>(new Comparator<GenreNode>() {
            @Override
            public int compare(GenreNode current, GenreNode last) {
                if(current.totalCount < last.totalCount){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for (String key : list.keySet()) {
            GenreNode gn = new GenreNode(key, list.get(key));
            pq.add(gn);
        }

        // 3. 장르별 합산 순으로 추출 후 해당 장르의 각 재생횟수 구한 후, 재생 횟수를 다시 내림차순 정렬한다.
        while (!pq.isEmpty()) {
            GenreNode gn = pq.poll();
            for (int i = 0; i < genres.length; i++) {
                if (gn.genreName.equals(genres[i])) {
                    PerGenreNode pgn = new PerGenreNode(i, plays[i]);
                    gn.pq.add(pgn);
                }
            }
            int count = 0;
            while (!gn.pq.isEmpty()) {
                if (count == 2){
                    break;
                }
                int gc = gn.pq.poll().uniqueNumber;
                count++;
                answer.add(gc);
            }
        }

        int[] new_answer = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            new_answer[i] = answer.get(i);
        }
        return new_answer;
    }

    public static void main(String[] args) {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        solution(genres, plays);

    }

}
