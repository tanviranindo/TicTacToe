import java.util.Scanner;

/*
 * @author Tanvir Rahman
 */

public class TicTacToe {
    public static int length;
    public static String[][] board;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter board length: ");
        length = input.nextInt();

        init();
        print();

        while (true) {
            System.out.print("Enter X: ");
            int x = input.nextInt();
            while (checker(x)) {
                System.out.println("Wrong Input. Try again!");
                System.out.print("Enter X: ");
                x = input.nextInt();
            }
            inputX(x);
            print();
            if (checkXHorizontal() || checkXVertical() || checkXDiagonal()) {
                System.out.println("X Wins");
                break;
            } else if (full()) {
                System.out.println("Score Tied");
                break;
            }

            System.out.print("Enter Y: ");
            int y = input.nextInt();
            while (checker(y)) {
                System.out.println("Wrong Input. Try again!");
                System.out.print("Enter Y: ");
                y = input.nextInt();
            }
            inputY(y);
            print();
            if (checkYHorizontal() || checkYVertical() || checkYDiagonal()) {
                System.out.println("Y Wins");
                break;
            } else if (full()) {
                System.out.println("Score Tied");
                break;
            }
        }
    }

    public static void init() {
        board = new String[length][length];
        System.out.println(length + "x" + length + " board: ");
        for (int i = 0, k = 1; i < length; i++) {
            for (int j = 0; j < length; j++, k++) {
                board[i][j] = Integer.toString(k);
            }
        }
    }

    public static void print() {
        int i = 0;
        while (i < length) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
            i++;
        }
    }

    public static void inputX(int x) {
        for (int i = 0, k = 1; i < length; i++) {
            for (int j = 0; j < length; j++, k++) {
                if (k == x) board[i][j] = "X";
            }
        }
    }

    public static void inputY(int y) {
        for (int i = 0, k = 1; i < length; i++) {
            for (int j = 0; j < length; j++, k++) {
                if (k == y) board[i][j] = "Y";
            }
        }
    }

    public static boolean checker(int input) {
        for (int i = 0, k = 1; i < length; i++) {
            for (int j = 0; j < length; j++, k++) {
                if (k == input && (board[i][j].equals("X") || board[i][j].equals("Y"))) return true;
            }
        }
        return false;
    }

    public static boolean full() {
        int count = 0;
        for (int i = 0, k = 1; i < length; i++) {
            for (int j = 0; j < length; j++, k++) {
                if (board[i][j].equals("X") || board[i][j].equals("Y")) count++;
            }
        }
        return count == length * length;
    }

    public static boolean checkXHorizontal() {
        for (String[] strings : board) {
            int count = 0;
            for (String string : strings) {
                if (string.equals("X")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXVertical() {
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (String[] strings : board) {
                if (strings[i].equals("X")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXDiagonal() {
        int count = 0;
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (board[i][j].equals("X")) {
                count++;
                if (count == length) return true;
            }
        }
        count = 0;
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            if (board[i][j].equals("X")) {
                count++;
                if (count == length) return true;
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
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYVertical() {
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (String[] strings : board) {
                if (strings[i].equals("Y")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYDiagonal() {
        int count = 0;
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (board[i][j].equals("Y")) {
                count++;
                if (count == length) return true;
            }
        }
        count = 0;
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            if (board[i][j].equals("Y")) {
                count++;
                if (count == length) return true;
            }
        }
        return false;
    }
}
