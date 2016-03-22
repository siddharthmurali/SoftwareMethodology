package pieces;

import util.Coordinates;

public class KingPiece extends ChessPiece{
	
	public KingPiece(char color){
		super(color);
		this.type = "KING";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "K";
	}
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		boolean validityCheck = super.validMove(start, end, spec, path);
		
		if(validityCheck && path == false){
			if(start.isAdjacentTo(end)){
				return true;
			}
		}
		
		return false;
	}

}
