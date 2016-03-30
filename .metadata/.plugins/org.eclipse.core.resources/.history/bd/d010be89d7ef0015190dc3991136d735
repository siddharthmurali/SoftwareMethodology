package pieces;

import util.Coordinates;

public class QueenPiece extends ChessPiece{

	public QueenPiece(char color){
		super(color);
		this.type = "QUEEN";
	}


	public char getColor(){
		return color;
	}

	public String toString(){
		return super.toString() + "Q";
	}

	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){

		boolean validityCheck = super.validMove(start, end, spec, path);

		if (validityCheck && path == false) {
			if(start.rankC == end.rankC){
				return true;
			}else if(start.fileC == end.fileC){
				return true;
			}else if(start.isDiagonalTo(end)){
				return true;
			}
		}

		return false;

	}


}
