/**
*
*Represents a Chess Piece
*
*@author Hardik Sangwan
*@version 4.2
*
*/

public class ChessPiece {

    private int row;
    private int column;
    private String type;

    /**
    *Creates a chef with a row, column and type
    *@param row Current Row for Chess piece
    *@param column Current Column for Chess piece
    *@param type Chess piece's type
    */

    public ChessPiece(int row, int column, String type) {
        this.row = row;
        this.column = column;
        this.type = type;
    }

    /**
    *Creates a chef with a row, column and type
    *@param position Contains current row and column for piece
    *@param type Chess piece's type
    */

    public ChessPiece(String position, String type) {
        this(parseRowValue(position), parseColumnValue(position), type);
    }

    /**
    *Returns the row value of a chess piece from its position
    *@param position Contains current row and column for piece
    *@return row Current Row for Chess piece
    */

    public static int parseRowValue(String position) {
        int row = 8 - Character.getNumericValue(position.charAt(1));
        return row;
    }

    /**
    *Returns the column value of a chess piece from its position
    *@param position Contains current row and column for piece
    *@return column Current Column for Chess piece
    */

    public static int parseColumnValue(String position) {
        int column = position.charAt(0) - 'A';
        return column;
    }

    /**
    *Returns the type of a chess piece
    *@return type Type for Chess piece
    */

    public String getType() {
        return this.type;
    }

    /**
    *Returns the type of a chess piece
    *@return position Current Position for Chess piece
    */

    public String getPosition() {
        String position = String.valueOf((char) (this.column + 65))
            + String.valueOf(8 - this.row);
        return position;
    }

    @Override
    public String toString() {
        String piecename;
        switch (this.getType()) {
        case "n": piecename = "Knight";
            break;

        case "k": piecename = "King";
            break;

        case "q": piecename = "Queen";
            break;

        case "b": piecename = "Bishop";
            break;

        case "r": piecename = "Rook";
            break;

        case "p": piecename = "Pawn";
            break;

        default: piecename = "Invalid Piece Name";
        }
        return piecename + " at position " + this.getPosition() + " ("
            + this.row + ", " + this.column + ")";
    }
}