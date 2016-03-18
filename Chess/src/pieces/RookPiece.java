package pieces;

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
	
	public boolean validMove(){
		return true;
	}

}
