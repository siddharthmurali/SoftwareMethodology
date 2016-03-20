package pieces;

public class PawnPiece extends ChessPiece {
	
	
	
	public PawnPiece(char color){
		super(color);
		this.type = "PAWN";
	}
	
	
	public char getColor(){
		return color;
	}
	
	public String toString(){
		return super.toString() + "p";
	}
	
	public boolean validMove(){
		return true;
	}
	
	

}
