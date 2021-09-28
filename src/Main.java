import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String mode = "Hard";
        int[][] initialState = new int[3][3];
        int[][] goalState = new int[][]{{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};

        if(mode.equals("Easy")){
            initialState = new int[][]{{1, 3, 4}, {8, 6, 2}, {7, 0, 5}};
        }else if(mode.equals("Medium")){
            initialState = new int[][]{{2, 8, 1}, {0, 4, 3}, {7, 6, 5}};
        }else if(mode.equals("Hard")){
            initialState = new int[][]{{5, 6, 7}, {4, 0, 8}, {3, 2, 1}};
        }else{

        }

        ArrayList<Node> child = new ArrayList<Node>();

        Node newNode = new Node(null, child, initialState);

        BFS breadth = new BFS(newNode, goalState);
        breadth.BFS();

        // dfs(initialState, goalState);
        // iterativeDeepening(initialState, goalState);
        // uniformCost(initialState, goalState);

    }
}
