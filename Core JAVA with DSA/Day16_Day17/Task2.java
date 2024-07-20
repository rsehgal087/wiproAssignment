package Day16_Day17;

public class Task2 {
    private static final int N = 6;

    // Utility function to check if x, y is valid index for N*N maze
    private boolean isSafe(int x, int y, int[][] maze) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Utility function to solve Maze problem using backtracking
    public boolean SolveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (solveMazeUtil(maze, 0, 0, solution) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(solution);
        return true;
    }

    // A recursive utility function to solve Maze problem
    private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        // If (x, y is goal) return true
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(x, y, maze)) {
            // Mark x, y as part of solution path
            solution[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            // If moving in x direction doesn't give solution then
            // Move down in y direction
            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            // If none of the above movements work then
            // BACKTRACK: unmark x, y as part of solution path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    // Utility function to print solution matrix
    private void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Task2 ratMaze = new Task2();
        int[][] maze = {
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 1}
        };

        ratMaze.SolveMaze(maze);
    }
}

