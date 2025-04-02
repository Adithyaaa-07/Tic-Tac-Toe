import java.util.*;

public class TicTacToe {
    private static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    private static char currentTurn = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        while (moves < 9 && !isWinner()) {
            displayBoard();
            System.out.print("Player " + currentTurn + ", pick a position (1-9): ");
            int pos = scanner.nextInt();

            if (markBoard(pos)) {
                moves++;
                if (!isWinner())
                    currentTurn = (currentTurn == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        
        displayBoard();
        System.out.println(isWinner() ? "Player " + currentTurn + " wins!" : "It's a draw!");
    }

    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---|---|---");
        }
    }

    private static boolean markBoard(int pos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char) (pos + '0')) {
                    board[i][j] = currentTurn;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
}
