// LinkedList(연결리스트) : 
// 배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조, 미리 데이터 크기를 지정하는 단점 -> 링크드 리스트로 보완
// 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조
// 노드(Node): 데이터 저장 단위 (데이터값, 포인터) 로 구성
// 포인터(pointer): 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간
// 장점
// -> 미리 데이터 공간을 미리 할당하지 않아도 됨
// -> 배열은 미리 데이터 공간을 할당 해야 함
// 단점
// -> 연결을 위한 별도 데이터 공간이 필요하므로, 저장공간 효율이 높지 않음
// -> 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림
// -> 중간 데이터 삭제시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요

// 더블 링크드 리스트(Doubly linked list) 기본 구조
// 장점: 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능

// 아래는 더블 링크드 리스트 구현
import java.util.*;

public class LinkedList_Concept_1 {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    class NodeMgt {

        Node head;
        Node tail;

        public NodeMgt(int data) {
            head = new Node(data);
            tail = head;
        }

        // desc : 전체 노드 표출
        public void desc() {
            Node node = head;
            while (node.next != null) {
                System.out.print(node.data + " ");
                node = node.next;

            }
            System.out.print(node.data);

        }

        // insert_1 : 기본 데이터 추가
        public String insert_1(int data) {
            String answer = "that value be added";
            Node node = head;
            // 1. 마지막 노드 찾기
            while (node.next != null) {
                node = node.next;
            }
            // 2. 노드 생성 및 연결
            Node new_node = new Node(data);
            node.next = new_node;
            new_node.prev = node;
            tail = new_node;
            return answer;
        }

        // insert_2 : 특정 데이터 앞에 추가
        public String insert_2(int data, int search_data) {
            String answer = "that value be added";
            String no_found_data = "search_data no found";
            Node node = head;
            // 1. search_data 찾기
            while (node.data != search_data && node.next != null) {
                node = node.next;

            }
            // 2. search_data가 없는 경우
            if (node.data != search_data) {
                return no_found_data;
            // 3. search_data가 있는 경우
            } else {
                Node new_node = new Node(data);
                // 3-1. serach_data의 노드가 첫 노드가 아닌 경우
                if (node.prev != null) {
                    Node prev_node = node.prev;
                    prev_node.next = new_node;
                    new_node.prev = prev_node;
                    new_node.next = node;
                    node.prev = new_node;

                // 3-2. serach_data의 노드가 첫 노드인 경우
                } else {

                    node.prev = new_node;
                    new_node.next = node;
                    head = new_node;
                }

            }

            return answer;
        }

        // insert_3 : 특정 데이터 뒤에 추가
        public String insert_3(int data, int search_data) {
            String answer = "that value be added";
            String no_found_data = "search_data no found";
            Node node = head;
            // 1. search_data 찾기
            while (node.data != search_data && node.next != null) {
                node = node.next;

            }
            // 2. search_data가 없는 경우
            if (node.data != search_data) {
                return no_found_data;
            // 3. search_data가 있는 경우
            } else {
                Node new_node = new Node(data);
                // 3-1. search_data의 노드가 마지막 노드가 이닌경우
                if (node.next != null) {
                    Node next_node = node.next;
                    node.next = new_node;
                    new_node.prev = node;
                    new_node.next = next_node;
                    next_node.prev = new_node;
                    
                // 3-2. search_data의 노드가 마지막 노드인 경우
                } else {
                    node.next = new_node;
                    new_node.prev = node;
                    tail = new_node;
                }

            }

            return answer;

        }

        // serach_1 : 특정 데이터 앞에서 찾기
        public String search_1(int search_data) {
            String found_data = "search_data be found";
            String no_found_data = "search_data no found";
            Node node = head;
            while (node.data != search_data && node.next != null) {
                node = node.next;
            }
            if (node.data == search_data) {
                return found_data;
            } else {
                return no_found_data;
            }
        }

        // serach_2 : 특정 데이터 뒤에서 찾기
        public String search_2(int search_data) {
            String found_data = "search_data be found";
            String no_found_data = "search_data no found";
            Node node = tail;

            while (node.data != search_data && node.prev != null) {
                node = node.prev;
            }

            if (node.data == search_data) {
                return found_data;
            } else {
                return no_found_data;
            }

        }

        // delete : 삭제
        public String delete(int search_data) {
            String deleted_data = "search_data be deleted";
            String no_found_data = "search_data no found";
            Node node = head;
            // 1. 삭제 노드 찾기
            while (node.data != search_data && node.next != null) {
                node = node.next;
            }
            // 2. 삭제 노드가 없는 경우

            if (node.data != search_data) {
                return no_found_data;
            } else {

                // 2-1. 삭제 노드가 head
                if (node.prev == null) {
                    head = node.next;

                // 2-2. 삭제 노드가 tail
                } else if (node.next == null) {
                    Node prev_node = node.prev;
                    prev_node.next = null;
                    tail = prev_node;
                  
                // 2-3. 기타
                } else{
                    Node prev_node = node.prev;
                    Node next_node = node.next;
                    prev_node.next = next_node;
                    next_node.prev = prev_node;
                }

            }

            return deleted_data;

        }

    }

    public static void main(String[] args) {

        LinkedList_Concept_1 ll = new LinkedList_Concept_1();
        NodeMgt nodeMgt = ll.new NodeMgt(10);
        Random rand = new Random();
        // System.out.print("value : ");
        nodeMgt.insert_1(1);
        nodeMgt.insert_1(2);
        nodeMgt.insert_1(3);
        System.out.println("");
        nodeMgt.desc();
        System.out.println("");

        System.out.println(nodeMgt.insert_2(9, 3));
        nodeMgt.desc();
        System.out.println("");
        System.out.println(nodeMgt.insert_2(500, 10));
        nodeMgt.desc();
        System.out.println("");
        System.out.println(nodeMgt.insert_3(20, 3));
        nodeMgt.desc();
        System.out.println("");

        System.out.println(nodeMgt.search_1(9));
        System.out.println(nodeMgt.search_2(20));


        System.out.println(nodeMgt.delete(500));
        nodeMgt.desc();
        System.out.println("");
        System.out.println(nodeMgt.delete(20));
        nodeMgt.desc();
        System.out.println("");

        System.out.println(nodeMgt.delete(9));
        nodeMgt.desc();
        System.out.println("");

    }

}