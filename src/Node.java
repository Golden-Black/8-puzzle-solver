import java.util.ArrayList;

public class Node {
    public Node parent;
    public ArrayList<Node> children;
    public int[][] state;
    public int[][] goalState;
    public int level;
    public int cost;
    public int hOne;
    public int hTwo;
    public int hThree;

    public Node(Node parent, ArrayList<Node> children, int[][] state, int[][] goalState, int level, int cost, int hOne, int hTwo, int hThree) {
        this.parent = parent;
        this.children = children;
        this.state = state;
        this.goalState = goalState;
        this.level = level;
        this.cost = cost;
        this.hOne = hOne;
        this.hTwo = hTwo;
        this.hThree = hThree;
    }

    public Node Up(Node node){
        int[] indexZero = findZero(node.state);
        level = node.level + 1;
        hOne = find_hOne(node) + cost;
        hTwo = find_hTwo(node) + cost;
        hThree = hOne + hTwo;

        int[][] newPuzzle = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newPuzzle[i][j] = node.state[i][j];
            }
        }
        if(indexZero[0] == 1 || indexZero[0] == 2){
            int tmp = newPuzzle[indexZero[0] - 1][indexZero[1]];
            newPuzzle[indexZero[0] - 1][indexZero[1]] = 0;
            newPuzzle[indexZero[0]][indexZero[1]] = tmp;
            cost += tmp;
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle, goalState, level, cost, hOne, hTwo, hThree);
    };

    public Node Down(Node node){
        int[] indexZero = findZero(node.state);
        level = node.level + 1;
        hOne = find_hOne(node) + cost;
        hTwo = find_hTwo(node) + cost;
        hThree = hOne + hTwo;

        int[][] newPuzzle = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newPuzzle[i][j] = node.state[i][j];
            }
        }
        if(indexZero[0] == 0 || indexZero[0] == 1){
            int tmp = newPuzzle[indexZero[0] + 1][indexZero[1]];
            newPuzzle[indexZero[0] + 1][indexZero[1]] = 0;
            newPuzzle[indexZero[0]][indexZero[1]] = tmp;
            cost = cost + tmp;
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle, goalState, level, cost, hOne, hTwo, hThree);
    };

    public Node Left(Node node){
        int[] indexZero = findZero(node.state);
        level = node.level + 1;
        hOne = find_hOne(node) + cost;
        hTwo = find_hTwo(node) + cost;
        hThree = hOne + hTwo;

        int[][] newPuzzle = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newPuzzle[i][j] = node.state[i][j];
            }
        }
        if(indexZero[1] == 1 || indexZero[1] == 2){
            int tmp = newPuzzle[indexZero[0]][indexZero[1] - 1];
            newPuzzle[indexZero[0]][indexZero[1] - 1] = 0;
            newPuzzle[indexZero[0]][indexZero[1]] = tmp;
            cost = cost + tmp;
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle, goalState, level, cost, hOne, hTwo, hThree);
    };

    public Node Right(Node node){
        int[] indexZero = findZero(node.state);
        level = node.level + 1;
        hOne = find_hOne(node) + cost;
        hTwo = find_hTwo(node) + cost;
        hThree = hOne + hTwo;

        int[][] newPuzzle = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newPuzzle[i][j] = node.state[i][j];
            }
        }
        if(indexZero[1] == 0 || indexZero[1] == 1){
            int tmp = newPuzzle[indexZero[0]][indexZero[1] + 1];
            newPuzzle[indexZero[0]][indexZero[1] + 1] = 0;
            newPuzzle[indexZero[0]][indexZero[1]] = tmp;
            cost = cost + tmp;
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle, goalState, level, cost, hOne, hTwo, hThree);
    };

    public int[] findZero(int[][] state){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(state[i][j] == 0){
                    int[] zeroIndex = {i, j};
                    return zeroIndex;
                }
            }
        }
        return new int[0];
    }

    public static int find_hOne(Node newNode){
        int diff = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(newNode.state[i][j] != newNode.goalState[i][j]){
                    diff = diff + 1;
                }
            }
        }
        return 9 - diff;
    }

    private static int find_hTwo(Node newNode) {
        int distance = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                int manhattan = Math.abs(i - findRow(newNode.state[i][j], newNode.goalState)) + Math.abs(j - findCol(newNode.state[i][j], newNode.goalState));
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