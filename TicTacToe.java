import java.util.Scanner;

public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static int player = 1;
    static int Game = 0;
    static char Mark;

    static final int Win = 1;
    static final int Draw = -1;
    static final int Running = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe Game Designed By Vivek. Enjoy!");
        System.out.println("Player 1 [X] --- Player 2 [O]\n");
        System.out.println("Please Wait...");

        while (Game == Running) {
            DrawBoard();
            if (player % 2 != 0) {
                System.out.println("Player 1's turn");
                Mark = 'X';
            } else {
                System.out.println("Player 2's turn");
                Mark = 'O';
            }

            int choice;
            while (true) {
                System.out.print("Enter the position (1-9) where you want to mark: ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 9 && CheckPosition(choice)) {
                    break;
                }
                System.out.println("Invalid position! Try again.");
            }

            board[choice] = Mark;
            player++;
            CheckWin();
        }

        DrawBoard();
        if (Game == Draw) {
            System.out.println("Game Draw");
        } else if (Game == Win) {
            player--;
            if (player % 2 != 0) {
                System.out.println("Player 1 Won");
            } else {
                System.out.println("Player 2 Won");
            }
        }
        scanner.close();
    }

    static void DrawBoard() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");
    }

    static boolean CheckPosition(int x) {
        return board[x] == ' ';
    }

    static void CheckWin() {
        // Horizontal Winning Condition
        if (board[1] == board[2] && board[2] == board[3] && board[1] != ' ') {
            Game = Win;
        } else if (board[4] == board[5] && board[5] == board[6] && board[4] != ' ') {
            Game = Win;
        } else if (board[7] == board[8] && board[8] == board[9] && board[7] != ' ') {
            Game = Win;
        }
        // Vertical Winning Condition
        else if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ') {
            Game = Win;
        } else if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ') {
            Game = Win;
        } else if (board[3] == board[6] && board[6] == board[9] && board[3] != ' ') {
            Game = Win;
        }
        // Diagonal Winning Condition
        else if (board[1] == board[5] && board[5] == board[9] && board[1] != ' ') {
            Game = Win;
        } else if (board[3] == board[5] && board[5] == board[7] && board[3] != ' ') {
            Game = Win;
        }
        // Draw Condition
        else if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' &&
                 board[4] != ' ' && board[5] != ' ' && board[6] != ' ' &&
                 board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
            Game = Draw;
        } else {
            Game = Running;
        }
    }
}
