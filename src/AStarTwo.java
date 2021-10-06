import java.util.ArrayList;
import java.util.Arrays;

public class AStarTwo {
    public void AStarTwo(Node newNode, int[][] goalState){
        ArrayList<Node> toCheck = new ArrayList<Node>();
        ArrayList<Node> checked = new ArrayList<Node>();

        boolean goalFound = false;

        toCheck.add(newNode);
        int statesChecked = 1;
        int space = 0;
        int time = 0;

        while (!toCheck.isEmpty()) {
            if(toCheck.size() > space){
                space = toCheck.size();
            }
            // sort the nodes by cost
            int small = sorting(toCheck);
            Node currentNode = toCheck.get(small);
            checked.add(currentNode);
            toCheck.remove(small);
            time++;

            if (compareGoal(currentNode.state, goalState)) {
                goalFound = true;
                System.out.println("Goal State Found!");
                trace(currentNode);
                System.out.println("Time: " + time);
                System.out.println("Space: " + space);
                break;
            }

            Node up = currentNode.Up(currentNode);
            if (up != null && uniqueToArr(toCheck, up) && uniqueToChecked(checked, up)) {
                toCheck.add(up);
                currentNode.children.add(up);
                printing(up);
            }

            Node down = currentNode.Down(currentNode);
            if (down != null && uniqueToArr(toCheck, down) && uniqueToChecked(checked, down)) {
                toCheck.add(down);
                currentNode.children.add(down);
                printing(down);
            }

            Node left = currentNode.Left(currentNode);
            if (left != null && uniqueToArr(toCheck, left) && uniqueToChecked(checked, left)) {
                toCheck.add(left);
                currentNode.children.add(left);
                printing(left);
            }

            Node right = currentNode.Right(currentNode);
            if (right != null && uniqueToArr(toCheck, right) && uniqueToChecked(checked, right)) {
                toCheck.add(right);
                currentNode.children.add(right);
                printing(right);
            }

            System.out.println("State checked: " + statesChecked++);
        }

        if(goalFound == false){
            System.out.println("Goal state wasn't found based on the given input.");
        }
    }

    private void printing(Node nowNode) {
        System.out.println(Arrays.toString(nowNode.state[0]));
        System.out.println(Arrays.toString(nowNode.state[1]));
        System.out.println(Arrays.toString(nowNode.state[2]));
        System.out.println("\n");
    }

    public int sorting(ArrayList<Node> listings){
        int smallest = Integer.MAX_VALUE;
        int small_indexA2 = 0;
        int size = listings.size();

        for(int i = 0; i < size; i++){
            if(listings.get(i).hTwo < smallest){
                smallest = listings.get(i).hTwo;
                small_indexA2 = i;
            }
        }
        return small_indexA2;
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

    public boolean uniqueToArr(ArrayList<Node> toCheck, Node currentNode){

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

    public void trace(Node node) {
        ArrayList<int[][]> tracing = new ArrayList<int[][]>();
        int length = 0;
        int a2_cost = node.cost;

        while (node.parent != null) {
            tracing.add(node.parent.state);
            length++;
            node = node.parent;
        }

        for (int i = tracing.size() - 1; i < 0; i--) {
            System.out.println(tracing.get(i));
        }
        System.out.println("Lenght: " + length);
        System.out.println("Cost: " + a2_cost);
    }
}
