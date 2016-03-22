package pieces;
import util.Coordinates;

public class BishopPiece extends ChessPiece{
	
	public BishopPiece(char color){
		super(color);
		this.type = "BISHOP";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "B";
	}
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		boolean validityCheck = super.validMove(start, end, spec, path);
		
		if(validityCheck && path == false){
			if(start.isDiagonalTo(end)){
				return true;
			}
		}
		
		return false;
		
	}

}
