import java.util.*;

public class Practice {

    static class Node{
        int number;

        public Node(int number){
            this.number = number;
        }
    }

    // 클래스 내부에서 자체 정렬.
    static class PointComparable implements Comparable<PointComparable> {
        int x, y;

        public PointComparable(int x, int y){
            this.x = x;
            this.y = y;
        }
    
        @Override
        public int compareTo(PointComparable p) {
            if(this.x > p.x) {
                return 1; // x에 대해서는 오름차순
            }
            else if(this.x == p.x) {
                if(this.y < p.y) { // y에 대해서는 내림차순
                    return 1;
                }
            }
            return -1;
        }
    }

    // PointComparator : 정렬의 기준만 제시 하는 클래스
    // 즉, PointComparable을 제시된 기준으로 정렬하겠다.
    static class PointComparator implements Comparator<PointComparable> {
       
        @Override
        public int compare(Practice.PointComparable current, Practice.PointComparable last) {
            if(current.x > last.x){
                return 1;
            }else{
                return -1;
            }
            
        }

      
    }

    // https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
    // Java 객체 사용자 정렬 : Comparable, Comparator
    // Arrays.sort(배열) 
    // * Ojbect Array : TimSort(Merge Sort + Insertion Sort)를 사용
    // * Class Array : Dual Pivot QuickSort(Quick Sort + Insertion Sort)
    // * Primitive Array
    // Collections.sort(컬렉션) : 내부적으로 Arrays.sort() 사용
    
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            // 기본적으로 현재 들어올 숫자는 맨 앞에 들어오면서 이미 들어온 숫자와 비교하면서 정렬한다.
            // 현재 들어올 숫자가 기존에 있는 숫자보다 크면 자리 변경 -> 오름차순
            // 현재 들어올 숫자가 기존에 있는 숫자보다 작으면 자리 변경 -> 내림차순
            @Override
            public int compare(Practice.Node current, Practice.Node last) {
                System.out.println("current : " +  current.number + " last : " + last.number);
                if(current.number > last.number){
                    return 1; // 양수만 자리 변경
                }else{
                    return -1;
                }
                
            }
        });

        // 오름차순_BASIC
        Node node1a = new Node(1); // 1
        Node node2a = new Node(2); // 2, 1 -> 2 vs 1 -> 1, 2
        Node node3a = new Node(3); // 3, 1, 2 -> 3 vs 1 -> 1, 3, 2 -> 3 vs 2 -> 1, 2, 3
        // 내림차순_BASIC
        Node node1d = new Node(1); // 1
        Node node2d = new Node(2); // 2, 1 -> 2 vs 1 -> 2, 1 
        Node node3d = new Node(3); // 3, 2, 1 -> 3 vs 2 -> 3, 2, 1 -> 2 vs 1 -> 3, 2, 1
        // 오름차순_AD
        Node node2ad = new Node(2); // 2
        Node node3ad = new Node(3); // 3, 2 -> 3 vs 2 -> 2, 3
        Node node1ad = new Node(1); // 1, 2, 3 -> 1 vs 2 -> 1, 2, 3 -> 2 vs 3 -> 1, 2, 3
        // 내림차순_DD
        Node node2dd = new Node(2); // 2
        Node node3dd = new Node(3); // 3, 2 -> 3 vs 2 -> 3, 2
        Node node1dd = new Node(1); // 1, 3, 2 -> 1 vs 3 -> 3, 1, 2 -> 1 vs 2 -> 3, 2, 1
        pq.add(node2ad);
        pq.add(node3ad);
        pq.add(node1ad);
        // pq.add(node2dd);
        // pq.add(node3dd);
        // pq.add(node1dd);
 

        // Comparable - 클래스 내에서 정렬 하려는 경우
        List<PointComparable> Comparable = new ArrayList<>();
        Comparable.add(new PointComparable(2, 1));
        Comparable.add(new PointComparable(1, 1));

        Collections.sort(Comparable);
        for(PointComparable p : Comparable){
            System.out.println("Comparable : " + p.x);
        }

        // Comparator - 정렬하고자 하는 클래스를 별도의 정렬 클래스로 정렬하는 경우
        List<PointComparable> Comparable_2 = new ArrayList<>();
        Comparable_2.add(new PointComparable(2, 1));
        Comparable_2.add(new PointComparable(1, 1));
        // 오름차순
        Collections.sort(Comparable_2, new PointComparator());
        for(PointComparable p : Comparable_2){
            System.out.println("Comparator_오름 : " + p.x);
        }

        //내림차순
        Comparator<PointComparable> cp = new Comparator<Practice.PointComparable>(){
            @Override
            public int compare(Practice.PointComparable current, Practice.PointComparable last) {
              
                if(current.x < last.x){
                    return 1;
                }else{
                    return -1;
                }
                
            }
        };
        Collections.sort(Comparable_2,cp);

        for(PointComparable p : Comparable_2){
            System.out.println("Comparator_내림 : " + p.x);
        }

    }

}
