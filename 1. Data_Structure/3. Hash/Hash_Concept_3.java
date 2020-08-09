import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 충돌(Collision) 해결 알고리즘
// - 해쉬충돌(Hash Collision) : 동일한 address에 두 개 이상의 데이터가 저장되는 경우 충돌
// - 충돌방지기법 : Chaining , Linear Probing 
//      - Chaining : 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법
//      - Linear Probing  : 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
// Linear Probing 

public class Hash_Concept_3 {

    Map<String, String>[] hash_table;

    public Hash_Concept_3(int size) {
        hash_table = new HashMap[size];
    }

    // 1. getHashCode
    public int getHashCode(String key) {
        return key.hashCode();
    }

    // 2. convertToIndex
    public int convertToIndex(int hashCode) {
        return hashCode % hash_table.length;
    }

    
    // 4. put
    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        Map<String, String> list = hash_table[index];
        // 4-1. 해당 index가 null인 경우
        if (list == null) {
            hash_table[index] = new HashMap<String,String>();
            hash_table[index].put(key, value);
        // 4-2. 해당 index에 데이터 존재하는 경우
        } else {
            for (int i = index + 1 ; i<hash_table.length-1 ; i++){
                if (hash_table[i] == null){
                    hash_table[i] = new HashMap<String,String>();
                    hash_table[i].put(key, value);
                    break;
                }
            }
        }
    }

    // 5. get
    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        if (hash_table[index].containsKey(key)){
            return hash_table[index].get(key);
        }
        return null;
    }


    public static void main(String[] args) {
        Hash_Concept_3 ht = new Hash_Concept_3(10);
        ht.put("sung", "She is pretty");
        ht.put("jin", "She is model");
        ht.put("jin", "he is model");
        ht.put("hee", "She is angel");
        ht.put("min", "She is cute");
        for (int i = 0; i < ht.hash_table.length-1;i++){
            System.out.println("ht.hash_table : " + ht.hash_table[i]);

        }
        System.out.println(ht.get("sung"));
        System.out.println("-----------------------------");
        System.out.println(ht.get("jin"));
        System.out.println("-----------------------------");
        System.out.println(ht.get("hee"));
        System.out.println("-----------------------------");
        System.out.println(ht.get("min"));
        System.out.println("-----------------------------");
        System.out.println(ht.get("jae"));
        System.out.println("-----------------------------");

    }

}