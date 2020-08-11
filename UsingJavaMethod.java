import java.util.*;
import java.lang.Math;
public class UsingJavaMethod {

    public static void main(String[] args) {
        // 1. Java_DataStructure
        // 1) Queue 사용법
        Queue<String> que = new LinkedList<String>();// 주로 사용됨
        que.offer("a");
        que.offer("b");
        que.offer("c");
        System.out.print(que); // [a,b,c] -> que 출력
        System.out.print(que.element()); // a -> 맨 앞 값 가져오기
        System.out.print(que.peek()); // a -> 맨 앞 값 가져오기(element()와 동일)
        System.out.print(que.poll()); // a -> 맨 앞 값 가져오고 삭제
        System.out.print(que); // [b,c] -> que 출력
        // int[]의 index 1 기준으로 오름차순 정렬
        Queue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[1] - pq2[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대값(내림차순)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소값(오름차순)
        
        
        // 2) ArrayList
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));// 생성시
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        int [] array = new int[20]; // 크기 20의 0으로 초기화
        System.out.println(Arrays.toString(array));

        int[][] jobs = new int[10][];
        // int[]의 index 0을 기준으로 오름차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<int[]> jobsLiSt = new ArrayList<int[]>();
        for(int[] job : jobs){
            jobList.add(job);
        }
        //  ArrayList<int[]> int[]의 index 0을 기준으로 오름차순
        Collections.sort(jobList,(j1,j2) -> j1[0] - j2[0]);

        // 3) Map
        Map<Integer, Object> tmp_list_ = new HashMap<Integer, Object>(); // ojbect 내 Map, ArrayList ....
        Map<String, Integer> tmp_list = new HashMap<String, Integer>(); // ojbect 내 Map, ArrayList ....
                
        List<String> tmp_keySetList = new ArrayList<>(tmp_list.keySet());
        // tmp_list의 value 값 기준으로 오름차순한 key값 정렬.
        Collections.sort(tmp_keySetList, (o1, o2) -> (tmp_list.get(o1).compareTo(tmp_list.get(o2))));
        // tmp_list의 value 값 기준으로 내림차순한 key값 정렬.
        Collections.sort(tmp_keySetList, (o1, o2) -> (tmp_list.get(o2).compareTo(tmp_list.get(o1))));
        
        // *) 복합자료구조
        LinkedList<String>[]  hash_table_1 = new LinkedList[10]; // {{linkedList}, {linkedList}, {linkedList}, {linkedList}......}
        Map<String,String>[] hash_table_2 = new HashMap[10]; // {{Map}, {Map}, {Map}, {Map}......}
        ArrayList<Integer> g_index = new ArrayList<Integer>(10); // {Integer,Integer,Integer.....}

        // 2. 연산
        // 1) ceil : 해당 수보다 크거나 같은 정수
        Math.ceil(3.3); // 4
        Math.ceil(-9.4); // -9

        // 2) isEmpty() vs == null
        // isEmpty() : 값 유뮤 체크 vs == null : 인스턴스 생성여부 체크
        String line = "";
        String line2 = null;

        if (line.isEmpty()){} // True
        if (line == null){} // False

        //if (line2.isEmpty()){} // NullPointException
        if (line2 == null){} // True

        // 3) 순열/조합 
        // 순열 : 순열(Permutation)은 서로 다른 n 개의 대상에서 r 개를 뽑아 일렬로 배열한 것 : nPr
        // 조합 : 조합(Combination)은 같은 n 개 중에 r 를 뽑되, 순서를 고려하지 않는다. : nCr
        
        // ex) list의 길이가 n 중에서 2개를 추출한다
        String[] sample = new String[10];
        //      순열 
        int p_length = (sample.length * (sample.length-1));
        //      조합
        int c_length = (sample.length * (sample.length-1))/2;
        
        System.out.println("3^^10 : " + Math.pow(3,10));

        // 
          
        
       
        

   
        





    }

}