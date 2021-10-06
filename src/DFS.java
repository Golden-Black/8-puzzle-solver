import java.util.*;

public class DFS {

    public void DFS(Node newNode, int[][] goalState){
        Stack<Node> toCheck = new Stack<Node>();
        ArrayList<Node> checked = new ArrayList<Node>();

        boolean goalFound = false;

        toCheck.push(newNode);
        int stateChecked = 1;
        int space = 0;
        int time = 0;

        while(!toCheck.isEmpty()){
            if(toCheck.size() > space){
                space = toCheck.size();
            }
            Node currentNode = toCheck.pop();
            checked.add(currentNode);
            time += 1;

            if(compareGoal(currentNode.state, goalState)){
                goalFound = true;
                System.out.println("Goal State Found!");
                trace(currentNode);
                System.out.println("Time: " + time);
                System.out.println("Space: " + space);
                break;
            }

            Node up = currentNode.Up(currentNode);
            if(up != null && uniqueToStack(toCheck, up) && uniqueToChecked(checked, up)){
                toCheck.push(up);
                currentNode.children.add(up);
                printing(up);
            }

            Node down = currentNode.Down(currentNode);
            if(down != null && uniqueToStack(toCheck, down) && uniqueToChecked(checked, down)){
                toCheck.push(down);
                currentNode.children.add(down);
                printing(down);
            }

            Node left = currentNode.Left(currentNode);
            if(left != null && uniqueToStack(toCheck, left) && uniqueToChecked(checked, left)){
                toCheck.push(left);
                currentNode.children.add(left);
                printing((left));
            }

            Node right = currentNode.Right(currentNode);
            if(right != null && uniqueToStack(toCheck, right) && uniqueToChecked(checked, right)){
                toCheck.push(right);
                currentNode.children.add(right);
                printing(right);
            }

            System.out.println("State checked: " +stateChecked++);
        }

        if(goalFound == false){
            System.out.println("Goal state wasn't found based on the given input.");
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
        int dfs_cost = 0;

        while(node.parent != null){
            tracing.add(node.parent.state);
            length++;
            dfs_cost++;
            node = node.parent;
        }

        for(int i = tracing.size() - 1; i < 0; i--){
            System.out.println(tracing.get(i));
        }

        System.out.println("Lenght: " + length);
        System.out.println("Cost: " + dfs_cost);
    }

    private void printing(Node nowNode) {
        System.out.println(Arrays.toString(nowNode.state[0]));
        System.out.println(Arrays.toString(nowNode.state[1]));
        System.out.println(Arrays.toString(nowNode.state[2]));
        System.out.println("\n");
    }
}
