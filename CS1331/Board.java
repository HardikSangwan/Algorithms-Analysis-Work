/**
*
*Represents a Chess Board
*
*@author Hardik Sangwan
*@version 4.2
*
*/

public class Board {
    private ChessPiece[][] backingarray = new ChessPiece[8][8];

    /**
    *Creates a board with a given board
    *@param board Current state of board as a String
    */

    public Board(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    this.backingarray[i][j] = new ChessPiece(i, j, board[i][j]);
                }
            }
        }
    }

    /**
    *Checks whether a piece is completely surrounded or not
    *@param piece Given piece with its position
    *@return surrounded Whether piece is surrounded
    */

    public boolean isSurrounded(ChessPiece piece) {
        boolean surrounded = false;
        int row = ChessPiece.parseRowValue(piece.getPosition());
        int col = ChessPiece.parseColumnValue(piece.getPosition());
        if (row + 1 < 8) {
            if (col + 1 < 8) {
                if (backingarray[row + 1][col + 1] != null
                    && backingarray[row + 1][col] != null
                    && backingarray[row][col + 1] != null) {
                    surrounded = true;
                } else {
                    surrounded = false;
                }
            }
            if (col - 1 >= 0) {
                if (backingarray[row + 1][col - 1] != null
                    && backingarray[row + 1][col] != null
                    && backingarray[row][col - 1] != null) {
                    surrounded = true;
                } else {
                    surrounded = false;
                }
            }
        }
        if (row - 1 >= 0) {
            if (col + 1 < 8) {
                if (backingarray[row - 1][col + 1] != null
                    && backingarray[row - 1][col] != null
                    && backingarray[row][col + 1] != null) {
                    surrounded = true;
                } else {
                    surrounded = false;
                }
            }
            if (col - 1 >= 0) {
                if (backingarray[row - 1][col - 1] != null
                    && backingarray[row - 1][col] != null
                    && backingarray[row][col - 1] != null) {
                    surrounded = true;
                } else {
                    surrounded = false;
                }
            }
        }
        return surrounded;
    }

    /**
    *Places a piece at a given position, if the position is empty
    *@param piece Piece with its position data
    */

    public void placePiece(ChessPiece piece) {
        int row = ChessPiece.parseRowValue(piece.getPosition());
        int col = ChessPiece.parseColumnValue(piece.getPosition());
        if (this.backingarray[row][col] == null) {
            this.backingarray[row][col] = piece;
        }
    }

    /**
    *Returns the piece at a given position
    *@param row Current Row for Chess piece
    *@param column Current Column for Chess piece
    *@return piece Type of Piece at given postion
    */

    public ChessPiece getPieceAt(int row, int column) {
        return this.backingarray[row][column];
    }

    /**
    *Returns the piece at the given position
    *@param position Position to Check
    *@return Calls to getPieceAt(int row, int column)
    */

    public ChessPiece getPieceAt(String position) {
        return this.getPieceAt(ChessPiece.parseRowValue(position),
            ChessPiece.parseColumnValue(position));
    }

    /**
    *Counts the number of blank spaces on the board
    *@return numblankspaces Number of Blank Spaces
    */

    public int numBlankSpaces() {
        int numblankspaces = 0;
        for (int i = 0; i < this.backingarray.length; i++) {
            for (int j = 0; j < this.backingarray[0].length; j++) {
                if (this.backingarray[i][j] == null) {
                    numblankspaces++;
                }
            }
        }
        return numblankspaces;
    }

    /**
    *Checks whether the game is over based on the number of kings left
    *@return over Whether the game is over or not
    */

    public boolean gameOver() {
        boolean over = false;
        int k = 0;
        for (int i = 0; i < this.backingarray.length; i++) {
            for (int j = 0; j < this.backingarray[0].length; j++) {
                if (this.backingarray[i][j] != null) {
                    if (this.backingarray[i][j].getType().equals("k")) {
                        k++;
                    }
                }
            }
        }
        if (k == 1) {
            over = true;
        }
        return over;
    }

    @Override
    public String toString() {
        String board = new String();
        for (int i = 0; i < this.backingarray.length; i++) {
            board = board + "---------------------------------\n";
            for (int j = 0; j < this.backingarray[0].length; j++) {
                if (this.backingarray[i][j] == null) {
                    board = board + "|   ";
                } else {
                    board = board + "| "
                        + this.backingarray[i][j].getType() + " ";
                }
            }
            board = board + "|\n";
        }
        board = board + "---------------------------------\n";
        return board;
    }
}