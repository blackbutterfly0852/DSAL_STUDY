import java.util.*;

// 트리, 이진트리, 이진탐색트리, 완전이진트리.
// 힙(Heap) : 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리(Complete Binary Tree)
// 완전 이진 트리: 노드를 삽입할 때 최하단 왼쪽 노드부터 차례대로 삽입하는 트리
// 힙 사용 이유 :
// -> 배열에 데이터를 넣고, 최대값과 최소값을 찾으려면 O(n) 이 걸림
// -> 이에 반해, 힙에 데이터를 넣고, 최대값과 최소값을 찾으면,  𝑂(𝑙𝑜𝑔𝑛)  이 걸림
// -> 우선순위 큐와 같이 최대값 또는 최소값을 빠르게 찾아야 하는 자료구조 및 알고리즘 구현 등에 활용됨
// MaxHeap : 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 크거나 같다.
// MinHeap : 각 노드의 값은 해당 노드의 자식 노드가 가진 값보다 작거나 같다.
// 힙은 이진 탐색 트리의 조건인 자식 노드에서 작은 값은 왼쪽, 큰 값은 오른쪽이라는 조건은 없음 
// -> 힙의 왼쪽 및 오른쪽 자식 노드의 값은 오른쪽이 클 수도 있고, 왼쪽이 클 수도 있음
// 이진 탐색 트리는 탐색을 위한 구조, 힙은 최대/최소값 검색을 위한 구조 중 하나로 이해하면 됨
// 힙 구현
// -> 일반적으로 힙 구현시 배열 자료구조를 활용함, root 노드 인덱스 번호를 1로 지정
// -> 부모 노드 인덱스 번호 (parent node's index) = 자식 노드 인덱스 번호 (child node's index) // 2
// -> 왼쪽 자식 노드 인덱스 번호 (left child node's index) = 부모 노드 인덱스 번호 (parent node's index) * 2
// -> 오른쪽 자식 노드 인덱스 번호 (right child node's index) = 부모 노드 인덱스 번호 (parent node's index) * 2 + 1
public class Heap_Concept_1 {
    ArrayList<Integer> heap_array;
    
    // 1. 초기화
    // index 1부터 시작하기 위해 index 0은 null로 초기화
    public Heap_Concept_1(int init_data){
        heap_array = new ArrayList<Integer>();
        heap_array.add(null);
        heap_array.add(init_data);
    }

    // 2. insert
    public String insert(int value){
        String answer = "that value be added";
        // 2-1. 삽입된 데이터는 완전 이진 트리 구조에 맞추어, 최하단부 왼쪽 노드부터 채워짐
        heap_array.add(value);
        // 2-2. 삽입된 데이터의 값과 해당 부모 노드와 비교 후, 부모 노드보다 작을 때까지 SWAP
        int inserted_idx = heap_array.size() - 1;
        while(move_up(inserted_idx)){
            // 2-2-1. 부모 노드의 인덱스를 구한다.
            int parent_idx = inserted_idx / 2; 
            int insertedValueToParentValue = heap_array.get(inserted_idx);
            // 2-2-2. 삽입된 데이터의 노드와 부모 노드의 위치를 변경(SWAP)
            heap_array.set(inserted_idx ,heap_array.get(parent_idx));
            heap_array.set(parent_idx ,insertedValueToParentValue);
            inserted_idx = parent_idx;
        }
        return answer;
    }
    // 2-1. move_up 
    // 삽입된 노드의 값과 해당 부모 노드의 값을 비교 후 위로 SWAP
    public Boolean move_up(int inserted_idx){
        Boolean answer = true ;
        if (inserted_idx <= 1){
            return false;
        }
        // 2-1-1. inserted_idx의 값이 parent_idx의 값보다 작은 경우 -> false;
        // 부모노드 = 자식노드 // 2 , 왼쪽 자식 노드 = 부모노드 * 2 , 오른쪽 자식노드 = 부모노드 * 2 + 1
        int parent_idx = inserted_idx / 2;
        if(heap_array.get(inserted_idx) < heap_array.get(parent_idx)){
            return false;
        }
        return answer;       
    }

