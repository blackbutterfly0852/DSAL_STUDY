// 트리: Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
// Node: 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
// Root Node: 트리 맨 위에 있는 노드
// Level: 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
// Parent Node: 어떤 노드의 다음 레벨에 연결된 노드
// Child Node: 어떤 노드의 상위 레벨에 연결된 노드
// Leaf Node (Terminal Node): Child Node가 하나도 없는 노드
// Sibling (Brother Node): 동일한 Parent Node를 가진 노드
// Depth: 트리에서 Node가 가질 수 있는 최대 Level -> 0 depth에서 시작
// 이진 트리: 노드의 최대 Branch가 2인 트리
// 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
// -> 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음!
// -> 데이터 삭제는 데이터 추가, 탐색보다 상대적으로 복잡함.
// -> 이진탐색트리가 균형잡혀 있으면, 탐색시간은 𝑂(𝑙𝑜𝑔𝑛) // but, 한쪽으로 몰려있을 경우, 𝑂(𝑛)

class Tree_Concept1 {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    class NodeMgt {

        public Node head;

        public NodeMgt(Node head) {
            this.head = head;
        }

        // Insert
        public void insert(int value) {
            Node current_node = this.head;
            while (true) {
                // 1. value 값이 current_node의 value보다 작은 경우(왼쪽)
                if (value < current_node.value) {
                    // 1-1. current_node의 왼쪽 노드가 있는 경우
                    if (current_node.left != null) {
                        current_node = current_node.left;
                    // 1-2. current_node의 왼쪽 노드가 없는 경우
                    } else {
                        current_node.left = new Node(value);
                        break;
                    }
                // 2. value 값이 current_node의 value보다 큰 경우 (오른쪽)
                } else {
                    // 2-1. current_node의 오른쪽 노드가 있는 경우
                    if (current_node.right != null) {
                        current_node = current_node.right;
                    // 2-2. current_node의 오른쪽 노드가 없는 경우
                    } else {
                        current_node.right = new Node(value);
                        break;
                    }
                }
            }
        }

        // Search
        public String search(int search_value) {
            Node current_node = this.head;
            String found_answer = "that value be found";
            String not_found_answer = "that value not be found";

            int depth = -1;
            while (true) {
                // System.out.println("search_value : " + search_value);
                // System.out.println("current_node.value : " + current_node.value);
                depth += 1;
                // 1. search_value가 current_node.data인 경우
                if (search_value == current_node.value) {
                    System.out.print("depth : " + depth + " ");
                    return found_answer;
                // 2. search_value가 current_node.data보다 작은 경우(왼쪽)
                } else if (search_value < current_node.value) {
                    // 2-1. current_node.left에 node가 존재하는 경우
                    if (current_node.left != null) {
                        current_node = current_node.left;
                    // 2-2. current_node.left에 node가 존재하지 않은 경우
                    } else {
                        System.out.print("depth : " + depth + " ");
                        return not_found_answer;
                    }
                // 3. search_value가 current_node.data보다 큰 경우(오른쪽)
                } else if (search_value > current_node.value) {
                    // 3-1. current_node.right의 node가 존재하는 경우
                    if (current_node.right != null) {
                        current_node = current_node.right;
                    // 3-2. current_node.right의 node가 미존재하는 경우
                    } else {
                        System.out.print("depth : " + depth + " ");
                        return not_found_answer;
                    }
                }
            }

        }

