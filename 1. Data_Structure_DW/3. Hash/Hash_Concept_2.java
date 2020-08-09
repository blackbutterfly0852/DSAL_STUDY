import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 충돌(Collision) 해결 알고리즘
// - 해쉬충돌(Hash Collision) : 동일한 address에 두 개 이상의 데이터가 저장되는 경우 충돌
// - 충돌방지기법 : Chaining , Linear Probing 
//      - Chaining : 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

// Chaining 기법
public class Hash_Concept_2 {
    
    LinkedList<Node>[] data; // {{linkedList}, {linkedList}, {linkedList}, {linkedList}......}

    public Hash_Concept_2(int size){
        this.data = new LinkedList[size]; 
    }

    public int getHashCode(String key){
        return key.hashCode();
    }

    public int converToIndex(int hashCode){
        return hashCode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key){
        if(list==null){
            return null;
        }
        for(Node node : list){
            if (node.key == key) {return node;}
            
        }
        return null;
    }


    public void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = converToIndex(hashCode);

        LinkedList<Node> list = data[index];
        if(list == null){
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);

        if(node == null){
            list.add(new Node(key, value));
        }else{
            node.setValue(value);
        }
    }

    public String get(String key){
        int hashCode = getHashCode(key);
        int index = converToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not Found" : node.value;
    }


    class Node{
        String key;
        String value;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setValue(String value) {
            this.value = value;
        }


    }
    
   

    

    

    public static void main(String[] args) {
        Hash_Concept_2 ht = new Hash_Concept_2(3);
        ht.put("sung", "She is pretty");
        ht.put("jin", "She is model");
        ht.put("hee", "She is angel");
        ht.put("min", "She is cute");
        
        System.out.println(ht.get("sung"));
        System.out.println(ht.get("jin"));
        System.out.println(ht.get("hee"));
        System.out.println(ht.get("min"));
        System.out.println(ht.get("jae"));
   
    }

   
}