import java.util.Arrays;
// Quick 정렬 from Java
// 기준점(pivot 이라고 부름)을 정해서, 기준점보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right) 으로 모으는 함수를 작성함
// 각 왼쪽(left), 오른쪽(right)은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복함
// 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right) 을 리턴함
// 중요!! QuickSort_Concept.java는 input 배열 자체 내에서 idx만 활용하여 재귀적으로 정렬.
//        QuickSort_Concept_2.java는 ArrayList를 계속 생성해서 Quick정렬을 했다 -> 비효율적
// 시간복잡도 : O(nlogn) , O(n^3)
          
public class QuickSort_Concept {

   public static void quickSort(int[] list, int left, int right){

    int left_idx = left;
    int right_idx = right;
    int pivot = list[(left_idx+right_idx)/2];
    
    // 1. left_idx가 right_idx 보다 크다? -> pivot을 기준으로 왼쪽은 작은 수, 오른쪽은 큰 수로 정렬되었다는 의미.
    while(left_idx <= right_idx){
        System.out.println("A : " + left_idx + " " + right_idx);
        // 1-1. left_idx의 값이 pivot 값보다 클 때까지 반복
        while(list[left_idx]<pivot){
            left_idx++;
        }
        // 1-2. right_idx값이 pivot보다 작을 때까지 반복.
        while(list[right_idx]>pivot){
            right_idx--;
        }
        System.out.println("B : " + left_idx + " " + right_idx);
        // 1-3.
        // 현 left_idx : pivot보다 크거나 같은 값이 위치한 곳
        // 현 right_idx : pivot보다 작거나 작은 값이 위치한 곳
        // swap
        if(left_idx <= right_idx){
            int tmp_left = list[left_idx];
            list[left_idx++] = list[right_idx];
            list[right_idx--] = tmp_left;
        }
        System.out.println("C : " + left_idx + " " + right_idx);

    }
    // 2. 추출 
    System.out.println(left_idx + " " + right_idx);
    // 2-1. pivot 기준 왼쪽 : 0 ~ list[left_idx-1]
    System.out.print("왼쪽 : ");
    for(int l = 0; l < left_idx ; l++){
        System.out.print(" " + list[l]);
        
    }
    // 2-2. pivot
    System.out.println("");
    System.out.println("pivot : " + pivot);
    
    
    // 2-3. pivot 기준 오른쪽 : list[right_idx+1] ~ list.length-1;
    System.out.print("오른쪽 : ");
    for(int r = right_idx + 1; r < list.length; r++){
        System.out.print(" " + list[r]);
        
    }
    System.out.println("");

    // 2-4. pivot과 일치한다 -> left > right + 1
    if(left_idx > right_idx + 1){
        for (int same = right_idx+1 ; same <= left_idx-1 ; same++){
            System.out.println("pivot과 일치한다 : " + list[same]);
        }
    }
    System.out.println("");
     // 3. 퀵 재귀함수
     if(left < right_idx){quickSort(list, left, right_idx);}
     if(left_idx < right) {quickSort(list, left_idx, right);}

    }
    public static void main(String[] args) {
        int[] test =  {5,4,7,10,2};
        //int[] test =  {5,7,1,4,6,2,3,9,8};
        //int[] test_2 ={1,8,7,4,5,2,6,3,0};
        //System.out.println("5,7,1,4,6,2,3,9,8");
        quickSort(test,0,test.length-1);
        //System.out.println("1,8,7,4,5,2,6,3,0");
        //quickSort(test_2,0,test_2.length-1);
        for(int a : test){
            System.out.print(a + " ");
        }
        System.out.println("");
        //for(int a : test_2){
            //System.out.print(a + " ");
        //}
   
    }
    
}