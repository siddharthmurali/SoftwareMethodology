package board;

import pieces.ChessPiece;


import util.Coordinates;

/**
 * 
 * 
 * @author Siddharth Murali
 * Karthik Nair
 *
 */
public class BoardSquares {
	
	public Coordinates curr;
	public ChessPiece piece;
	
	
	//uses coordinates(rank and file), and current chess piece(if any)
	public BoardSquares(Coordinates curr, ChessPiece piece){
		this.curr = curr;
		this.piece = piece;
	}
	
	//checks if the space is occupied
	public boolean isEmpty(){
		return this.piece == null;
	}
	
	
	//in order to print out the boardsquares
	public String toString(){
		if (this.piece == null) {
			if ((this.curr.fileC % 2 == 0 && this.curr.rankC % 2 == 0) || (this.curr.fileC % 2 != 0 && this.curr.rankC % 2 != 0)) {
				return "  ";
			} else {
				return "##";
			}
		} else {
			return this.piece.toString();
		}
	}
	

}
