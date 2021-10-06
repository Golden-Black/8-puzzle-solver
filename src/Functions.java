public class Functions {
    public void Method(String str, Node newNode, int[][] goalState){

        switch (str) {
            case "BFS" -> {
                BFS breadth = new BFS(newNode, goalState);
                breadth.BFS();
            }
            case "DFS" -> {
                DFS depthFirst = new DFS();
                depthFirst.DFS(newNode, goalState);
            }
            case "IterativeDeepening" -> {
                ITDN iterativeDeepening = new ITDN();
                iterativeDeepening.ITDN(newNode, goalState, 97);
            }
            case "UniformCost" -> {
                UniCost uniformCost = new UniCost();
                uniformCost.UniCost(newNode, goalState);
            }
            case "BestFirst" -> {
                BestFirst bestFirstSearch = new BestFirst();
                bestFirstSearch.BestFirst(newNode, goalState);
            }
            case "A*1" -> {
                AStarOne a1 = new AStarOne();
                a1.AStarOne(newNode, goalState);
            }
            case "A*2" -> {
                AStarTwo a2 = new AStarTwo();
                a2.AStarTwo(newNode, goalState);
            }
            case "A*3" -> {
                AStarThree a3 = new AStarThree();
                a3.AStarThree(newNode, goalState);
            }
            default -> {
                System.out.println(str + " : Method not found!");
                System.out.println("Please rerun the program.");
            }
        }

    }
}
