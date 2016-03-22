package Controller;

import board.*;
import util.Coordinates;

/**
 * @author Siddharth Murali
 * @author Karthik Nair
 *
 */

public class Controller {
	
	private board.ChessBoard board;
	
	public boolean endGame;
	
	public Controller(){
		this.board = new ChessBoard();
	}
	
	public void resignGame(){
		endGame = true;
	}
	
	public void move(char fileOne, char rankOne, char fileTwo, char rankTwo, String toPromote) throws Exception{
		Coordinates firstCoor;
		Coordinates secondCoor;
		
		if(toPromote != null){
			if(toPromote != "R" || toPromote != "B" || toPromote != "Q" || toPromote != "N"){
				System.out.println("Invalid promotion");
			}
		}
		firstCoor = new Coordinates(fileOne, rankOne);
		secondCoor = new Coordinates(fileTwo, rankTwo);
		
		if(firstCoor != null && secondCoor != null){
			board.movePiece(firstCoor, secondCoor, toPromote);
		}
	}
	
	public String getBoardString(){
		return this.board.toString();
	}
	
	public boolean blackTurn(){
		return board.getBlackTurn();
		
	}

}
