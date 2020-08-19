import java.util.*;

public class Practice {
    static ArrayList<int[]> output_list = new ArrayList<int[]>();
    public static void per(int[] arr, int[] output, boolean[] visitied, int depth, int n, int r){
        // arr = {1,2,3}
        if(depth == r){
            System.out.println("");
            print(output, r);
        }
        for(int i = 0 ; i < n; i++){
            if(visitied[i] != true){
                visitied[i] = true; // visited[0] = true // visited[1] = true // visited[2] = true // vi
                output[depth] = arr[i]; //output[0] = 1; // ouput[1] = 2; // output[2] = 3;
                per(arr,output,visitied,depth+1,n,r); // depth = 1 // depth = 2 // depth = 3
                visitied[i] = false; // visited[2] = false; // visited[1] = false;
            }

        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    public static void main(String[] args) {
        String a = "179";
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        per(arr, output, visited, 0, n, 3);

        for(int i = 0 ; i<output_list.size(); i++){
            System.out.print("num_2 : ");
            for(int j = 0 ; j<output_list.get(i).length;j++){
                System.out.print(output_list.get(i)[j]);
            }
            System.out.println("");
        }

        for(int[] num : output_list){
            System.out.print("num_2 : ");
            for(int num_2 : num){
                 System.out.print(num_2 + " ");
            }
            System.out.println("");
        }
       //System.out.println(a.substring(0,2));
       // System.out.println(a.substring(1,3));
        //System.out.println(a.substring(2,4));
    }
}