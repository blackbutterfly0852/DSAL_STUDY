// 순열(permutation) : n개 중에서 r개를 순서있게 추출 -> nPr
// 참고 : https://bcp0109.tistory.com/entry/%EC%88%9C%EC%97%B4-Permutation-Java?category=848939
// 1. SWAP 방식 : depth 를 기준 인덱스로 하여 depth 보다 인덱스가 작은 값들은 그대로 고정하고 depth 보다 인덱스가 큰 값들만 가지고 다시 swap 을 진행합니다.
// 2. DFS  방식 : 
public class Permutation_Concept {

    // 1. SWAP 방식
    // {1,2,3} -> swap(0,0)  [ {swap(1,1) -> {1,2} 추출 -> swap(1,1)} -> {swap(1,2) -> {1,3} 추출 -> swap(1,2)} ] swap(0,0)
    //         -> swap(0,1)  [ {swap(1,1) -> {2,1} 추출 -> swap(1,1)} -> {swap(1,2) -> {2,3} 추출 -> swap(1,2)} ] swap(0,1)
    //         -> swap(0,2)  [ {swap(1,1) -> {3,1} 추출 -> swap(1,1)} -> {swap(1,2) -> {3,2} 추출 -> swap(1,2)} ] swap(0,2)

    public static void per_1(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(" ");
        }
     
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            per_1(arr, depth + 1, n, r);
            swap(arr, depth, i);

        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }


    // 2. DFS 방식
    public static void per_2(int[] arr, int[] output, boolean[] visited , int depth, int n, int r){
        if(depth == r){
            for(int i = 0 ; i < r ; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println("");
        }
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                per_2(arr,output,visited,depth+1,n,r);
                output[depth] = 0; // 없어도 됨, output[depth] = arr[depth] -> 덮어쓰기
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
       // per_1(arr, 0, 4, 1);

          
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        per_2(arr,output,visited,0,arr.length,3);

    }

}