    // 3. delete
    // 보통 삭제는 최상단 노드 (root 노드)를 삭제하는 것이 일반적임
    // -> 힙의 용도는 최대값 또는 최소값을 root 노드에 놓아서, 최대값과 최소값을 바로 꺼내 쓸 수 있도록 하는 것임
    public String delete(){
        String not_found_answer = "that value not be found";
        String delete_success = "that value be successfully deleted";
        // 3-1. heap_array의 크기가 1인경우 (null값만 존재) -> 삭제할 데이터 미존재
        if (heap_array.size()<=1){
            return not_found_answer;
        }
        // 3-2. 루트노드의 데이터 추출 후, 마지막에 삽입된 노드의 데이터를 루트 노드와 변경 후, 마지막 노드 제거
        int answer = heap_array.get(1);
        heap_array.set(1,heap_array.get(heap_array.size()-1));
        heap_array.remove(heap_array.size()-1);
        int deleted_idx = 1;
        System.out.println("추출된 데이터 : " + answer);
        System.out.print("마지막 데이터 루트노드로 이동 : ");
        for(Integer a : heap_array){
            
            System.out.print(a + " ");
        }
        System.out.println(" ");

        // 3-3. delete_idx와 자식노드 비교 후 아래로 SWAP
        while (move_down(deleted_idx)){
           
            int left_idx = deleted_idx * 2;
            int right_idx = deleted_idx * 2 + 1;
             // 3-3-1. 왼쪽 자식 노드만 존재하는 경우 및 왼쪽 자식노드와 SWAP
            if (right_idx >= heap_array.size()){
                System.out.println("3-3-1. 왼쪽 자식 노드만 존재하는 경우 및 왼쪽 자식노드와 SWAP");
                int deletedValueToChildValue = heap_array.get(deleted_idx);
                heap_array.set(deleted_idx, heap_array.get(left_idx));
                heap_array.set(left_idx, deletedValueToChildValue);
                deleted_idx = left_idx;
                
            // 3-3-2. 양쪽 모두 자식 노드 존재.    
            }else{
                System.out.println("3-3-2. 양쪽 모두 자식 노드 존재.");
                // 3-3-2-1. 왼쪽 자식 노드와 SWAP
                if (heap_array.get(left_idx) > heap_array.get(right_idx)){
                    System.out.println("3-3-2-1. 왼쪽 자식 노드와 SWAP");
                    int deletedValueToChildValue = heap_array.get(deleted_idx);
                    heap_array.set(deleted_idx, heap_array.get(left_idx));
                    heap_array.set(left_idx, deletedValueToChildValue);
                    deleted_idx = left_idx;
               
                // 3-3-2-2. 오른쪽 자식 노드와 SWAP    
                }else{
                    System.out.println("3-3-2-2. 오른쪽 자식 노드와 SWAP");
                    int deletedValueToChildValue = heap_array.get(deleted_idx);
                    heap_array.set(deleted_idx, heap_array.get(right_idx));
                    heap_array.set(right_idx,deletedValueToChildValue);
                    deleted_idx = right_idx;
                }

            }


        }
       
        return delete_success;
    }
    // 3-1. move_down
    // 루트노드의 값과 자식노드의 값 비교
    public Boolean move_down(int deleted_idx){
        Boolean answer = true;
        int left_idx = deleted_idx * 2;
        int right_idx = deleted_idx * 2 + 1;
        // 3-1-1. 왼쪽 자식 노드도 존재 하지 않은 경우
        if(left_idx >= heap_array.size()){
           return false;

        // 3-1-2. 오른쪽 자식 노드가 존재 하지 않은 경우(왼쪽만 존재) 
        }else if(right_idx >= heap_array.size()){
            // 3-1-2-1. delete_idx의 값이 왼쪽 자식 노드의 값보다 작은 경우 -> 아래로 SWAP 대상 -> True; 
            if(heap_array.get(deleted_idx) < heap_array.get(left_idx)){
                return true;
            }else{
                return false;
            }

        // 3-3-3. 양쪽 자식 노드 존재    
        }else{
            // 3-3-3-1. 왼쪽 자식 노드가 오른쪽 자식 노드 보다 큰 경우
            if(heap_array.get(left_idx) > heap_array.get(right_idx)){
                //3-3-3-1-1. delete_idx의 값이 왼쪽 자식 노드의 값보다 작은 경우 -> 아래로 SWAP 대상 -> True; 
                if(heap_array.get(deleted_idx) < heap_array.get(left_idx)){
                    return true;
                }else{
                    return false;
                }

            // 3-3-3-2. 오른쪽 자식 노드가 왼쪽 자식 노드 보다 큰 경우    
            }else{
                 //3-3-3-2-1. delete_idx의 값이 오른쪽 자식 노드의 값보다 작은 경우 -> 아래로 SWAP 대상 -> True; 
                 if(heap_array.get(deleted_idx) < heap_array.get(right_idx)){
                    return true;
                }else{
                    return false;
                }

            }
        }
    }
    public static void main(String[] args) {
        Heap_Concept_1 heap = new Heap_Concept_1(15);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
        }
        System.out.println(" ");

        heap.insert(10);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
        }
        System.out.println(" ");

        heap.insert(8);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
        }
        System.out.println(" ");

        heap.insert(5);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
        }
        System.out.println(" ");
        
        heap.insert(4);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
        }
        System.out.println(" ");

        heap.insert(20);
        for(Integer a : heap.heap_array){
            System.out.print(a + " ");
            
        }
        System.out.println(" ");
        System.out.println("-----------------");

        for(int i = 0 ; i<heap.heap_array.size(); i++){
            System.out.println(heap.delete());
            System.out.print("재정렬된 데이터 : ");
            for(Integer a : heap.heap_array){
                System.out.print(a + " ");
            }
            System.out.println(" ");
            System.out.println("-----------------");

        }
        
    }
    
}