//  - 해쉬(Hash): 임의 값을 고정 길이로 변환하는 것
//  - 해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조(Key-Value)
//  - 해싱 함수(Hashing Function): Key에 대해 산술 연산을 이용해 데이터 위치를 찾을 수 있는 함수
//  - 해쉬 값(Hash Value) 또는 해쉬 주소(Hash Address): Key를 해싱 함수로 연산해서, 해쉬 값을 알아내고,
//    이를 기반으로 해쉬 테이블에서 해당 Key에 대한 데이터 위치를 일관성있게 찾을 수 있음
//  - 슬롯(Slot): 한 개의 데이터를 저장할 수 있는 공간
//  - 저장할 데이터에 대해 Key를 추출할 수 있는 별도 함수도 존재할 수 있음
//  - 보통 배열로 미리 Hash Table 사이즈만큼 생성 후에 사용 (공간과 탐색 시간을 맞바꾸는 기법)

//  - 장점
//      - 데이터 저장/읽기 속도가 빠르다. (검색 속도가 빠르다.)
//      - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉬움

//  - 단점
//      - 일반적으로 저장공간이 좀더 많이 필요하다.
//      - 여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함

//  - 주요 용도
//      - 검색이 많이 필요한 경우
//      - 저장, 삭제, 읽기가 빈번한 경우
//      - 캐쉬 구현시 (중복 확인이 쉽기 때문)


// save(key,value) -> key에 대한 해싱함수로 위치값 리턴 -> 해당 위치값으로 데이터 저장
// get(key) -> key에 대한 해싱함수로 위치값 리턴 -> 해당 위치값으로 데이터 가져옴
// Hash_Concept_1 해싱함수 : String의 첫번째 문자를 ascii로 변환 후 %5를 통해 위치값 리턴

public class Hash_Concept_1 {
    String[] hash_table;
    // 1. create hash table
    public Hash_Concept_1(int size){
        hash_table = new String[size];
    }

    // 2. ascii code
     public int change_ascii(char input){
        return (int) input;
    }

    // 3. hash function
    public int hash_function(int key){
        return key%5;
    }
   
 
    // 4. save data
    public void save_data(String key, String Value){
        char key_splict = key.charAt(0);
        int ascii_code = change_ascii(key_splict);
        int hash_location = hash_function(ascii_code);
        hash_table[hash_location] = Value;
    }

    // 5. get data
    public String get_data(String key){
        char key_splict = key.charAt(0);
        int hash_location = hash_function(key_splict);
        System.out.println(hash_table[hash_location]);
        return hash_table[hash_location];
    }

    public static void main(String[] args) {
        
        Hash_Concept_1 hash_example = new Hash_Concept_1(10);

        hash_example.save_data("Andy","01050617161");
        hash_example.save_data("Ben","01093827161");
        hash_example.save_data("Cho","01029387161");
        hash_example.save_data("Dandy","01044987161");
      
        hash_example.get_data("Andy");
        hash_example.get_data("Ben");
        hash_example.get_data("Cho");
        hash_example.get_data("Fandy");
        
    }

    
}