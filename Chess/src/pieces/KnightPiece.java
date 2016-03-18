package pieces;

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
	
	public boolean validMove(){
		return true;
	}

}
