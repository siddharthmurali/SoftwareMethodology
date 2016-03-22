package pieces;

import util.Coordinates;

/**
 * 
 * 
 * @author Siddharth Murali
 * @author Karthik Nair
 *
 */

public class KnightPiece extends ChessPiece {
	
	public KnightPiece(char color){
		super(color);
		this.type = "KNIGHT";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "N";
	}
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		
		boolean validityCheck = super.validMove(start, end, spec, path);

		if (validityCheck) {
			if (start.rankC + 2 == end.rankC || start.rankC - 2 == end.rankC) {
				if (start.fileC + 1 == end.fileC
						|| start.fileC - 1 == end.fileC) {
					return true;
				}
			} else if (start.fileC + 2 == end.fileC
					|| start.fileC - 2 == end.fileC) {
				if (start.rankC + 1 == end.rankC
						|| start.rankC - 1 == end.rankC) {
					return true;
				}
			}
		}

		return false;

	}

}
