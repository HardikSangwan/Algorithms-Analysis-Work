import java.util.ArrayList;
public class Test {
    public static boolean tied(Piece[][] board) {
        int balance = 0;
        for (Piece[] row: board) {
            for (Piece piece: row) {
                if (piece != null) {
                    balance = piece.getColor().equals("light") ? balance + 1: balance - 1;
                }
            }
        }
        return balance == 0;
    }
}