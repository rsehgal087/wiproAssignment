package Day16_Day17;

public class Task1 {
    private static final int N = 8;

    // Check if x and y are valid indices for an N x N chessboard
    private boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Utility function to solve Knight Tour problem
    public boolean SolveKnightsTour(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        int nextX, nextY;
        if (moveCount == N * N) {
            return true;
        }

        for (int k = 0; k < N; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (SolveKnightsTour(board, nextX, nextY, moveCount + 1, xMove, yMove)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }

        return false;
    }

    // Function to print the solution
    public void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Task1 knightTour = new Task1();
        int[][] board = new int[N][N];

        // Initialize the solution matrix
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                board[x][y] = -1;
            }
        }

        // xMove[] and yMove[] define next move of Knight.
        // xMove[] is for next value of x coordinate
        // yMove[] is for next value of y coordinate
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        board[0][0] = 0;

        // Start from 0,0 and explore all tours using solveKTUtil()
        if (!knightTour.SolveKnightsTour(board, 0, 0, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else {
            knightTour.printSolution(board);
        }
    }
}

