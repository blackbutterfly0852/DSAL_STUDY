public class Picnic {

     // 2. P.155 소픙
     static int totalCount = 0; // static 변수로 최종 답을 구하는 것은 좋지 못함.

     public static void picnicMe(int n, int[][] friends, boolean[] visited, int cnt, int idx) {
         // 기저 사례
         if (cnt == (n / 2)) {
             totalCount++;
             return;
         }
 
         for (int i = idx; i < friends.length; i++) {
             int friendA = friends[i][0];
             int friendB = friends[i][1];
 
             if (!visited[friendA] && !visited[friendB]) {
                 // System.out.println(cnt + " " + friendA + " " + friendB);
                 visited[friendA] = true;
                 visited[friendB] = true;
                 picnicMe(n, friends, visited, cnt + 1, i + 1);
                 visited[friendA] = false;
                 visited[friendB] = false;
 
             }
         }
 
     }
 
     // p.155 소풍 풀이
 
     // 오답
     static int n;
     static boolean[][] areFriends = new boolean[10][10]; // 각각 친구 Setting
 
     public static void init(int number, int[][] friends) {
         n = number;
         for (int i = 0; i < friends.length; i++) {
             int friendA = friends[i][0];
             int friendB = friends[i][1];
             areFriends[friendA][friendB] = true;
             areFriends[friendB][friendA] = true;
         }
     }
 
     public static int groupingV1(boolean[] visited) {
         int first = -1;
 
         for (int i = 0; i < n; i++) {
             if (!visited[i]) {
                 first = i;
                 break;
             }
         }
         if (first == -1) {
             return 1;
         }
         int ret = 0;
 
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 if (!visited[i] && !visited[j] && areFriends[i][j]) {
                     visited[i] = visited[j] = true;
                     ret += groupingV1(visited);
                     visited[i] = visited[j] = false;
                 }
             }
 
         }
         return ret;
     }
 
     public static int groupingV2(boolean[] visited) {
         int first = -1;
 
         for (int i = 0; i < n; i++) {
             if (!visited[i]) {
                 first = i;
                 break;
             }
         }
         if (first == -1) {
             return 1;
         }
         int ret = 0;
 
         for (int next = first + 1; next < n; next++) {
             if(!visited[next] && areFriends[first][next]){
                 visited[first] = visited[next] = true;
                 ret += groupingV2(visited);
                 visited[first] = visited[next] = false;
             }
         }
 
         return ret;
     }


     
    public static void main(String[] args) {
        // p 155. 소풍
        // 1. 내 풀이
        // int n = 4;
        // int[][] friends = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 2 }, { 1, 3
        // } };
        int n = 6;
        int[][] friends = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 },
                { 4, 5 } };
        boolean[] visited = new boolean[n];
        // picnicMe(n, friends, visited, 0, 0);
        // System.out.println("totalCount : " + totalCount);

        // 2. 종만북 - 잘못된 풀이
        init(n, friends);
        System.out.println(groupingV1(visited));
        // 3. 종만북 - 올바른 풀이
        init(n, friends);
        System.out.println(groupingV2(visited));
    }
    
}
