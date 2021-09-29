import java.util.*;

public class DFS {
    public Node newNode;
    public int[][] goalState;

    public DFS(Node newNode, int[][] goalState) {
        this.newNode = newNode;
        this.goalState = goalState;
    }

    public void DFS(Node newNode, int[][] goalState){
        Stack<Node> toCheck = new Stack<Node>();
        ArrayList<Node> checked = new ArrayList<Node>();

        toCheck.push(newNode);
        int stateChecked = 1;

        while(!toCheck.isEmpty()){
            Node currentNode = toCheck.pop();
            checked.add(currentNode);

            if(compareGoal(currentNode.state, goalState)){
                System.out.println("Goal State Found!");
                trace(currentNode);
                break;
            }

            Node up = currentNode.Up(currentNode);
            if(up != null && uniqueToStack(toCheck, up) && uniqueToChecked(checked, up)){
                toCheck.push(up);
                currentNode.children.add(up);

                System.out.println(Arrays.toString(up.state[0]));
                System.out.println(Arrays.toString(up.state[1]));
                System.out.println(Arrays.toString(up.state[2]));
                System.out.println("\n");
            }

            Node down = currentNode.Down(currentNode);
            if(down != null && uniqueToStack(toCheck, down) && uniqueToChecked(checked, down)){
                toCheck.push(down);
                currentNode.children.add(down);

                System.out.println(Arrays.toString(down.state[0]));
                System.out.println(Arrays.toString(down.state[1]));
                System.out.println(Arrays.toString(down.state[2]));
                System.out.println("\n");

            }

            Node left = currentNode.Left(currentNode);
            if(left != null && uniqueToStack(toCheck, left) && uniqueToChecked(checked, left)){
                toCheck.push(left);
                currentNode.children.add(left);

                System.out.println(Arrays.toString(left.state[0]));
                System.out.println(Arrays.toString(left.state[1]));
                System.out.println(Arrays.toString(left.state[2]));
                System.out.println("\n");
            }

            Node right = currentNode.Right(currentNode);
            if(right != null && uniqueToStack(toCheck, right) && uniqueToChecked(checked, right)){
                toCheck.push(right);
                currentNode.children.add(right);

                System.out.println(Arrays.toString(right.state[0]));
                System.out.println(Arrays.toString(right.state[1]));
                System.out.println(Arrays.toString(right.state[2]));
                System.out.println("\n");
            }

            System.out.println("State checked: " +stateChecked++);
        }
    }

    private boolean compareGoal(int[][] state, int[][] goalState) {
        int cmp = 0;
        for(int i = 0; i < 3; i++){
            if(state[i][0] == goalState[i][0] && state[i][1] == goalState[i][1] && state[i][2] == goalState[i][2]){
                cmp++;
            }
            if(cmp == 3){
                return true;
            }
        }
        return false;
    }

    public boolean uniqueToStack(Stack<Node> toCheck, Node currentNode){

        if(toCheck.size() == 0){
            return true;
        }
        for(Node now: toCheck){
            int cmp = 0;
            for(int i = 0; i < 3; i++){
                if(now.state[i][0] == currentNode.state[i][0] && now.state[i][1] == currentNode.state[i][1] && now.state[i][2] == currentNode.state[i][2]){
                    cmp++;
                }
            }
            if(cmp == 3){
                return false;
            }
        }
        return true;
    }

    public boolean uniqueToChecked(ArrayList<Node> checked, Node currentNode){
        if(checked.isEmpty()){
            return true;
        }

        for(Node now: checked){
            int cmp = 0;
            for(int i = 0; i < 3; i++){
                if(now.state[i][0] == currentNode.state[i][0] && now.state[i][1] == currentNode.state[i][1] && now.state[i][2] == currentNode.state[i][2]){
                    cmp++;
                }
            }
            if(cmp == 3){
                return false;
            }
        }
        return true;
    }

    public void trace(Node node){
        ArrayList<int[][]> tracing = new ArrayList<int[][]>();
        int length = 0;

        while(node.parent != null){
            tracing.add(node.parent.state);
            length++;

            node = node.parent;
        }

        for(int i = tracing.size() - 1; i < 0; i--){
            System.out.println(tracing.get(i));
        }

        System.out.println("Lenght: " + length);

    }

}
