import java.util.Scanner;

public class TicTacToe {
    public static String[][] board = new String[3][3];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        init();
        print();

        while (true) {
            System.out.print("Enter X: ");
            int x = input.nextInt();
            while (!checker(x)) {
                System.out.println("Wrong Input. Try again!");
                System.out.print("Enter X: ");
                x = input.nextInt();
            }
            inputX(x);
            print();
            if (checkXHorizontal() || checkXVertical() || checkXDiagonal()) {
                System.out.println("X Wins");
                break;
            } else if (full()) break;

            System.out.print("Enter Y: ");
            int y = input.nextInt();
            while (!checker(y)) {
                System.out.println("Wrong Input. Try again!");
                System.out.print("Enter Y: ");
                y = input.nextInt();
            }
            inputY(y);
            print();
            if (checkYHorizontal() || checkYVertical() || checkYDiagonal()) {
                System.out.println("Y Wins");
                break;
            } else if (full()) break;
        }
    }

    public static void init() {
        for (int i = 0, k = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++, k++) {
                board[i][j] = Integer.toString(k);
            }
        }
    }

    public static void print() {
        int i = 0;
        while (i < board.length) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
            i++;
        }
    }

    public static void inputX(int x) {
        for (int i = 0, k = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++, k++) {
                if (k == x) board[i][j] = "X";
            }
        }
    }

    public static void inputY(int y) {
        for (int i = 0, k = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++, k++) {
                if (k == y) board[i][j] = "Y";
            }
        }
    }

    public static boolean checker(int input) {
        for (int i = 0, k = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++, k++) {
                if (k == input && (board[i][j].equals("X") || board[i][j].equals("Y"))) return false;
            }
        }
        return true;
    }

    public static boolean full() {
        int count = 0;
        for (int i = 0, k = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++, k++) {
                if (board[i][j].equals("X") || board[i][j].equals("Y")) count++;
            }
        }
        return count == board.length * board.length;
    }

    public static boolean checkXHorizontal() {
        for (String[] strings : board) {
            int count = 0;
            for (String string : strings) {
                if (string.equals("X")) {
                    count++;
                    if (count == board.length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXVertical() {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (String[] strings : board) {
                if (strings[i].equals("X")) {
                    count++;
                    if (count == board.length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXDiagonal() {
        int i, j;
        int count = 0;
        for (i = 0, j = 0; i < board.length; i++, j++) {
            if (board[i][j].equals("X")) {
                count++;
                if (count == board.length) return true;
            }
        }
        count = 0;
        for (int k = 0, l = i - 1; k < 3; k++, l--) {
            if (board[k][l].equals("X")) {
                count++;
                if (count == board.length) return true;
            }
        }
        return false;
    }

    public static boolean checkYHorizontal() {
        for (String[] strings : board) {
            int count = 0;
            for (String string : strings) {
                if (string.equals("Y")) {
                    count++;
                    if (count == board.length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYVertical() {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (String[] strings : board) {
                if (strings[i].equals("Y")) {
                    count++;
                    if (count == board.length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYDiagonal() {
        int i, j;
        int count = 0;
        for (i = 0, j = 0; i < board.length; i++, j++) {
            if (board[i][j].equals("Y")) {
                count++;
                if (count == board.length) return true;
            }
        }
        count = 0;
        for (int k = 0, l = i - 1; k < board.length; k++, l--) {
            if (board[k][l].equals("Y")) {
                count++;
                if (count == board.length) return true;
            }
        }
        return false;
    }
}
