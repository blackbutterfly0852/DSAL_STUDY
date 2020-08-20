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

        // 4) int[]
        int[] array_sort = {4,3,1,2};
        int[] tmp = Arrays.copyOfRange(array_sort, 1, 3); // {3,1}
        System.out.println(Arrays.toString(tmp));
        Arrays.sort(tmp); //{1,3}
        
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
        // 순열 : 순열(Permutation)은 서로 다른 n 개의 대상에서 r 개를 뽑아 일렬로 배열한 것 : nPr -> 6. Search - Permutation_Concept.java 및 Search_2 참조
        // 조합 : 조합(Combination)은 같은 n 개 중에 r 를 뽑되, 순서를 고려하지 않는다. : nCr
        
        // ex) list의 길이가 n 중에서 2개를 추출한다
        String[] sample = new String[10];
        //      순열 
        int p_length = (sample.length * (sample.length-1));
        //      조합
        int c_length = (sample.length * (sample.length-1))/2;
        
        System.out.println("3^^10 : " + Math.pow(3,10));

        // Java 특정 정렬 활용 : 5.Sort - Sort_2.java 참고
        // https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
        // Arrays.sort()와 Collections.sort()
        // -> Arrays.sort() : 일반적인 배열 
        // -> Collections.sort() : List Collection의 경우(내부적으로 Arrays.sort())

        // Comparable interface vs Comparator interface를 이용한 Java 객체를 정렬
        // -> Comparable : 정렬 수행 시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의하는 인터페이스 -> compareTo()
        // -> Comparator : 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스)들의 
        //                 기본 정렬 기준과 다르게 정렬 하고 싶을 때 사용하는 인터페이스 -> compare()

        // compareTo() 문자열 비교 : https://mine-it-record.tistory.com/133

       
        // Java 이진탐색 -> 6.Search - BinarySearch_Concept.java 참고
        int[] list = {1,2,3,4};
        Arrays.binarySearch(list, 3); // key값 존재시 idx 리턴, 없으면 -(삽입포인트+1) -> 음수값 리턴

        // Integer.parseInt() vs Integer.valueOf() 차이 -> https://m.blog.naver.com/sthwin/221000179980
        // parseInt() -> return 원시자료형인 int형
        // valueOf()  -> return wrapper 자료형인 Integer 클래스
          
        
       
        

   
        





    }

}