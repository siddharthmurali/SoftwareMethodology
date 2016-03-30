package pieces;

import util.Coordinates;
import board.ChessBoard;

public class RookPiece extends ChessPiece {
	
	public RookPiece(char color){
		super(color);
		this.type = "ROOK";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "R";
	}
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		boolean validityCheck = super.validMove(start, end, spec, path);
		
		if(validityCheck && path == false){
			if(start.rankC == end.rankC){
				return true;
			}else if(start.fileC == end.fileC){
				return true;
			}	
		}
		
		return false;
	}

}
