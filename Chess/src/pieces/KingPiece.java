package pieces;

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
	
	public boolean validMove(){
		return true;
	}

}
