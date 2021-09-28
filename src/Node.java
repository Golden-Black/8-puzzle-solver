import java.util.ArrayList;

public class Node {
    public Node parent;
    public ArrayList<Node> children;
    public int[][] state;

    public Node(Node parent, ArrayList<Node> children, int[][] state) {
        this.parent = parent;
        this.children = children;
        this.state = state;
    }

    public Node Up(Node node){
        int[] indexZero = findZero(node.state);

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
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle);
    };

    public Node Down(Node node){
        int[] indexZero = findZero(node.state);

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
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle);
    };

    public Node Left(Node node){
        int[] indexZero = findZero(node.state);

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
        }else{
            return null;
        }
        return new Node(node, new ArrayList<Node>(), newPuzzle);
    };

    public Node Right(Node node){
        int[] indexZero = findZero(node.state);

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
        }else{
            return null;
        }

        return new Node(node, new ArrayList<Node>(), newPuzzle);
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

}