        // Delete -> 상대적으로 복잡
        // case 1 : leaf_node 삭제 -> 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.
        // case 2 : child_node가 1개 일 경우 -> 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를
        // 가리키도록 한다.
        // case 3 : child_node가 2개 일 경우 -> 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent
        // Node가 가리키도록 한다.
        public String delete(int delete_value) {
            // 1. 데이터 탐색
            Boolean searched = false;
            Node current_node = this.head; // 삭제할 노드
            Node parent_node = this.head; // 삭제할 노드의 부모노드

            String not_found_answer = "that value not be found";
            String delete_success = "that value be successfully deleted";

            while (current_node != null) {
                // 1_1. delete_value가 current_node.data인 경우
                if (delete_value == current_node.value) {
                    searched = true;
                    break;
                // 1_2. delete_value가 current_node.data보다 작은 경우(왼쪽)
                } else if (delete_value < current_node.value) {
                    parent_node = current_node;
                    current_node = current_node.left;

                // 1_3. delete_value가 current_node.data보다 큰 경우(오른쪽)
                } else if (delete_value > current_node.value) {
                    parent_node = current_node;
                    current_node = current_node.right;
                }
            }
            if (!searched) {
                return not_found_answer;
            }
            // 2. leaf_node 삭제 -> 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.
            if (current_node.left == null && current_node.right == null) {

                // 2-1. current_node.value(삭제할노드)가 parent_node.value보다 작은 경우
                if (current_node.value < parent_node.value) {
                    parent_node.left = null;
                    System.out.print("left_node 삭제 : parent_node의 왼쪽 : ");
                    return delete_success;

                // 2-2. current_node.value(삭제할노드)가 parent_node.value보다 큰 경우
                } else {
                    parent_node.right = null;
                    System.out.print("left_node 삭제 : parent_node의 오른쪽 : ");
                    return delete_success;
                }

            }

            // 3. child_node가 1개 일 경우 -> 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를 가리키도록
            // 한다.

            // 3-1. child_node가 current_node의 왼쪽에 존재하는 경우
            if (current_node.left != null && current_node.right == null) {
                // 3-1-1. current_node가 parent_node 왼쪽에 존재하는 경우
                if (current_node.value < parent_node.value) {
                    parent_node.left = current_node.left;
                    current_node = null;
                    System.out.print("child_node 왼쪽 1개인 경우 삭제 : current_node는 parent_node의 왼쪽 : ");
                    return delete_success;

                // 3-1-2. current_node가 parent_node 오른쪽에 존재하는 경우
                } else {
                    parent_node.right = current_node.left;
                    current_node = null;
                    System.out.print("child_node 왼쪽 1개인 경우 삭제 : current_node는 parent_node의 오른쪽 : ");
                    return delete_success;

                }
            // 3-2. child_node가 current_node의 오른쪽에 존재하는 경우
            } else if (current_node.left == null && current_node.right != null) {
                // 3-2-1. current_node가 parent_node 왼쪽에 존재하는 경우
                if (current_node.value < parent_node.value) {
                    parent_node.left = current_node.right;
                    current_node = null;
                    System.out.print("child_node 오른쪽 1개인 경우 삭제 : current_node는 parent_node의 왼쪽 : ");
                    return delete_success;

                // 3-2-2. current_node가 parent_node 오른쪽에 존재하는 경우
                } else {
                    parent_node.right = current_node.right;
                    current_node = null;
                    System.out.print("child_node 오른쪽 1개인 경우 삭제 : current_node는 parent_node의 오른쪽 : ");
                    return delete_success;

                }

            }

            // 4. child_node가 2개 일 경우 -> 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가
            // 가리키도록 한다.

            if (current_node.left != null && current_node.right != null) {
                // 4-1. current_node가 parent_node 왼쪽에 존재하는 경우
                if (current_node.value < parent_node.value) {
                    Node change_node_parent = current_node.right;
                    Node change_node = current_node.right;
                    // 4-1-1. change_node 찾기
                    while (change_node.left != null) {
                        change_node_parent = change_node;
                        change_node = change_node.left;
                    }

                    // 4-1-2. change_node의 오른쪽 node가 존재하는 경우
                    if (change_node.right != null) {
                        System.out.print("change_node의 오른쪽 node 존재 : ");
                        // 4-1-2-1. 예외 처리 (change_node와 change_node_parent와 동일한 경우)
                        if (change_node != change_node_parent) {
                            change_node_parent.left = change_node.right;
                        }

                    // 4-1-3. change_node의 오른쪽 node가 존재하지 않은 경우
                    } else {
                        System.out.print("change_node의 오른쪽 node 미존재 : ");
                        change_node_parent.left = null;
                    }
                    // 4-1-4. switching
                    parent_node.left = change_node;
                    change_node.left = current_node.left;
                    // 4-1-4-1. 예외 처리 (change_node와 change_node_parent와 동일한 경우)
                    if (change_node != change_node_parent) {
                        change_node.right = current_node.right;
                    }
                    System.out.print("child_node 2개인 경우 삭제 : current_node는 parent_node의 왼쪽 : ");
                    return delete_success;

                // 4-2. current_node가 parent_node 오른쪽에 존재하는 경우
                } else {
                    Node change_node_parent = current_node.right;
                    Node change_node = current_node.right;
                    // 4-2-1. change_node 찾기
                    while (change_node.left != null) {
                        change_node_parent = change_node;
                        change_node = change_node.left;
                    }

                    // 4-2-2. change_node의 오른쪽 node가 존재하는 경우
                    if (change_node.right != null) {
                        System.out.print("change_node의 오른쪽 node 존재 : ");
                        // 4-2-2-1. 예외 처리 (change_node와 change_node_parent와 동일한 경우)
                        if (change_node != change_node_parent) {
                            change_node_parent.left = change_node.right;
                        }

                    // 4-2-3. change_node의 오른쪽 node가 존재하지 않은 경우
                    } else {
                        System.out.print("change_node의 오른쪽 node 미존재 : ");
                        change_node_parent.left = null;
                    }

                    // 4-2-4. switching
                    parent_node.right = change_node;
                    change_node.left = current_node.left;
                    // 4-2-4-1. 예외 처리 (change_node와 change_node_parent와 동일한 경우)
                    if (change_node != change_node_parent) {
                        change_node.right = current_node.right;
                    }
                    System.out.print("child_node 2개인 경우 삭제 : current_node는 parent_node의 오른쪽 : ");
                    return delete_success;
                }

            }
            return "";

        }

    }

    public static void main(String[] args) {
        Tree_Concept1 tree_Concept1 = new Tree_Concept1();
        Node head = tree_Concept1.new Node(10);
        NodeMgt nodeMgt = tree_Concept1.new NodeMgt(head);

        // 아래는 예외 CASE -> change_node와 change_node_parent가 동일한 경우

        nodeMgt.insert(5);
        nodeMgt.insert(2); // case3 삭제 node
        nodeMgt.insert(9);
        nodeMgt.insert(1);
        nodeMgt.insert(3);
        nodeMgt.insert(4);

        nodeMgt.insert(15);
        nodeMgt.insert(13);
        nodeMgt.insert(19); // case3 삭제 node
        nodeMgt.insert(17);
        nodeMgt.insert(24);
        nodeMgt.insert(25);

        System.out.println(nodeMgt.search(2));
        System.out.println(nodeMgt.search(4));
        System.out.println(nodeMgt.delete(2)); // 삭제
        System.out.println(nodeMgt.search(2));
        System.out.println(nodeMgt.search(4));

        System.out.println("----------------");

        System.out.println(nodeMgt.search(19));
        System.out.println(nodeMgt.search(25));
        System.out.println(nodeMgt.delete(19)); // 삭제
        System.out.println(nodeMgt.search(19));
        System.out.println(nodeMgt.search(25));
    }

}