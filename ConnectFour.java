/**
 * This file contains the logic for playing a connect four game
 * either against another player or a random agent, depending on
 * the given command line args.
 *
 * COLLABORATION STATEMENT HERE
 *
 * @author Hardik Sangwan
 * @author Julia Ting
 */

public class ConnectFour {

    /*
     * Static variables to use throughout printBoard()
     * and the main method. You MUST use "X" and "O",
     * so you might as well use TOKEN1 and TOKEN2 variables!
     */
    private static final int GAME_WIDTH = 7;
    private static final int GAME_HEIGHT = 6;
    private static final String TOKEN1 = "X";
    private static final String TOKEN2 = "O";

    /**
     * Alter this variable when making changes to your
     * connect four board!!
     */
    private static String[][] board = new String[GAME_HEIGHT][GAME_WIDTH];

    /**
     * This enumeration is used as outcomes for findWinner().
     *
     * Read the pdf for a complete description. Think of how
     * GameStatus.QUIT might help you in your game functionality!
     */
    private enum GameStatus {
        ONE, TWO, TIE, ONGOING, QUIT
    }

    public static void main(String[] args) {
        boolean singlePlayer = true;
        boolean playerOnesTurn = true;

        // TODO: YOUR CODE HERE
        // You should be placing the main game functionality
        // in this method.
        //
        // A couple reminders:
        //      - Any time you make a change to the Connect Four
        //        board make sure you are using the provided
        //        variable called "board"
        //      - Be sure to call printBoard() and findWinner() correctly!
        //      - Also, it's a good idea to use the provided variables,
        //        like singlePlayer and playerOnesTurn.
        //
        // Good luck and be sure to read the pdf thoroughly for all
        // the assignment requirements!

    }

    /**
     * Prints the current state of the board array.
     *
     * @return void
     **/
    private static void printBoard() {
        // TODO: YOUR CODE HERE
        // Make sure your board is printed out
        // with the required specifications!
        // See the pdf for details.
    }

    /**
     * Determines what the current result of the game is
     * given the current state of the board.
     *
     * @return GameStatus enumeration value that determines
     * if player one has won, player two has won, a tie exists,
     * or there is no result yet.
     */
    private static GameStatus findWinner() {
        if (isColumnVictory(TOKEN1) || isRowVictory(TOKEN1)
                || isTopLeftDiagonalVictory(TOKEN1)
                || isTopRightDiagonalVictory(TOKEN1)) {
            return GameStatus.ONE;
        } else if (isColumnVictory(TOKEN2) || isRowVictory(TOKEN2)
                || isTopLeftDiagonalVictory(TOKEN2)
                || isTopRightDiagonalVictory(TOKEN2)) {
            return GameStatus.TWO;
        } else if (isBoardFull()) {
            return GameStatus.TIE;
        } else {
            return GameStatus.ONGOING;
        }
    }

    /*
     * ~~~~~~YOU SHOULD NOT BE CALLING METHODS BELOW THIS POINT~~~~~
     */

    /**
     * Determines whether or not the board has any moves
     * remaining.
     *
     * @return true or false
     */
    private static boolean isBoardFull() {
        for (int col = 0; col < GAME_WIDTH; col++) {
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] == null || board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in columns.
     *
     * @return true or false
     */
    private static boolean isColumnVictory(String token) {
        for (int col = 0; col < GAME_WIDTH; col++) {
            int count = 0;
            for (int row = 0; row < GAME_HEIGHT; row++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in rows.
     *
     * @return true or false
     */
    private static boolean isRowVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            int count = 0;
            for (int col = 0; col < GAME_WIDTH; col++) {
                if (board[row][col] != null) {
                    if (board[row][col].equals(token)) {
                        count++;
                    } else {
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to left diagonals.
     *
     * @return true or false
     */
    private static boolean isTopLeftDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = 0; col < GAME_WIDTH; col++) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col + delta)
                            && board[row + delta][col + delta] != null) {
                        if (board[row + delta][col + delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determines whether or not a player has won via 4 in a row
     * in top to right diagonals.
     *
     * @return true or false
     */
    private static boolean isTopRightDiagonalVictory(String token) {
        for (int row = 0; row < GAME_HEIGHT; row++) {
            for (int col = GAME_WIDTH - 1; col >= 0; col--) {
                int count = 0;
                for (int delta = 0; delta < 5; delta++) {
                    if (withinBounds(row + delta, col - delta)
                            && board[row + delta][col - delta] != null) {
                        if (board[row + delta][col - delta].equals(token)) {
                            count++;
                        } else {
                            count = 0;
                        }
                    } else {
                        count = 0;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Small bounds checker helper method.
     */
    private static boolean withinBounds(int row, int col) {
        return (row < GAME_HEIGHT && row >= 0)
            && (col < GAME_WIDTH && col >= 0);
    }
}
