package board;
import pieces.*;

import pieces.BishopPiece;
import pieces.KingPiece;
import pieces.KnightPiece;
import pieces.PawnPiece;
import pieces.QueenPiece;
import pieces.RookPiece;
import util.Coordinates;

public class ChessBoard {
	
	public static final int rank = 8;
	public static final int file = 8;
	public BoardSquares[][] board;
	public boolean isBlackTurn = true;
	
	public ChessBoard(){
		
		board = new BoardSquares[rank][file];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardSquares(new Coordinates(i, j), null);
				
			}
		}
		
		this.loadGameBoard();
	
	}
	
	public void loadGameBoard(){
		
		char color = 0;
		
		for(int i = 0; i < file; i++){
			
			for(int j = 0; j < rank; j++){
				
				if(i == 0 || i == 7){
					
					if(i == 0){
						color = 'w';
					}else{
						color = 'b';
					}
					
					
					switch(j){
					
					case 0: board[i][j].piece = new RookPiece(color);			
							break;
					case 1: board[i][j].piece = new KnightPiece(color);
							break;
					case 2: board[i][j].piece = new BishopPiece(color);
							break;
					case 3: board[i][j].piece = new QueenPiece(color);
							break;
					case 4: board[i][j].piece = new KingPiece(color);
							break;
					case 5: board[i][j].piece = new BishopPiece(color);
							break;	
					case 6: board[i][j].piece = new KnightPiece(color);
							break;
					case 7: board[i][j].piece = new RookPiece(color);
							break;
					default: break;
					}
				}
				else if(i == 1 || i == 6){
					if(i == 1){
						color = 'w';
					}else{
						color = 'b';
					}
					board[i][j].piece = new PawnPiece(color);
				}
			}
		}
	
	}
	
	public String toString() {
		String str = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				str += this.board[i][j].toString() + " ";
			}

			str += (i + 1) + "\n";
		}

		str += " a  b  c  d  e  f  g  h\n";

		return str;
	}
	
	public boolean getBlackTurn(){
		return !isBlackTurn;
	}

}
