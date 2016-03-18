package pieces;

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
	
	public boolean validMove(){
		return true;
	}

}
