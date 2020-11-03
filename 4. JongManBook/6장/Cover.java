public class Cover {
    // 덮힘 : true;
    // 안덮힘 : false;

    static int[][][] coverType = {

        {{0,0} , {0,1} , {1,0}},
        {{0,0} , {0,1} , {1,1}},
        {{0,0} , {1,0} , {1,1}},
        {{0,0} , {1,0} , {1,-1}}
    };


    

    static boolean[][] isVisited;

    public static boolean[][] init(int x, int y, String[][] current) {
        isVisited = new boolean[x][y];
        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[i].length; j++) {
                if (current[i][j].equals("#")) {
                    isVisited[i][j] = true;
                }
            }
        }
        return isVisited;
    }

    // 덮힘 : true;
    // 안덮힘 : false;
    public static boolean isPossible(boolean[][] isVisited) {
        int count = 0;
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                if (!isVisited[i][j]) {
                    count++;
                }
            }
        }
        return count % 3 == 0 ? true : false;
    }

    public static int converCount(boolean[][] isVisited, int[][] shape) {

        // 기저 사례 1 : 안덮힘 개수가 % 3 !=0이 아닌 경우
        if (!isPossible(isVisited)) {
            return 0;
        }

        // 기저 사례 2 : isAllCover true 경우 모두 다 덮힌 경우이다.
        boolean isAllCover = true;
        // 덮힘 : true;
        // 안덮힘 : false;
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                if (!isVisited[i][j]) {
                    isAllCover = false;
                    break;
                }
            }
        }
        if (isAllCover) {
            return 1;
        }

        int ret = 0;
        for(int i = 0 ; i < )
        

        return ret;

    }

    public static void main(String[] args) {
        int x = 3;
        int y = 7;
        String[][] current = { { "#.....#" }, { "#.....#" }, { "##..###" } };
        init(x, y, current);

    }

}
