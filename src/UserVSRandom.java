import java.util.Random;
import java.util.Scanner;

/*
 * @author Tanvir Rahman
 */

public class UserVSRandom {
    public static int length;
    public static String[][] board;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Board Length: ");
        length = input.nextInt();

        init();
        print();

        while (true) {
            System.out.print("Enter X: ");
            int x = input.nextInt();
            while (checker(x) || x < 1 || x > length * length) {
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
                System.out.println("Score Ties");
                break;
            }

            Random r = new Random();
            int y = r.nextInt(length * length);
            while (checker(y) || y == 0) y = r.nextInt(length * length);
            System.out.println("Computer gives : " + y);
            inputY(y);
            print();
            if (checkYHorizontal() || checkYVertical() || checkYDiagonal()) {
                System.out.println("Computer Wins");
                break;
            } else if (full()) {
                System.out.println("Score Ties");
                break;
            }
        }
    }

    public static void init() {
        board = new String[length][length];
        System.out.println(length + "x" + length + " Board: ");
        for (int row = 0, k = 1; row < length; row++) {
            for (int column = 0; column < length; column++, k++) {
                board[row][column] = Integer.toString(k);
            }
        }
    }

    public static void print() {
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void inputX(int x) {
        for (int row = 0, k = 1; row < length; row++) {
            for (int column = 0; column < length; column++, k++) {
                if (k == x) board[row][column] = "X";
            }
        }
    }

    public static void inputY(int y) {
        for (int row = 0, k = 1; row < length; row++) {
            for (int column = 0; column < length; column++, k++) {
                if (k == y) board[row][column] = "Y";
            }
        }
    }

    public static boolean checker(int input) {
        for (int row = 0, k = 1; row < length; row++) {
            for (int column = 0; column < length; column++, k++) {
                if ((k == input) && (board[row][column].equals("X") || board[row][column].equals("Y"))) return true;
            }
        }
        return false;
    }

    public static boolean full() {
        int count = 0;
        for (int row = 0, k = 1; row < length; row++) {
            for (int column = 0; column < length; column++, k++) {
                if ((board[row][column].equals("X")) || (board[row][column].equals("Y"))) count++;
            }
        }
        return count == length * length;
    }

    public static boolean checkXHorizontal() {
        for (String[] row : board) {
            int count = 0;
            for (String column : row) {
                if (column.equals("X")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXVertical() {
        for (int row = 0; row < length; row++) {
            int count = 0;
            for (String[] column : board) {
                if (column[row].equals("X")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkXDiagonal() {
        for (int row = 0, column = 0, count = 0; row < length; row++, column++) {
            if (board[row][column].equals("X")) {
                count++;
                if (count == length) return true;
            }
        }
        for (int row = 0, column = length - 1, count = 0; row < length; row++, column--) {
            if (board[row][column].equals("X")) {
                count++;
                if (count == length) return true;
            }
        }
        return false;
    }

    public static boolean checkYHorizontal() {
        for (String[] row : board) {
            int count = 0;
            for (String column : row) {
                if (column.equals("Y")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYVertical() {
        for (int row = 0; row < length; row++) {
            int count = 0;
            for (String[] column : board) {
                if (column[row].equals("Y")) {
                    count++;
                    if (count == length) return true;
                }
            }
        }
        return false;
    }

    public static boolean checkYDiagonal() {
        for (int row = 0, column = 0, count = 0; row < length; row++, column++) {
            if (board[row][column].equals("Y")) {
                count++;
                if (count == length) return true;
            }
        }
        for (int row = 0, column = length - 1, count = 0; row < length; row++, column--) {
            if (board[row][column].equals("Y")) {
                count++;
                if (count == length) return true;
            }
        }
        return false;
    }
}
