package Day16_Day17;

public class Task3 {
    private static final int N = 8;

    // Utility function to print the solution
    private void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Utility function to check if a queen can be placed on board[row][col]
    private boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // A recursive utility function to solve N Queen problem
    public boolean SolveNQueen(int[][] board, int col) {
        // If all queens are placed then return true
        if (col >= N) {
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // Recur to place rest of the queens
                if (SolveNQueen(board, col + 1)) {
                    return true;
                }

                // If placing queen in board[i][col] doesn't lead to a solution
                // then backtrack: remove queen from board[i][col]
                board[i][col] = 0;
            }
        }

        // If the queen can not be placed in any row in this column col then return false
        return false;
    }

    public static void main(String[] args) {
        Task3 nQueen = new Task3();
        int[][] board = new int[N][N];

        if (!nQueen.SolveNQueen(board, 0)) {
            System.out.println("Solution does not exist");
        } else {
            nQueen.printSolution(board);
        }
    }
}
