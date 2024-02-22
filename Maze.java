public class Maze {
    private String maze[][];
    public boolean safe[][];

    public Maze(String maze[][]) {
        this.maze = maze;
        safe = new boolean[maze.length][maze[0].length];
    }
    boolean found =false;
    public void check()
    {
        checkHelper(0,0);
        if(found)
            System.out.println("Exit Found");
        else System.out.println("Exit Not Found");
    }

    public void checkHelper(int r, int c) {
        if(r>-1&&c>-1&&r< maze.length&&c<maze[0].length&&safe[r][c]==false&&maze[r][c]==".") {
            //win con
            if (r == maze.length - 1)
                found=true;
            else {
                safe[r][c]=true;
                checkHelper(r + 1, c);
                checkHelper(r - 1, c);
                checkHelper(r, c + 1);
                checkHelper(r, c - 1);
            }

        }

    }
}
