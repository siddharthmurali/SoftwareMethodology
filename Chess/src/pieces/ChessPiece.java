package pieces;


import java.util.ArrayList;

import board.BoardSquares;
import util.Coordinates;

/**
 * 
 * 
 * @author Sid
 * @author Karthik Nair
 *
 */
public abstract class ChessPiece {
	
	public char color;
	public String type;
	public int move;
	public boolean isBlack;
	
	public ChessPiece(char color){
		this.color = color;
		this.type = null;
		this.move = 0;	
	}
	
	public String toString(){
		return this.color + "";
	}
	
	public boolean validMove(){
		return true;
	}

	public ArrayList<Coordinates> deepestMovesFrom(Coordinates startAddress) {
		return null;
	}

	public boolean MoveValid(Coordinates begin, Coordinates end, PieceBoolFalse allBools) {
		if (begin.distanceFrom(end) <= 7) {
			return true;
		} else {
			return false;
		}
	}
	
}
