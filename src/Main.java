import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String mode = "Hard"; // Choose from: Easy, Medium, Hard
        String algo = "IterativeDeepening"; // Choose from: BFS, DFS, IterativeDeepening, UniformCost, BestFirst, A*1, A*2, A*3

        Functions search = new Functions();

        int[][] goalState = new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
        // [1, 2, 3]
        // [8, 0, 4]
        // [7, 6, 5]

        if(mode.equals("Easy")){
            int[][] initialState = new int[][]{{1, 3, 4}, {8, 6, 2}, {7, 0, 5}};
            // [1, 3, 4]
            // [8, 6, 2]
            // [7, 0, 5]
            int h1 = find_hOne(initialState, goalState);
            int h2 = find_hTwo(initialState, goalState);
            int h3 = h1 + h2;

            ArrayList<Node> child = new ArrayList<Node>();
            Node newNode = new Node(null, child, initialState, goalState, 0, 0, h1, h2, h3);
            search.Method(algo, newNode, goalState);

        }else if(mode.equals("Medium")){
            int[][] initialState = new int[][]{{2, 8, 1}, {0, 4, 3}, {7, 6, 5}};
            // [2, 8, 1]
            // [0, 4, 3]
            // [7, 6, 5]
            int h1 = find_hOne(initialState, goalState);
            int h2 = find_hTwo(initialState, goalState);
            int h3 = h1 + h2;

            ArrayList<Node> child = new ArrayList<Node>();
            Node newNode = new Node(null, child, initialState, goalState, 0, 0, h1, h2, h3);
            search.Method(algo, newNode, goalState);

        }else if(mode.equals("Hard")){
            int[][] initialState = new int[][]{{5, 6, 7}, {4, 0, 8}, {3, 2, 1}};
            // [5, 6, 7]
            // [4, 0, 8]
            // [3, 2, 1]
            int h1 = find_hOne(initialState, goalState);
            int h2 = find_hTwo(initialState, goalState);
            int h3 = h1 + h2;

            ArrayList<Node> child = new ArrayList<Node>();
            Node newNode = new Node(null, child, initialState, goalState, 0, 0, h1, h2, h3);
            search.Method(algo, newNode, goalState);

        }else{
            System.out.println("Input not found! Please try again and choose one of the difficulties below: ");
            System.out.println("Easy, Medium, Hard");
        }
    }

    public static int find_hOne(int[][] initialState, int[][] goalState){
        int diff = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(initialState[i][j] != goalState[i][j]){
                    diff = diff + 1;
                }
            }
        }
        return 9 - diff;
    }

    public static int find_hTwo(int[][] initialState, int[][] goalState) {
        int distance = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                int manhattan = Math.abs(i - findRow(initialState[i][j], goalState)) + Math.abs(j - findCol(initialState[i][j], goalState));
                distance = distance + manhattan;
            }
        }
        return distance;
    }

    private static int findRow(int row, int[][] goalState) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(goalState[i][j] == row){
                    return i;
                }
            }
        }
        return -1;
    }

    private static int findCol(int col, int[][] goalState) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(goalState[i][j] == col){
                    return j;
                }
            }
        }
        return -1;
    }
}
