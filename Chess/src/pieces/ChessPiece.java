package pieces;

import java.util.ArrayList;

import util.Coordinates;

/**
 * 
 * 
 * @author Sid
 * @author Karthik Nair
 *
 */
public abstract class ChessPiece {
	
	public char color;
	public String type;
	public int move;
	public boolean isBlack;
	
	public ChessPiece(char color){
		this.color = color;
		this.type = null;
		this.move = 0;	
	}
	
	public String toString(){
		return this.color + "";
	}
	
	public boolean validMove(Coordinates start, Coordinates end, char spec, boolean path){
		
		float dist = (float) Math.sqrt(Math.pow(end.fileC - start.fileC, 2) + Math.pow(end.rankC - start.rankC,2));
		if(dist <= 7){
			return true;
		}else{
			return false;
		}
			
		
	}

	public ArrayList<Coordinates> deepestMovesFrom(Coordinates startAddress) {
		return null;
	}
	
}
