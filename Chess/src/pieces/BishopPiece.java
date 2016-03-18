package pieces;

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
	
	public boolean validMove(){
		return true;
	}

}
