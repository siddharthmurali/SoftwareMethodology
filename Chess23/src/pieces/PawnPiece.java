package pieces;
import util.Coordinates;
import board.*;

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
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		
		boolean validityCheck = super.validMove(start, end, spec, path);

		
		if(validityCheck){
		
		if(spec == 'c' && (start.rankC - 1 == end.rankC || start.rankC + 1 == end.rankC)){
				if(this.color == 'b'){
					return (start.fileC + 1 == end.fileC);
				}else{
					return (start.fileC - 1 == end.fileC);
				}
			}
		}
		
		if(this.move == 0){
			if(start.fileC == end.fileC){
				if(this.color == 'b'){
					return (start.rankC + 1 == end.rankC || start.rankC + 2 == end.rankC);
				}else{
					return (start.rankC - 1 == end.rankC || start.rankC - 2 == end.rankC);
				}
				
			}
		}else{
			if(this.color == 'b'){
				return (start.rankC + 1 == end.rankC);
			}else{
				return (start.rankC - 1 == end.rankC);
			}
		}
		
		
		
		return false;
	}	

}
