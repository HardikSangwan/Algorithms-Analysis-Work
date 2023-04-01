public class ChessCheck {
	public static void main(String[] args) {
		String[][] board = new String[][]{{null, null, null, null, null, null,  "q", null},
      {null, null, null, null, null, null, null, null},
      {null, null, null, null, null,  "q", null, null},
      {null, null, null, null, null, null, null, null},
      {null, null, null,  "p",  "k", null, null,  "r"},
      { "p",  "p", null, null, null,  "n",  "p",  "p"},
      {null, null, null, null, null,  "n",  "p", null},
      {null, null, null, null, null, null, null,  "r"}};
      Board chessboard = new Board(board);
      System.out.println(chessboard);
      System.out.println(chessboard.numBlankSpaces());
      ChessPiece piece = new ChessPiece(6,7,"r");
      System.out.println(piece.getPosition());
      System.out.println(ChessPiece.parseColumnValue("C1"));
      System.out.println(ChessPiece.parseRowValue("F6"));
      chessboard.placePiece(piece);
      System.out.println(chessboard);
      System.out.println(chessboard.getPieceAt(4,4));
      System.out.println(chessboard.getPieceAt("E4"));
      System.out.println(chessboard.numBlankSpaces());
      System.out.println(chessboard.isSurrounded(chessboard.getPieceAt(5,6)));
      System.out.println(chessboard.gameOver());
	}
}